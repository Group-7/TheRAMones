/*$('#uploadFileBtn').click(function(){
	
	//sendDataFile();
	//alert(window.location.host +"\n"+window.location);
	var url=window.location.search.split('SNAPSHOT/')[0];
	
	window.location=url+"import.html"
	//alert(url);
});*/


function sendDataFile(){
	
	//var file=$('#uploadedFile').val();
	var formData= new FormData($('uploadedFile')[0]);
	
	
	$ajax({
		type: "POST",
		url: "rest/baseData/upload",
		success: directToImport,
		contentType: "multipart/form-data",
		data: formData
		
	});
	
}

function directToImport(){

	location.href="import.html";
}