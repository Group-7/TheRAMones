$("#infoBtn").click(function() {

	getAllUsers();

});

function getAllUsers() {
	$.ajax({
		type : 'GET',
		url : 'rest/users/',
		success : handleResponseJQuery,
		contentType : 'application/json'
	});

}

function handleResponseJQuery(myData) {

	for (var i = 0; i < myData.length; i++) {

		$('#table-body').append(
				"<tr>" + "<td>" + myData[i].email + "</td>" + "<td>"
						+ myData[i].password + "</td>" + "<td>"
						+ myData[i].type 
						+ "</tr>");
	}
	;
}



