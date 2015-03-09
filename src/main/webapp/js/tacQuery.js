$("#displayCallFailuresPerPhoneType").click(function() {
	
	getAllCallFailuresPerPhoneType();

});

$("#displayCallFailuresPerIMSI").click(function() {
	
	getAllCallFailuresPerIMSI();

});

$("#displayTotalDurationPerIMSI").click(function() {
	
	getTotalDurationPerIMSI();

});

function getAllCallFailuresPerPhoneType(){
	
	$("#table-body").html("");//
	
	var tacNumber = $("#TAC").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	
	$.ajax({
		  type: 'GET',
		  url: 'rest/baseData/tacFailures?TAC='+ tacNumber+'&startDate='+ startDate+'&endDate='+endDate,
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
}


function getAllCallFailuresPerIMSI(){
	 $("#table-body").html("");
	
	var imsiNumber = $("#imsi").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();

	$.ajax({
		  type: 'GET',
		  url: 'rest/baseData/imsiFailures?imsi='+ imsiNumber+'&startDate='+ startDate+'&endDate='+endDate,
		  success: handleResponseJQuery,
		  contentType: 'application/json'
	});
}


function getTotalDurationPerIMSI(){
	 $("#table-body").html("");
	
	var imsiNumber = $("#imsi").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();

	$.ajax({
		  type: 'GET',
		  url: 'rest/baseData/imsiFailures?imsi='+ imsiNumber+'&startDate='+ startDate+'&endDate='+endDate,
		  success: handleResponseJQuery2,
		  contentType: 'application/json'
	});
}


function handleResponseJQuery(myData) {
	
		 $('#table-body').append(
				 "<tr>" +
                 "<td>" + myData[0] + "</td>" +
                 "</tr>");
	
		
}

function handleResponseJQuery2(myData) {
	
	 $('#table-body').append(
			 "<tr>" +
            "<td>" + myData[0][0] + "</td>" +
            "<td>" + myData[0][1].Duration + "</td>" +
            "</tr>");
	
}
	
