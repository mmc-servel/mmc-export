
package com.mmc.processors;

import com.mmc.backend.MainClass;
import com.mmc.db.DB1;
import com.mmc.responce.AResponce;
import com.mmc.responce.StringResponce;
import com.sun.net.httpserver.HttpExchange;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRSwapFile;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.json.JSONObject;


public class ReportProcessor extends AAPIProcessor{

    public ReportProcessor(HttpExchange t) {
        super(t);
    }

    @Override
    public AResponce processRequest() throws Exception {
        System.out.println("    "+new Timestamp(System.currentTimeMillis())+"    Start report Generation");
        JSONObject requestBodyJson = getrequestBodyString();
        Map parameter = new HashMap();
        parameter.put("p_pan_masked", requestBodyJson.getString("panmask"));
        parameter.put("p_start_date", requestBodyJson.getString("startdate"));
        parameter.put("p_end_date", requestBodyJson.getString("enddate"));
        InputStream is = MainClass.class.getClassLoader().getResourceAsStream("WEB-INF/report/AuthorizationHistory.jrxml");
        
        JasperDesign jdesign = JRXmlLoader.load(is);
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        
        JRSwapFileVirtualizer virtualizer = new JRSwapFileVirtualizer(3, new JRSwapFile("c:\\tmp", 2*1024*1024, 4), false); //TO DO: analyze to use dinamic parameters depend on report/dataset size.
        parameter.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);

        DB1 db = new DB1();
        JasperPrint jprint = JasperFillManager.fillReport(jreport, parameter, db.getConnection());
        System.out.println("    "+new Timestamp(System.currentTimeMillis())+"    Start export to pdf");
        JasperExportManager.exportReportToPdfFile(jprint, "c:\\tmp\\AuthorizationHistory.pdf");
        System.out.println("    "+new Timestamp(System.currentTimeMillis())+"    End export to pdf");
        return new StringResponce(t, "OK", "Report succesfully generated.", "{\"filename\":\"AuthorizationHistory.pdf\"}");
    }
    
}
