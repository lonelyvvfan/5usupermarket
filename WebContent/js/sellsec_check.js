function checkmobile()
{
	var tele=document.getElementById("contact_tel");
	var telephone=tele.value;
	var myreg = /1[3-8]+\d{9}/;
    if(telephone.length==0)
    {
        alert("× 请输入手机号码");
    }    
    else if(telephone.length!=11)
    {
        alert("× 请输入有效的手机号码");
    }
    
    
    else if(!myreg.test(telephone))
    {
    	alert("× 请输入有效的手机号码");
    }
    
}