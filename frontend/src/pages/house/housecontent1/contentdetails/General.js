import cssmodule from "./General.module.css";

function General(props) {

  const onButtonClick = (theButton) => {
    fetch('report', { method: 'POST', body: JSON.stringify({'reportname':'AuthorizationHistory.pdf', 'startdate': document.getElementById("startdate").value.trim() ,'enddate': document.getElementById("enddate").value.trim(),'panmask': document.getElementById("panmask").value.trim() }), headers: { 'Content-Type': 'application/json' } }).then((response) => {
      return response.json();
    }).then((data) => {        
      processLoginResponce(data);
    });
  };  
 
  function processLoginResponce(data) {
    if(data.responce==="OK"){
      window.open('file/AuthorizationHistory.pdf');
    }else{
      {/* TO DO Process the output/error and show the error message */}
      console.log('Error generating pdf file.');
    }
  }
  
  return (
    <div className={cssmodule.menu_content_div}>

      <div className={cssmodule.left_div}>
      <p>Tran Date:</p>
      <p>Birth Date:</p>
      <p>Merch ID:</p>      
      </div>

      <div className={cssmodule.right_div}>
      <p><input type="date" id="startdate" /></p>
      <p><input type="date" id="enddate" /></p>
      <p><input type="input" id="panmask" placeholder="1234*****9876"/></p>
      <button onClick={onButtonClick.bind(this)}> Generate </button>
      </div>

      </div>       

  );
}

export default General;
