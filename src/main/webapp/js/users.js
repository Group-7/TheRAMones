//$("#seeUsers").click(function() {
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
             data:JSON.stringify({ "email": email, "password" : password }),
             success: function (userData) {

                 if (userData == null) {
                     $("#error").text("Sorry, there was a problem with your login or password");
                 }
                 else {
                	 alert("GRGR");
                	 $("#error").text("Hello " + userData.email);
                	 window.location.href="eventcause.html";
                 }
             }
         });
	 }
	 
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