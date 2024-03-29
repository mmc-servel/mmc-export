function TableRowsCell(props) {

  let localFont=props.isHeader==="Y"?"bold":"normal"
  //let localWidth=props.isHeader=="Y"?"100%":props.width

  return (<div style={{width:props.width, fontWeight:localFont}}>

    {props.cell}
  </div>
  );
}

export default TableRowsCell;
