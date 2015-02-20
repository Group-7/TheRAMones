document.getElementById("uploadFileBtn").submit = function(){
	
	//sendDataFile();
	
	
	location.href="import.html";
};


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