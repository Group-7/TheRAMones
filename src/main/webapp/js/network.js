//$("#infoBtn").click(function() {
$(document).ready(function(){	
	handleResponseJQuery(document);
	handleResponseJQuery();

});

function getAllthePeople(){
	$.ajax({
		  type: 'GET',
		  url: 'rest/network/',
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
	
}

function handleResponseJQuery(myData) {
	
	for(var i = 0 ; i <myData.length; i++){
	
		 $('#table-body').append(
                 "<tr>" +
                 "<td>" + myData[i].mcc + "</td>" +
                 "<td>" + myData[i].mnc + "</td>" +
                 "<td>" + myData[i].country + "</td>" +
                 "<td>" + myData[i].operator + "</td>" +
                 "</tr>");
             };
		
}