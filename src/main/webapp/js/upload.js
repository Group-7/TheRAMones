$('#uploadFileBtn').click(function(){
	
	//sendDataFile();
	//alert(window.location.host +"\n"+window.location);
	var url=window.location.search.split('SNAPSHOT/')[0];
	
	window.location.href=url+"import.html"
	//alert(url);
});

function load(){
	document.getElementById("uploadFileBtn").disabled=true;
}

function validate(){
	
	
	var fup = document.getElementById("uploadFile");
	var fileName=fup.value;
	var ext=fileName.substring(fileName.lastIndexOf('.') + 1);
	
	if(ext=="xls"){
		document.getElementById("uploadFileBtn").disabled=false;
	}
	else{
		alert("File must be of type xls");
		document.getElementById("uploadFileBtn").disabled=true;
	}
	
}

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

document.getElementById("uploadDataBtn").onclick = function () {
    location.href = "import.html";
};



function directToImport(){

	location.href="import.html";
}