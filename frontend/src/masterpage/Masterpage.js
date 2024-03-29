import css from "./Masterpage.module.css"
import Topbar from "./topbar/Topbar"

function Masterpage(props) {
    return (
    <div>
      <Topbar sessionid={props.sessionid} logInText={props.logInText} logOut={props.logOut}/>
      <div className={css.content}>
           {props.children}
      </div>
    </div>
  );
}

export default Masterpage;