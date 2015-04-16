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



/*function handleResponseJQuery3(myData) {
	var data = myData
for(var i = 0; i<myData.length; i++){ 
	 $('#table-body').append(
          "<tr>" +
          "<td>" + myData[i][0] + "</td>" +
          "<td>" + myData[i][1] + "</td>" +
          "<td>" + myData[i][3] + "</td>" +
          "<td>" + myData[i][2] + "</td>" +
	  "<td>" + myData[i][4] + "</td>" +
          "</tr>");
}*/
	
function handleResponseJQuery3(data) {
	var myData=data;
	var t = $('#datatable1').DataTable();
	var i;
	for(i =0;i<data.length;i++){
		t.row.add([ data[i][1], data[i][3], data[i][2],data[i][4] ])
	}
	t.draw();

	
$(function () {
if(count>0){
document.getElementById('draw').innerHTML="";
}
if(data !=""){
    var paper = Raphael(document.getElementById('draw'), 550, 350);
    //var k = parseInt(jArray[0].Wins);
    var c = paper.piechart(200, 200,100, [data[0][4],data[1][4], data[2][4],data[3][4], data[4][4]],
    {
        legend: ["%% Event:" + data[0][1] + " Cause:" + data[0][3],
         "%% Event:" + data[1][1] + " Cause:" + data[1][3], 
         "%% Event:" + data[2][1] + " Cause:" + data[2][3], 
         "%% Event:" + data[3][1] + " Cause:" + data[3][3],
         "%% Event:" + data[4][1] + " Cause:" + data[4][3] ]
    });
    count++;
 
}

});
}  
   
   

