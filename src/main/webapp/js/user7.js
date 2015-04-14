function load(){
	
	loadSideBar();
}

function getConvertedDates(){
	
	var from=document.getElementById("startDate").value;
	var to=document.getElementById("endDate").value;
	var dates=from+","+to;
	//alert(dates);
	//dates=dates.split("/").join("");
	console.log("Dates before join: " + dates);
	//dates=dates.split("2").join("0");
	console.log("Dates after join: " + dates);
	
	return dates;
}

function submit() {
	var dates = getConvertedDates("#dates");
	
	$.ajax({
		type: 'GET',
		url: 'rest/baseData/imsi?dates='+dates,
		success: handleBaseDataResponse ,
		contentType: 'application/json'
	});	
}

function handleBaseDataResponse(data) {
	
	var t = $('#datatable1').DataTable();
	var i;
	for(i =0;i<data.length;i++){
		t.row.add([ data[i]])
	}
	t.draw();
}


