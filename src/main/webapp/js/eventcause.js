	getAllEvents();


function getAllEvents(){
	$.ajax({
		  type: 'GET',
		  url: 'rest/eventCause/',
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
	
}

function handleResponseJQuery(myData) {
	
	for(var i = 0 ; i <myData.length; i++){
		
		 $('#table-body').append(
                "<tr>" +
                "<td>" + myData[i].causeCode + "</td>" +
                "<td>" + myData[i].eventId + "</td>" +
                "<td>" + myData[i].description + "</td>" +
                "</tr>");
            };
		
}