$('#addUserBut').on('click', function() {
	var $username = $('#email').val();
	var $pwd = $('#pwd').val();
	var $admin =1;
	var $position = $('#menu').val();
	
	
		var user = {
			email: $username,
			password: $pwd,
			type: $position
		};

		$.ajax({
			type: 'POST',
			url: 'rest/users/addUser',
			contentType: 'application/json',
			data: JSON.stringify(user),
			success: alert($position)
			
		});

});


	

