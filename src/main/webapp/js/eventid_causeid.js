//$("#infoBtn").click(function() {
$(document).ready(function() {
	getAllEvents();
	//createDropdownMenu();
});

function getAllEvents() {
	$.ajax({
		type : 'GET',
		url : 'rest/baseData/eventid_causeid/',
		success : handleResponseJQuery,
		contentType : 'application/json'
	});
}


function handleResponseJQuery(myData) {
	
	var select = document.getElementById("imsiNumber");
	for(var i = 0; i < myData.length-1; i++) {
	
		//separate unique numbers from the all imsi and paste to dropdown list
		if(myData[i][0] != myData[i+1][0])
		{
			var opt = myData[i][0];
		    var el = document.createElement("option");
		    el.textContent = opt;
		    el.value = opt;
		    select.appendChild(el);
		    continue;
		}		
	}
	
	//create table
	for (var i = 0; i < myData.length; i++) {

		$('#table-body').append(
				"<tr>" + "<td>" + myData[i][0] + "</td>" + "<td>"
						+ myData[i][1] + "</td>" + "<td>" + myData[i][2]
						+ "</td>" + "</tr>");			
	};
}

//function handleResponseJQuery(myData) {
//
//	for (var i = 0; i < myData.length; i++) {
//
//		$('#table-body').append(
//				"<tr>" + "<td>" + myData[i][0] + "</td>" + "<td>"
//						+ myData[i][1] + "</td>" + "<td>" + myData[i][2]
//						+ "</td>" + "</tr>");
//		
//	}
//	;
//
//}