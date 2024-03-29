import classes from "./Cell.module.css";

function Cell(props) {
  return (
    <div className={classes.header_cell} style={{ width: props.cellHead.width }}>
         {props.cellHead.label}
    </div>
  );
}

export default Cell;