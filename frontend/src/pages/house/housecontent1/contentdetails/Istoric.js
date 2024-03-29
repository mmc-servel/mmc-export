import cssmodule from "./Istoric.module.css";
import Tttt from "../../../../components/table/Table";

let accounts = {
  table: {
    header: [
      { colname: "fullname", label: "Full Name", width: "45%", iskey: "N" ,ishidden:"N",valuelist:["1","2","3"]},
      { colname: "profession", label: "User Activity", width: "45%", iskey: "N" ,ishidden:"N",valuelist:["1","2","3"]},
      { colname: "id", label: "ID", width: "10%", iskey: "Y" ,ishidden:"Y",valuelist:["a","b","c"]}
    ],
    data:[
      ["Sergiu Velescu","Data Engineer","1"],
      ["Vinaga Victor","Data Engineer","2"],
      ["Adrian-Donos Ivanovici","Data Engineer abra ca dabra","3"],
      ["Viorel Contu","Java Developer","4"],
    ]
  },
};

function Istoric(props) {
  return (
    <div className={cssmodule.menu_content_div}>
      <Tttt table={accounts.table}/>
    </div>
  );
}

export default Istoric;
