window.onload = function() {

	getAllEventCauseCodeCombinationsPerPhoneModel();
}


function getAllEventCauseCodeCombinationsPerPhoneModel(){
	
	$.ajax({
		  type: 'GET',
		  url: 'rest/baseData/us13',
		  success: populateChart,
		  contentType: 'application/json'
	});
}

function populateChart(data) {
var paper = Raphael(document.getElementById('draw'), 640, 480);
    //var k = parseInt(jArray[0].Wins);
    var c = paper.piechart(150, 150, 100, [parseInt(data[0][0]), parseInt(data[1][0]), parseInt(data[2][0]),parseInt(data[3][0]), parseInt(data[4][0]), parseInt(data[5][0]), parseInt(data[6][0]), parseInt(data[7][0]), parseInt(data[8][0]), parseInt(data[9][0])],
    {
        legend: ["%% - " + data[0][3], "%% - " + data[1][3], "%% - " + data[2][3], "%% - " + data[3][3], "%% - " + data[4][3], "%% - " + data[5][3], "%% - " + data[6][3], "%% - " + data[7][3], "%% - " + data[8][3], "%% - " + data[9][3]]
    });
    
   

}
