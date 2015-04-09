/*$.getScript("https://tarruda.github.io/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js",function(){
	$.getScript("https://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js",function(){	
		
		$('#datetimepicker').datetimepicker({
			format: 'MM/dd/yyyy hh:mm:ss'
		});
	
	var picker = $('#datetimepicker').data('datetimepicker');
	picker.setLocalDate(new Date(Date.UTC(2013,10,11,4,30)));
		
});	
});*/


/*var years=new Array();
var moths=new Array();
var dates=new Array();

var yearsTo=new Array();
var mothsTo=new Array();
var datesTo=new Array();

var montharray=new Array("Jan","Feb","Mar","Apr","May","Jun","Jul"
		,"Aug","Sep","Oct","Nov","Dec");

function loadYears(){
	
	
	
	var yearNum=2000;
	var date=new Date();
	
	
	for(var i=2000;i<date.getFullYear()+1;i++){
		years[i-2000]=yearNum;
		
		yearNum++;
		
	}
	
}


function load(){
	
	
	
	loadYears();
	
	
	
	var sel=document.getElementById('yearFrom');
	clearSel(sel);
	for(var i=0;i<years.length; i++){
		var opt=document.createElement('option');
		opt.innerHTML=years[i];
		opt.value=years[i];
		sel.appendChild(opt);
	
	}
	
	document.getElementById("submit").disabled=true;
}

function loadMonthFrom(){
	
	var sel=document.getElementById('monthFrom');
	clearSel(sel);
	for(var i=0;i<12;i++){
		var opt=document.createElement('option');
		opt.innerHTML=montharray[i];
		opt.value=i;
		sel.appendChild(opt);
	}
	
}

function loadDateFrom(){
	var numDays;
	
	var month=document.getElementById('monthFrom').value;
	
	if( (month == 0) || (month ==2) || (month== 4) || (month==6) || (month==7) || (month==9) || (month==11)){
		numDays=31;
	}
	else if( (month==3) || (month==5) || (month==8) || (month ==10) ){
		numDays=30;
	}
	else if(month = 1){
		numDays=28;
	}
	
	var sel=document.getElementById('dateFrom');
	clearSel(sel);
	for(var i=1;i<numDays+1;i++){
		var opt=document.createElement('option');
		opt.innerHTML=i;
		opt.value=i;
		sel.appendChild(opt);
	}
	
}


function loadYearTo(){
	
	var year=document.getElementById('yearFrom').value;
	var date=new Date();
	var currYear=date.getFullYear();
	
	var sel=document.getElementById('yearTo');
	clearSel(sel);
	
	for(var i=year;i<currYear+1;i++){
		var opt=document.createElement('option');
		opt.innerHTML=i;
		opt.value=i;
		sel.appendChild(opt);
	}
}

function loadMonthTo(){

	var from=0;
	var fromYear=document.getElementById('yearFrom').value;
	var toYear=document.getElementById('yearTo').value;
	
	if(fromYear==toYear){
		from=document.getElementById('monthFrom').value;
	}
	
	
	var sel=document.getElementById('monthTo');
	clearSel(sel);
	for(var i=from;i<12;i++){
		var opt=document.createElement('option');
		opt.innerHTML=montharray[i];
		opt.value=i;
		sel.appendChild(opt);
	}
	
}

function loadDateTo(){
var numDays;
	
	var month=document.getElementById('monthTo').value;
	
	if( (month == 0) || (month ==2) || (month== 4) || (month==6) || (month==7) || (month==9) || (month==11)){
		numDays=31;
	}
	else if( (month==3) || (month==5) || (month==8) || (month ==10) ){
		numDays=30;
	}
	else if(month = 1){
		numDays=28;
	}
	
	var sel=document.getElementById('dateTo');
	clearSel(sel);
	for(var i=1;i<numDays+1;i++){
		var opt=document.createElement('option');
		opt.innerHTML=i;
		opt.value=i;
		sel.appendChild(opt);
	}
	
	document.getElementById("submit").disabled=false;
}

function clearSel(sel){

	//var sel=document.getElementById(selName);
	
	while(sel.options.length>0){
		sel.remove(0);
	}

}
*/

	/*alert("submit");
	var yearFrom=document.getElementById("yearFrom").value;
	var yearTo=document.getElementById("yearTo").value;
	var monthFrom=document.getElementById("monthFrom").value;
	var monthTo=document.getElementById("monthTo").value;
	var dateFrom=document.getElementById("dateFrom").value;
	var dateTo=document.getElementById("dateTo").value;
	
	var from=""+yearFrom+""+monthFrom+""+dateFrom+"";
	from="00131101";
	//alert(""+from);
	var to=""+yearTo+""+monthTo+""+dateTo+"";
	to="00140912";
	//alert(""+to);
*/	
	
	
	
	/*var string=""+from+","+to+"";
	alert(string);*/
function submit(){
	var from=document.getElementById("startDate").value;
	var to=document.getElementById("endDate").value;
	var dates=from+","+to;
	//alert(dates);
	//dates=dates.split("/").join("");
	console.log("Dates before join: " + dates);
	dates=dates.split("2").join("0");
	console.log("Dates after join: " + dates);
	$.ajax({
		type: 'GET',
		url: 'rest/baseData/us11?dates='+dates,
		success: handleBaseDataResponse ,
		contentType: 'application/json'

	});
	
}

function handleBaseDataResponse(data){
	
	var text="";
	
	for(var i=0; i< data.length; i++){
			
		text=text+
				"<tr>" +
				"<td>"+ data[i][1] +"</td>"+
				"<td>"+ data[i][2] +"</td>"+
				"<td>"+ data[i][3] +"</td>"+
				"<td>"+ data[i][0] +"</td>"+
				"</tr>"
		;
		
	};
	document.getElementById("resultTableBody").innerHTML=text;
}


