

function loadSideBar(){
	/**
	sys-admin --> 1
	customer service rep --> 2
	support engineer --> 3
	network mnagament --> 4
	**/
	var userSt4 = '<li><a href="eventid_causeid.html"><span class="title">US 4</span></a></li>';
	var userSt8 = '<li><a href="callFailuresDuration.html"><span	class="title">US 8</span></a></li>';
	var userSt5 = '<li><a href="callFailuresByIMSI.html"><span class="title">US 5</span></a></li>';
	var userSt9 = '<li><a href="callTotalDurationByIMSI.html"><span	class="title">US 9</span></a></li>';
	var userSt7 ='<li><a href="user7.html"><span class="title">US 7</span></a></li>';
	var userSt10='<li><a href="us10.html"><span class="title">US 10</span></a></li>';
	var userSt6='<li><a href="net_us6.html"><span class="title">US 6</span></a></li>';
	var userSt11='<li><a href="us11.html"><span class="title">US 11</span></a></li>';
	var userSt12='<li><a href="user12.html"><span class="title">US 12</span></a></li>';
	var userSt14='<li><a href="user14.html"><span class="title">US 14</span></a></li>';
	
	var type=getCookie("user");
	
	var list=document.getElementById("userFunctionList");
	var listUser=document.getElementById("addUserList");
	
	var accounts1 = "<li><a href='addUser.html'><span class='title'>Add	new user</span></a></li>";
	var accounts2 = "<li><a href='users.html'><span class='title'>List	of all users</span></a></li>";
	if(type=="1"){ 
		list.innerHTML+=(userSt4+userSt5+userSt6+userSt7+userSt8+userSt9+userSt10+userSt11+userSt12+userSt14);	
		listUser.innerHTML+=accounts1+accounts2;
	}else if(type =='2'){ 
		list.innerHTML+=(userSt4+userSt5+userSt6+userSt7+userSt8+userSt9+userSt10+userSt11+userSt12+userSt14);
	}else if(type =='3'){ 
		list.innerHTML+=(userSt4+userSt5+userSt6+userSt7+userSt8+userSt14);
	}else if(type =='4'){ 
		list.innerHTML+=(userSt9+userSt10+userSt11+userSt12);
	}
	else{
		location.href="index.html";
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