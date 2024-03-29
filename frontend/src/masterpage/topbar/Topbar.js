import css from "./Topbar.module.css"
import { Link } from "react-router-dom";
import { useState } from "react";


function Topbar(props) {



function onLogClick() {
   if (props.logInText==="Log Out") {
    props.logOut();

   }
}


  function onLogIn() {

  }

    return (
    <div className={css.top_bar}>
    <div className={css.div1}>MMC Reporting</div>
    <div className={css.div2}><div><Link style={{color: '#dddcdc'}} to="/house">House</Link></div><div>Menu2</div><div>Menu3</div><div>Menu4</div><div>Menu5</div></div>
    <div className={css.div3}><Link style={{color: '#dddcdc'}} to="/login" onClick={onLogClick} >{props.logInText}</Link></div>
    </div>
  );
}

export default Topbar;