window.onload = function() {

	loadAllUniqueModels();
}


$("#displayAllEventCauseCodeCombinationsPerPhoneModel").click(function() {
	
	getAllEventCauseCodeCombinationsPerPhoneModel();

});


function loadAllUniqueModels() {

	$.ajax({
		type : 'GET',
		url : 'rest/baseData/uniqueModels',
		success : populateModelSelector,
		contentType : 'application/json'
	});
}

function populateModelSelector(data) {
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