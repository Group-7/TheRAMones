
function load() {

	$.ajax({
		type : 'GET',
		url : 'rest/baseData/uniqueIMSI',
		// url : 'rest/baseData/eventid_causeid?imsiNumber='+ imsiNr,
		success : fillImsiSelect,
		contentType : 'application/json'
	});
}

/**
 * separate unique numbers from the all imsi and paste to dropdown list
 * 
 */

function fillImsiSelect(data) {

	var select = document.getElementById("imsiNumber");

	for (var i = 0; i < data.length; i++) {

		var opt = data[i];
		var el = document.createElement("option");
		el.textContent = opt;
		el.value = opt;
		select.appendChild(el);
	}
}

/**
 * Updates table with a given imsi
 */

function update() {
	
	//clears table 
	$("#table-body").html("");
	
	var imsiNr = $("#imsiNumber").val();
	
	$.ajax({
		type : 'GET',
		url : 'rest/baseData/eventid_causeid?imsi=' + imsiNr,
		success : handleResponseJQuery,
		contentType : 'application/json'
	});

}

/**
 * Displays data from json as a table
 * @param myData takes data from json
 */
function handleResponseJQuery(myData) {

	// create table
	for (var i = 0; i < myData.length; i++) {
		
		$('#table-body').append(
				"<tr>" + "<td>" + myData[i][0] + "</td>" + "<td>"
						+ myData[i][1] + "</td>" + "<td>" + myData[i][2]
						+ "</td>" + "<td>" + myData[i][3] + "</tr>");
	}
	;
}
