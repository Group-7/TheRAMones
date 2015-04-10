/*$("#infoBtn").click(function() {

	getAllUsers();

});*/
window.onload = function() {

	getAllUsers();
	loadSideBar();
}

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

		$('#table-body-users').append(
				"<tr>" + "<td>" + myData[i].email + "</td>" + "<td>"
						+ myData[i].password + "</td>" + "<td>"
						+ myData[i].type + "</tr>");
	}
	;
}
