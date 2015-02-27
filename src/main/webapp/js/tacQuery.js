$("#displayBtn").click(function() {
	
	getAllCallFailures();

});


$("#displayBtn2").click(function() {
	
	getAllCallFailures2();

});




function getAllCallFailures(){
	$.ajax({
		  type: 'GET',
		  url: 'rest/baseData/tacFailures?TAC=33000153',
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
	
}

function getAllCallFailures2(){
	$.ajax({
		  type: 'GET',
		  url: 'rest/baseData/tacFailures?TAC=21060800',
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
	
}

function handleResponseJQuery(myData) {
	

	
		 $('#table-body').append(
				 "<tr>" +
                 "<td>" + myData[0] + "</td>" +
                 "</tr>");
	
		
}