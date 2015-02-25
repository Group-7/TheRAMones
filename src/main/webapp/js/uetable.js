//Andrew UE_Table   uetable.html

$("#infoBtn").click(function() {

	getAllUE();

});

function getAllUE() {
	$.ajax({
		type : 'GET',
		url : 'rest/UE_Table/',
		success : handleResponseJQuery,
		contentType : 'application/json'
	});

}

function handleResponseJQuery(myData) {

	for (var i = 0; i < myData.length; i++) {

		$('#table-body').append(
				"<tr>" + "<td>" + myData[i].tac + "</td>" + "<td>"
						+ myData[i].vendorName + "</td>" + "<td>"
						+ myData[i].model + "</td>" + "<td>" + myData[i].ueType
						+ "</td>" + "<td>" + myData[i].operatingSystem
						+ "</td>" + "<td>" + myData[i].inputMode + "</td>"
						+ "</tr>");
	}
	;
}



