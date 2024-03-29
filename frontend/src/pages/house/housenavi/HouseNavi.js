import cssmodule from "./HouseNavi.module.css";
import GlobalCss from "../../../components/css/global.css";
import { Link } from "react-router-dom";

function HouseNavi(props) {
  return (
          <div className="div_block_area"  style={{width:"15%"}}> 
            <p>  <Link to="/transations">MAIB Auth Report</Link> </p> 
            <p>  <Link to="/merchants">Placeholder Report</Link> </p> 
          </div>
  );
}

export default HouseNavi;

/*
<ul id="myUL">
  <li><span class="caret">Bucuria10</span>
    <ul class="nested">

      <li><span class="caret">Scara1</span>
        <ul class="nested">
          <li><span class="caret">Etaj1</span>
            <ul class="nested">
              <li>Ap1</li>
              <li>Ap2</li>
              <li><span class="caret">Ap3</span>
            <ul class="nested">
              <li>Debara</li>
              <li>Parcare</li>
            </ul>
          </li>
              <li>Ap4</li>
            </ul>
          </li>
          <li><span class="caret">Etaj2</span>
            <ul class="nested">
              <li>Ap5</li>
              <li>Ap6</li>
              <li>Ap7</li>
              <li>Ap8</li>
            </ul>
          </li>          
        </ul>
      </li>

      <li><span class="caret">Scara2</span>
        <ul class="nested">
          <li><span class="caret">Etaj1</span>
            <ul class="nested">
              <li>Ap53</li>
              <li>Ap54</li>
              <li>Ap55</li>
              <li>Ap56</li>
            </ul>
          </li>
        </ul>
      </li>
      
    </ul>
  </li>
</ul>
*/
