import classes from "./Row.module.css";
import Cell from "./cell/Cell";

function Row(props) {
  return (
    <div className={classes.row_data}>
      {props.rowData.map((cellData,index) => (
        <Cell  cellData={cellData} cellMeta={props.rowMeta[index]}/>
      ))}
    </div>
  );
}

export default Row;
