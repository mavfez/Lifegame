

function validate_login(){
	
	var username = document.getElementById("login").value;
	var password = document.getElementById("password").value;
	var users = ["mavfez", "hcsalced", "wriascos", "dannyfuv", "tsilifegame", "AGuzmanN", "jgriverosb", "jonerruiz", "napoleonmr" ];
	var userOk = isInArray(username, users);
	if(userOk){
		if ( password === "tsi123"){
			window.location = "main.jsf";
		}else{
			alert ("Invalid User or Password");
		}
	}else{
		alert ("Invalid User or Password, please check if you are sing up");
	}
}

function isInArray(value, array) {
  return array.indexOf(value) > -1;
}