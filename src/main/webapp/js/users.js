/*
$(document).ready(function(){
	showAllUsers();

});

function showAllUsers(){
	$.ajax({
		  type: 'GET',
		  url: 'rest/users/',
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
	
}



function handleResponseJQuery(myData) {
	
	for(var i = 0 ; i <myData.length; i++){
	
		 $('#table-body-users').append(
                 "<tr>" +
                 "<td>" + myData[i].email + "</td>" +
                 "<td>" + myData[i].password + "</td>" +
                 "<td>" + myData[i].type + "</td>" +
                 "</tr>");
             };
		
}


$('#buttonJ').click(function(){
	var email = $('#email').val();
	var password = $('#password').val();
	
	 var valid = validate(email, password);
	 if(valid){
		 $.ajax({
			 type: "POST",
             url: 'rest/users/auth',
             contentType: 'application/json',
             data:JSON.stringify({ "email": email, "password" : password, "type":1 }),
             success: function (userData) {

                 if (userData == null) {
                     $("#error").text("Sorry, there was a problem with your login or password");
                 }
                 else {
                	 alert("You succesfully logged in");
                	 $("#error").text("Hello " + userData.email);
                	window.location.href="http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/dashboard.html";
                 }
             }
         });
	 }
	 
});

$('#addUserBut').on('click', function() {
	var $username = $('#email').val();
	var $pwd = $('#pwd').val();
	var $admin =1;
	var $position = $('#dropdownMenu1');

		var user = {
			email: $username,
			password: $pwd,
			type: $admin
		};

		$.ajax({
			type: 'POST',
			url: 'rest/users/addUser',
			contentType: 'application/json',
			data: JSON.stringify(user),
			success: alert("WORKS")
			
		});
});

function validate(username, password) {

    //username
    var valid = true;
    if (username.length == 0) {
        $("input[name=email]").css("border", "1px solid red");
        $("input[name=email]").css("margin-left", "9px");
        valid = false;
    }

    //password
    if (password.length == 0) {
        $("input[name=password]").css("border", "1px solid red");
        $("input[name=password]").css("margin-left", "9px");
        valid = false;
    }

    if (!valid) {
        return false;
    }

    return true;
}

//copied from gerry to avoid conflicts
function handleResponseJQuery(myData) {

	for (var i = 0; i < myData.length; i++) {

		$('#table-body-users').append(
				"<tr>" + "<td>" + myData[i].email + "</td>" + "<td>"
						+ myData[i].password + "</td>" + "<td>"
						+ myData[i].type 
						+ "</tr>");
	}
	;
}
//copied from gerry to avoid conflicts
function handleResponseJQuery(myData) {

	for (var i = 0; i < myData.length; i++) {

		$('#table-body-users').append(
				"<tr>" + "<td>" + myData[i].email + "</td>" + "<td>"
						+ myData[i].password + "</td>" + "<td>"
						+ myData[i].type 
						+ "</tr>");
	}
	;
}
*/



$(document).ready(function(){
	showAllUsers();

});

function showAllUsers(){
	$.ajax({
		  type: 'GET',
		  url: 'rest/users/',
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
	
}



function handleResponseJQuery(myData) {
	
	for(var i = 0 ; i <myData.length; i++){
	
		 $('#table-body-users').append(
                 "<tr>" +
                 "<td>" + myData[i].email + "</td>" +
                 "<td>" + myData[i].password + "</td>" +
                 "<td>" + myData[i].type + "</td>" +
                 "</tr>");
             };
		
}

function login() {
	alert("logging");
	var email = $('#email').val();
	var password = $('#password').val();
	
	 var valid = validate(email, password);
	 if(valid){
	 alert("valid");
	 
		 $.ajax({
			 type: "POST",
             url: 'rest/users/auth',
             contentType: 'application/json',
             data:JSON.stringify({ "email": email, "password" : password, "type":1 }),
             success: function (userData) {


                 if (userData == null) {
                     alert("Sorry, there was a problem with your login or password");
                 }
                 else {
                	  alert("You succesfully logged in");
                	 $("#error").text("Hello " + userData.email);
                	window.location.href="http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/dashboard.html";
                 }
             }
         });
	 }

}

$('#buttonJ').click(function(){

	var email = $('#username').val();
	var password = $('#password').val();
	
	 var valid = validate(email, password);
	 if(valid){
		 $.ajax({
			 type: "POST",
             url: 'rest/users/auth',
             contentType: 'application/json',
             data:JSON.stringify({ "email": email, "password" : password, "type":1 }),
             success: function (userData) {

				
                 if (userData == null) {
                     alert("Sorry, there was a problem with your login or password");
                 }
                 else {
                	  alert("You succesfully logged in");
                	 
                	 if(userData.type==1){
                		 window.location.href="http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/dashboard.html";
                	 }
                	 else if(userData.type==2){
                		 window.location.href="http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rep_dashboard.html";
                	 }
                	 else if(userData.type==3){
                		 window.location.href="http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/support_dashboard.html";
                	 }
                	 else if(userData.type==4){
                		 window.location.href="http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/network_dashboard.html";
                	 }
                 }
             }
         });
	 }
	 
});

$('#addUserBut').on('click', function() {
	var $username = $('#email').val();
	var $pwd = $('#pwd').val();
	var $admin =1;
	var $position = $('#dropdownMenu1');

		var user = {
			email: $username,
			password: $pwd,
			type: $admin
		};

		$.ajax({
			type: 'POST',
			url: 'rest/users/addUser',
			contentType: 'application/json',
			data: JSON.stringify(user),
			success: alert("WORKS")
			
		});
});

function validate(username, password) {
	
    //username
    var valid = true;
    if (username.length == 0) {
        $("input[name=email]").css("border", "1px solid red");
        $("input[name=email]").css("margin-left", "9px");
        valid = false;
    }

    //password
    if (password.length == 0) {
        $("input[name=password]").css("border", "1px solid red");
        $("input[name=password]").css("margin-left", "9px");
        valid = false;
    }

    if (!valid) {
        return false;
    }
	
    return true;
}

//copied from gerry to avoid conflicts
function handleResponseJQuery(myData) {

	for (var i = 0; i < myData.length; i++) {

		$('#table-body-users').append(
				"<tr>" + "<td>" + myData[i].email + "</td>" + "<td>"
						+ myData[i].password + "</td>" + "<td>"
						+ myData[i].type 
						+ "</tr>");
	}
	;
}
//copied from gerry to avoid conflicts
function handleResponseJQuery(myData) {

	for (var i = 0; i < myData.length; i++) {

		$('#table-body-users').append(
				"<tr>" + "<td>" + myData[i].email + "</td>" + "<td>"
						+ myData[i].password + "</td>" + "<td>"
						+ myData[i].type 
						+ "</tr>");
	}
	;
}