
import cssmodule from "./HouseContent.module.css";
import MenuLine from "./menu/MenuLine";
import General from "./contentdetails/General";
import Financial from "./contentdetails/Financial";
import Istoric from "./contentdetails/Istoric";
import { useState } from "react";

function HouseContent(props) {

  const [dummy, setDummy] = useState("i1");/* initialization with id1 */
  function refreshContent(page_to_show) {
    setDummy(page_to_show);
    console.log(page_to_show); 
  }
  return (
    <div className="div_block_area" style={{ width: "40%" }} >  

    <MenuLine refreshContent={refreshContent} />

    { dummy === "i1" ? <General/> : ""}     {/* here 'id1'..'id3' comes from filr MenuLine.is props.refreshContent(rrr.currentTarget.id); */}
    
    { dummy ==="i2" ? <Financial/> : ""}  
    { dummy ==="i3" ? <Istoric/> : ""}  
    
  </div>
  );
}

export default HouseContent;
