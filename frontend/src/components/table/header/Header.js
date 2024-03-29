import classes from "./Header.module.css";
import Cell from "./cell/Cell";

function Header(props) {
  return (
    <div className={classes.table_header}>
      {props.header.map((head) => (
        <Cell cellHead={head} />
      ))}
    </div>
  );
}

export default Header;
