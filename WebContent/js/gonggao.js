function out2()
{
	var top=document.getElementById("gonggao");
	var content=document.getElementById("right_table_content");
	var other=document.getElementById("wuyou");
	other.bgColor="#e99517";
	other.style.color="white";
	content.innerHTML="<a href="+'"showHelp!view?id=15"'+' target='+'"_bank"'+'>'+"了解无忧"+"</a><br>"+"<a href="+'"showHelp!view?id=17"'+' target='+'"_bank"'+'>'+"合作招商"+"</a><br>"+"<a href="+'"showHelp!view?id=18"'+' target='+'"_bank"'+'>'+"用户须知"+"</a><br>";
	top.bgColor="transparent";
	top.style.color="black";
	
	}  

