import classes from "./TableRowsCellControl.module.css";

function TableRowsCellControl(props) {
//<img src="https://img.icons8.com/office/30/000000/cancel.png" width="20px" height="20px"/>


function deleteProduct(product_id) {
  fetch('api/products/delete', { method: 'POST', body: JSON.stringify({"product_id":product_id}), headers: { 'Content-Type': 'application/json' } }).then((response) => {
    return response.json();
  }).then((data) => {
    if(data.responce!=="OK"){
      alert(data.message);
      return;
    }

  });
}

function onDeleteHandler(product_id){
  deleteProduct(product_id)
  props.getProductsRequest();
  //props.onDeleteHandler(product_id);
}

  return (<div className={classes.prod_tablerow_control} >
    <img className={classes.container1} src="./../../images/edit.gif" width="20px" height="20px"  />
    <img className={classes.container1} src="./../../images/delete_active.jpg" width="20px" height="20px" onClick={() => onDeleteHandler(props.product_id)}/>
  </div>
  );
}

export default TableRowsCellControl;
