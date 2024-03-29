import css from "./House.css";
import cssmodule from "./House.module.css";
import HouseNavi from "./housenavi/HouseNavi"
import HouseContent from "./housecontent/HouseContent"
import HouseContent1 from "./housecontent1/HouseContent"
import { Route, Switch } from "react-router-dom";

function House(props) {
  return (
    <div className={cssmodule.top_div}>

      <HouseNavi/>
      

      <Switch>
        <Route path="/transations" exact> <HouseContent/> </Route>                      
        <Route path="/merchants" exact>  <HouseContent1/></Route> 
      </Switch>

    </div>
  );
}

export default House;
