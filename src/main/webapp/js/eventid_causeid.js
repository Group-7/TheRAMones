//$("#infoBtn").click(function() {
$(document).ready(function(){	
	getAllEvents();
});

function getAllEvents(){
	$.ajax({
		  type: 'GET',
		  url: 'rest/baseData/eventid_causeid/',
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
	
}

function handleResponseJQuery(myData) {
	
	for(var i = 0 ; i <myData.length; i++){
	
		 $('#table-body').append(
                 "<tr>" +
                 "<td>" + myData[i][0] + "</td>" +
                 "<td>" + myData[i][1] + "</td>" +
                 "<td>" + myData[i][2] + "</td>" +
                 "</tr>");
             };
		
}