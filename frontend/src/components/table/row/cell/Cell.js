import classes from "./Cell.module.css";

function Cell(props) {
  return (
    <div
      className={classes.data_cell} style={{width: props.cellMeta.width,cursor: props.cellMeta.iskey == "Y" ? "pointer" : "arrow",}}>
      <span>{props.cellMeta.iskey == "Y" ? "---" : props.cellData}</span>
      {props.cellMeta.iskey == "Y" ? (
        <div className={classes.id_menu_items}>
          <span>Edit</span>
          <span>Delete</span>
        </div>) : ("")}
    </div>
  );
}

export default Cell;
