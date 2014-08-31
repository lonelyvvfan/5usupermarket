function out2()
{
	var top=document.getElementById("gonggao");
	var content=document.getElementById("right_table_content");
	var other=document.getElementById("wuyou");
	other.bgColor="#e99517";
	other.style.color="white";
	content.innerHTML="<a href="+'"user/showHelp!view?id=15"'+' target='+'"_blank"'+'>'+"了解无忧"+"</a><br>"+"<a href="+'"user/showHelp!view?id=17"'+' target='+'"_blank"'+'>'+"合作招商"+"</a><br>"+"<a href="+'"user/showHelp!view?id=18"'+' target='+'"_blank"'+'>'+"用户须知"+"</a><br>";
	top.bgColor="transparent";
	top.style.color="black";
	
	}  

