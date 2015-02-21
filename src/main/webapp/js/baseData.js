$(document).ready(function(){
	
	showBaseData();
	
});



function showBaseData(){
	
	$.ajax({
		type: 'GET',
		url: 'rest/baseData',
		success: handleBaseDataResponse,
		contentType: 'application/json'
	});
}


function handleBaseDataResponse(data){
	
	for(var i=0; i< data.length; i++){
		
		
		
		$('#baseTableBody').append(
				"<tr>" +
				"<td>"+timeconverter(data[i].dateAndTime) +"</td>"+
				"<td>"+data[i].eventId +"</td>"+
				"<td>"+data[i].failureClass +"</td>"+
				"<td>"+data[i].tac +"</td>"+
				"<td>"+data[i].mcc +"</td>"+
				"<td>"+data[i].mnc +"</td>"+
				"<td>"+data[i].cellid +"</td>"+
				"<td>"+data[i].duration +"</td>"+
				"<td>"+data[i].causeCode +"</td>"+
				"<td>"+data[i].neVersion +"</td>"+
				"<td>"+data[i].imsi +"</td>"+
				"<td>"+data[i].heir3ID +"</td>"+
				"<td>"+data[i].heir32ID +"</td>"+
				"<td>"+data[i].heir321ID +"</td>"+
				"</tr>"
		);
		
	};
}

function timeconverter(timestamp){
	
	//timestamp=timestamp*-1;
	var a=new Date(timestamp);
	var months=['jan','feb','mar','apr','may','jun','jul','aug','sep','oct','nov','dec'];
	var year=a.getFullYear();
	var month=a.getMonth()+1;
	var date=a.getDate();
	var hour=a.getHours();
	var min=a.getMinutes();
	var sec=a.getSeconds();
	var time=date+'/'+month+'/'+year+' '+hour+':'+min;
	return time;
}