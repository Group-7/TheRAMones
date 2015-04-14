
function load() {

	$.ajax({
		type : 'GET',
		url : 'rest/baseData/uniqueIMSI',
		// url : 'rest/baseData/eventid_causeid?imsiNumber='+ imsiNr,
		success : fillImsiSelect,
		contentType : 'application/json'
	});
		
		loadSideBar();
}

/**
 * separate unique numbers from the all imsi and paste to dropdown list
 * 
 */

function fillImsiSelect(data) {

	//var select = document.getElementById("srch");
	alert("HERE");
	for(var i =0; i<data.length; i++) {
	data[i] = String(data[i]);
	}
	//alert("Autocomplete");
	$("#srch").autocomplete({source: data, minLength: 0, delay: 500});
	alert("Autocomplete");
}

/**
 * Updates table with a given imsi
 */

function update() {
	
	//clears table 
	$("#table-body").html("");
	
	var imsiNr = $("#srch").val();
	
	$.ajax({
		type : 'GET',
		url : 'rest/baseData/causeid_per_imsi?imsi=' + imsiNr,
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
						+ myData[i][1] + "</tr>");
	}
	;
}
