/**
 * 
 */
$( document ).ready(function() {
	fillDropDown();
});

function fillDropDown(){
	$.ajax({
		type:"GET",
		url:"rest/baseData/failuredropdown",
		success: populateTable,
		contentType: 'application/json'
	});
}

function populateTable(data){
	
	var list = document.getElementById("failureId");
	
	for (var i = 0; i < data.length; i++){
		
		var option = data[i];
		var element = document.createElement("option");
		element.textContent = option;
		element.value = option;
		list.appendChild(element);
		
	}
	
}

function getDropdownValue(){
	var playlist = $('#failureId').val();
	$.ajax({
		type:"GET",
		url:"rest/baseData/imsifailureclass?failure="+playlist,
		success: getResultsForTable,
		contentType: 'application/json'
	});
}

function getResultsForTable(data){
	$('#tableofFailureClasses').html("");
	for(var i =0;i<data.length;i++){
		$('#tableofFailureClasses').append(
				"<tr>" + 
				"<td>"+data[i][0]+"</td>"+
				"<td>"+timeconverter(data[i][1])+"</td>"+
		"</tr>");
	}
}


function timeconverter(timestamp){
	
	//timestamp=timestamp*-1;
	var a=new Date(timestamp);
	a.setDate(a.getDate() + 2);
	var months=['jan','feb','mar','apr','may','jun','jul','aug','sep','oct','nov','dec'];
	var year=a.getFullYear();
	var month=months[a.getMonth()];
	var date=a.getDate();
	var hour=a.getHours();
	var min=a.getMinutes();
	var sec=a.getSeconds();
	var time=date+'/'+month+'/'+year+' '+hour+':'+min;
	return time;
}


















