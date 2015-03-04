


function load(){
	
	$.ajax({
		type : 'GET',
		url : 'rest/baseData/uniqueIMSI',
		//url : 'rest/baseData/eventid_causeid?imsiNumber='+ imsiNr,
		success : fillImsiSelect,
		contentType : 'application/json'
	});
	
}

function fillImsiSelect(data){
	
	var select=document.getElementById("imsiNumber");
	
	for(var i = 0; i < data.length; i++) 
	{
	
		//separate unique numbers from the all imsi and paste to dropdown list
		
			var opt = data[i];
		    var el = document.createElement("option");
		    el.textContent = opt;
		    el.value = opt;
		    select.appendChild(el);
		    alert(data[i]);
				
	}
}

function update(){
	var imsiNr = $("#imsiNumber").val();
	$.ajax({
		type : 'GET',
		//url : 'rest/baseData/eventid_causeid/',
		url : 'rest/baseData/eventid_causeid?imsi='+ imsiNr,
		success : handleResponseJQuery,
		contentType : 'application/json'
	});
	
	
}

//function getAllEvents() {
//	
//	var imsiNr = $("#imsiNumber").val();
//	var table = $("#table-body").val();
//	
//	
//	$.ajax({
//		type : 'GET',
//		url : 'rest/baseData/eventid_causeid/',
//		//url : 'rest/baseData/eventid_causeid?imsiNumber='+ imsiNr,
//		success : handleResponseJQuery,
//		contentType : 'application/json'
//	});
//}
//
//function update() {
//	var imsiNr = $("#imsiNumber").val();
//	$.ajax({
//		type : 'GET',
//		//url : 'rest/baseData/eventid_causeid/',
//		url : 'rest/baseData/eventid_causeid?imsiNumber='+ imsiNr,
//		success : handleResponseJQuery,
//		contentType : 'application/json'
//	});
//}
//
function handleResponseJQuery(myData) {
	
	
	
	//create table
	for (var i = 0; i < myData.length; i++) {

		$('#table-body').append(
				"<tr>" + "<td>" + myData[i][0] + "</td>" + "<td>"
						+ myData[i][1] + "</td>" + "<td>" + myData[i][2]
						+ "</td>" + "</tr>");			
	};
}

/*
function getAllCallFailuresPerIMSI(){
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

*/