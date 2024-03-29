import classes from "./Table.module.css";
import Header from "./header/Header";
import Row from "./row/Row";

function Table(props) {
  return (
    <div className={classes.prod_table}>
      <Header header={props.table.header}/>
      
      {props.table.data.map((head) => (
        <Row rowData={head} rowMeta={props.table.header}/>
      ))}

    </div>
  );
}

export default Table;
