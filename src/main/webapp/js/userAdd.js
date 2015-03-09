$('#addUserBut').on('click', function() {
    var $username = $('#email').val();
    var $pwd = $('#pwd').val();
    var $admin = 1;
    var $position = $('#menu').val();


    var user = {
        email: $username,
        password: $pwd,
        type: $position
    };
 var valid = validate($username, $pwd);
	 if(valid){
    $.ajax({
        type: 'POST',
        url: 'rest/users/addUser',
        contentType: 'application/json',
        data: JSON.stringify({
            "email": $username,
            "password": $pwd,
            "type": $position
        }),
        async: false,

        success: function() {
            $("#error").text("User added ");
        },

        error: function() {

            $("#error").text("This user already exists");

        }


    });
    }

});


function validate(username, password) {

    //username
    var valid = true;
    if (username.length < 4) {
        alert("Username not valid");
        valid = false;
    }

    //password
    if (password.length < 6) {
        alert("Password should have at least 6 characters");
        valid = false;
    }

    if (!valid) {
        return false;
    }

    return true;

}