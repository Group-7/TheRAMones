$( document ).ready(function() {
	getAllFailures();
});



function getAllFailures() {
	$.ajax({
		type : 'GET',
		url : 'rest/failureCause/',
		success : handleResponseJQuery,
		contentType : 'application/json'
	});

}

function handleResponseJQuery(myData) {

	for (var i = 0; i < myData.length; i++) {

		$('#table-body').append(
				"<tr>" + "<td>" + myData[i].description + "</td>" + "<td>"
						+ myData[i].failureCode + "</td>" + "<td>"
						+ "</tr>");
	}
	;
}