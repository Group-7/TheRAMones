/**
 * 
 */
$( document ).ready(function() {
	loadSideBar();
});
$('#getImsiBtn').click(function(){
	getTopTenIMSI();
});



function getTopTenIMSI(){
	//'01/01/0011 17:00:00'
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	//startDate=startDate.split("2").join("0");
	
	$.ajax({
		type:"GET",
		url:"rest/baseData/toptenimsi?startDate="+ startDate +"&endDate="+ endDate,
		success: getResultsForTable,
		contentType: 'application/json'
	});
}

function getResultsForTable(data){
	
	$('#tableofTopTenIMSI').html("");
	
	for(var i =0;i<data.length;i++){
		$('#tableofTopTenIMSI').append(
				"<tr>" + 
				"<td>"+data[i][0]+"</td>"+
				"<td>"+data[i][1]+"</td>"+
		"</tr>");
	}
	var doughnutData = [
	    				{
	    					value: data[0][1],
	    					color:"#F7464A",
	    					highlight: "#FF5A5E",
	    					label: data[0][0]
	    				},
	    				{
	    					value: data[1][1],
	    					color: "#46BFBD",
	    					highlight: "#5AD3D1",
	    					label: data[1][0]
	    				},
	    				{
	    					value: data[2][1],
	    					color: "#FDB45C",
	    					highlight: "#FFC870",
	    					label: data[2][0]
	    				},
	    				{
	    					value: data[3][1],
	    					color: "#949FB1",
	    					highlight: "#A8B3C5",
	    					label: data[3][0]
	    				},
	    				{
	    					value: data[4][1],
	    					color: "#DD3609",
	    					highlight: "#AA2311",
	    					label: data[4][0]
	    				},
	    				{
	    					value: data[5][1],
	    					color: "#deef6a",
	    					highlight: "#b6c649",
	    					label: data[5][0]
	    				},
	    				{
	    					value: data[6][1],
	    					color: "#675E60",
	    					highlight: "#A34322",
	    					label: data[6][0]
	    				},
	    				{
	    					value: data[7][1],
	    					color: "#3E7760",
	    					highlight: "#B12334",
	    					label: data[7][0]
	    				},
	    				{
	    					value: data[8][1],
	    					color: "#98C312",
	    					highlight: "#166477",
	    					label: data[8][0]
	    				},
	    				{
	    					value: data[9][1],
	    					color: "#4D5360",//"#DD3609",
	    					highlight:  "#616774",//"#AA2311",
	    					label: data[9][0]
	    				}
	    			];
	
	var ctx = document.getElementById("chart-area").getContext("2d");
	window.myDoughnut = new Chart(ctx).Doughnut(doughnutData, {responsive : true});
}



/*$("#chart-area").click( 
	    function(evt){
	        var activePoints = myDoughnut.getSegmentsAtEvent(evt);           
	        var url = "label= " + activePoints[0].label + "&value= " + activePoints[0].value;
            alert(url);
	    }
	); */












