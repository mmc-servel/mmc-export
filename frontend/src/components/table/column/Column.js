import classes from "./Column.module.css";

function Column(props) {
  function onDeleteHandler(product_id) {
    alert(product_id);
  }

  return (
    <div className={classes.table_column} style={{ width: props.head.width }}>
      {props.head.label}
    </div>
  );
}

export default Column;
