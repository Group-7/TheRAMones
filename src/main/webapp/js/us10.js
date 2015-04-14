window.onload = function() {

	loadAllUniqueModels();
	loadSideBar();

}
	var count=0;

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
	data.sort();
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
	var data = myData
for(var i = 0; i<myData.length; i++){ 
	 $('#table-body').append(
          "<tr>" +
         /* "<td>" + myData[i][0] + "</td>" +*/
          "<td>" + myData[i][1] + "</td>" +
          "<td>" + myData[i][3] + "</td>" +
          "<td>" + myData[i][2] + "</td>" +
	  "<td>" + myData[i][4] + "</td>" +
          "</tr>");
}
$(function () {
if(count>0){
document.getElementById('draw').innerHTML="";
}
if(myData !=""){
    var paper = Raphael(document.getElementById('draw'), 550, 350);
    //var k = parseInt(jArray[0].Wins);
    var c = paper.piechart(200, 200,100, [myData[0][4],myData[1][4], myData[2][4],myData[3][4], myData[4][4]],
    {
        legend: ["%% Event:" + myData[0][1] + " Cause:" + myData[0][3],
         "%% Event:" + myData[1][1] + " Cause:" + myData[1][3], 
         "%% Event:" + myData[2][1] + " Cause:" + myData[2][3], 
         "%% Event:" + myData[3][1] + " Cause:" + myData[3][3],
         "%% Event:" + myData[4][1] + " Cause:" + myData[4][3] ]
    });
    count++;
 
}
});
  
   }
   

