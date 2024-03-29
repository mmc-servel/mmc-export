import css from "./Login.module.css"

function Login(props) {

  const onButtonClick = (theButton) => {
    let dddddd ={
      responce:"OK",
      data:{sessionid:"uidhsaiudhiusa"}
    }
    processLoginResponce(dddddd);
    return dddddd;
    fetch('api/login', { method: 'POST', body: JSON.stringify({ 'username': document.getElementById("uname").value.trim() ,'password': document.getElementById("upass").value.trim() }), headers: { 'Content-Type': 'application/json' } }).then((response) => {
      return response.json();
    }).then((data) => {        
      processLoginResponce(data);
    });
  };  

  
  function processLoginResponce(data) {
    if(data.responce==="OK"){
      props.onLogin(data.data.sessionid);
      //window.open('file/aaa.pdf');
    }else{
      props.onLogin("aaa");
    }
    /* history.replace("/");*/    
  }

    return (
        <div className={css.login}>
          <center><p>Log In</p></center>
          <p className={css.label_format}>Username</p>
          <input type="email" id="uname" className={css.input_format}/>

          <p className={css.label_format}>Password</p>
          <input type="password" id="upass" className={css.input_format}/>   
          <p></p>
          <p>Open a PDF file <a href="/file.pdf">example</a>.</p>
          <center><button className={css.input_buton} onClick={onButtonClick.bind(this)}>LogIn</button> </center>      
        </div>
  );
}

export default Login;