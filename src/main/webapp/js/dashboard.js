function loadSideBar(){
	/**
	sys-admin --> 1
	customer service rep --> 2
	support engineer --> 3
	network mnagament --> 4
	**/
	var q1 = '<li><a href="eventid_causeid.html"><span class="title">Affected IMSIs</span></a></li>';
	var q2 = '<li><a href="callFailuresDuration.html"><span	class="title">Call Failures Duration</span></a></li>';
	var q3 = '<li><a href="callFailuresByIMSI.html"><span class="title">Call Failures By IMSI</span></a></li>';
	var q4 = '<li><a href="callTotalDurationByIMSI.html"><span	class="title">Call Total Duration By IMSI</span></a></li>';
	var q5 ='<li><a href="user7.html"><span class="title">IMSI over given time period</span></a></li>';
	var q6='<li><a href="us10.html"><span class="title">Call Failure by Phone Model</span></a></li>';
	var type=getCookie("user");
	
	var list=document.getElementById("userFunctionList");
	var listUser=document.getElementById("addUserList");
	
	var accounts1 = "<li><a href='addUser.html'><span class='title'>Add	new user</span></a></li>";
	var accounts2 = "<li><a href='users.html'><span class='title'>List	of all users</span></a></li>";
	if(type=="1"){ 
		list.innerHTML+=(q1+q2+q3+q4+q5+q6);	
		listUser.innerHTML+=accounts1+accounts2;
	}else if(type =='2'){ 
		list.innerHTML+=(q1+q3);
	}else if(type =='3'){ 
		list.innerHTML+=(q2+q5);
	}else if(type =='4'){ 
		list.innerHTML+=(q4+q6);
	}
	else{
		location.href="index.html"
	}

	
}


function getCookie(cname){
	
	var name = cname+"=";
	var ca=document.cookie.split(";");
	for(var i=0;i<ca.length;i++){
		var c=ca[i];
		while(c.charAt(0)==' ') c=c.substring(1);
		if(c.indexOf(name)==0) return c.substring(name.length,c.length);
	}
	return "";
	
}