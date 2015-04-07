/**
 * 
 */
/*$( document ).ready(function() {
	getTopTenIMSI();
});*/
$('#getImsiBtn').click(function(){
	getTopTenIMSI();
});


function getTopTenIMSI(){
	//'01/01/0011 17:00:00'
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	
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
}












