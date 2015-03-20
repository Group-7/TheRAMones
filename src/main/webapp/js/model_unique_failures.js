var modelTac = tac;

window.onload = function(){
	loadAllUniqueModels();

/*	if(modelTac == tac){
		loadAllUniqueModels();
		modelTac = model;
	}
	else{
		loadAllUniqueTAC();
		modelTac = tac;
	}*/

}


$("#displayAllEventCauseCodeCombinationsPerPhoneModel").click(function() {
	getAllEventCauseCodeCombinationsPerPhoneModel();

});

$("#modelTacSwitch").click(function() {
	
	if(modelTac == tac){
		loadAllUniqueModels();
		modelTac = model;
	}
	else{
		loadAllUniqueTAC();
		modelTac = tac;
	}

});


function loadAllUniqueModels() {

	$.ajax({
		type : 'GET',
		url : 'rest/baseData/uniqueModels',
		success : populateModelTacSelector,
		contentType : 'application/json'
	});
}


function loadAllUniqueTAC() {

	$.ajax({
		type : 'GET',
		url : 'rest/baseData/uniqueTAC',
		success : populateModelTacSelector,
		contentType : 'application/json'
	});
}


function populateModelTacSelector(data) {
	//$("#model").remove();
	var select = document.getElementById("model");

	for (var i = 0; i < data.length; i++) {

		var opt = data[i];
		var el = document.createElement("option");
		el.textContent = opt;
		el.value = opt;
		select.appendChild(el);
	}
}


/*function populateTacSelector(data) {

	//var select = document.getElementById("tac");

	for (var i = 0; i < data.length; i++) {

		var opt = data[i];
		var el = document.createElement("option");
		el.textContent = opt;
		el.value = opt;
		select.appendChild(el);
	}
}*/


function getAllEventCauseCodeCombinationsPerPhoneModel(){
	
	$("#table-body").html("");// reset table
	
	var model = $("#model").val();
	
	$.ajax({
		  type: 'GET',
		  url: 'rest/baseData/modelFailure?model='+ model,
		  success: handleResponseJQuery3,
		  contentType: 'application/json'
	});
}

function handleResponseJQuery3(myData) {
	
	 $('#table-body').append(
          "<tr>" +
          "<td>" + myData[0][0] + "</td>" +
          "<td>" + myData[0][1] + "</td>" +
          "<td>" + myData[0][2] + "</td>" +
          "<td>" + myData[0][3] + "</td>" +
          "</tr>");
  
   }