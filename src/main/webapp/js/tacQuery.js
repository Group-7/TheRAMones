window.onload = function() {

	loadAllUniqueIMSI();
	loadAllUniqueTAC();
}

$("#displayCallFailuresPerPhoneType").click(function() {
	
	getAllCallFailuresPerPhoneType();

});

$("#displayCallFailuresPerIMSI").click(function() {
	
	getAllCallFailuresPerIMSI();

});

$("#displayTotalDurationPerIMSI").click(function() {
	
	getTotalDurationPerIMSI();

});

//********Queries to RESTService**********


function getAllCallFailuresPerPhoneType(){
	
	$("#table-body").html("");//
	
	var tacNumber = $("#tac").val();
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
		  url: 'rest/baseData/imsiTotalDuration?imsi='+ imsiNumber+'&startDate='+ startDate+'&endDate='+endDate,
		  success: handleResponseJQuery2,
		  contentType: 'application/json'
	});
}


function loadAllUniqueIMSI() {

	$.ajax({
		type : 'GET',
		url : 'rest/baseData/uniqueIMSI',
		// url : 'rest/baseData/eventid_causeid?imsiNumber='+ imsiNr,
		success : populateImsiSelector,
		contentType : 'application/json'
	});
}


function loadAllUniqueTAC() {

	$.ajax({
		type : 'GET',
		url : 'rest/baseData/uniqueTAC',
		// url : 'rest/baseData/eventid_causeid?imsiNumber='+ imsiNr,
		success : populateTacSelector,
		contentType : 'application/json'
	});
}


//********Update selectors/dropDownMenu's**********

function update() {
	
	//clears table 
	$("#table-body").html("");
	
	var imsiNr = $("#imsi").val();
	
	$.ajax({
		type : 'GET',
		url : 'rest/baseData/eventid_causeid?imsi=' + imsiNr,
		success : handleResponseJQuery,
		contentType : 'application/json'
	});

}

function update() {
	
	//clears table 
	$("#table-body").html("");
	
	var imsiNr = $("#tac").val();
	
	$.ajax({
		type : 'GET',
		url : 'rest/baseData/eventid_causeid?imsi=' + tacNr,
		success : handleResponseJQuery,
		contentType : 'application/json'
	});

}

//********Populate selectors/dropDownMenu's**********

function populateImsiSelector(data) {

	var select = document.getElementById("imsi");

	for (var i = 0; i < data.length; i++) {

		var opt = data[i];
		var el = document.createElement("option");
		el.textContent = opt;
		el.value = opt;
		select.appendChild(el);
	}
}

function populateTacSelector(data) {

	var select = document.getElementById("tac");

	for (var i = 0; i < data.length; i++) {

		var opt = data[i];
		var el = document.createElement("option");
		el.textContent = opt;
		el.value = opt;
		select.appendChild(el);
	}
}


// ********handle Response Queries**********

function handleResponseJQuery(myData) {
	
	 $('#table-body').append(
			 "<tr>" +
            "<td>" + myData[0] + "</td>" +
            "</tr>");

}


function handleResponseJQuery2(myData2) {
	
		 $('#table-body').append(
               "<tr>" +
               "<td>" + myData2[0][1] + "</td>" +
               "<td>" + myData2[0][2] + "</td>" +
               "<td>" + myData2[0][0] + "</td>" +
               "</tr>");
       
        }

	
