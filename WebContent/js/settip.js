function setTip(value){
	var o_textarea=document.getElementById("beizhu");
	var str=o_textarea.value+","+value+",";
	o_textarea.innerHTML="";
	o_textarea.innerHTML=str;
	o_textarea.value=str;
}