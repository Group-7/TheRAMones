$("#getModel").click(function() {
getFailures();
}

function getFailures() {

var model = $('#model').val();
	$.ajax({
		type : 'GET',
		url : 'rest/baseData/modelFailure?model=', + model,
		contentType : 'application/json'
		success : ,
		
		
	});

}