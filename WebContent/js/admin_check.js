var name_sure=true;
var psd_sure=true;
function checkformname(){
    var regname=/^[\u4E00-\u9FA5a-zA-Z0-9_]{4,10}$/;
    var fname=document.getElementById("username");
    if(fname.value==""|| fname.value.length<4||fname.value.length>10){
        alert("× 请输入4-10位用户名，可包含中文、数字、字母、下划线");
        name_sure=false;
    }
    else{
        if(fname.value.match(regname)){
        	name_sure=true;
        }
        else{
            alert("× 用户名格式输入错误，请检查！");
            name_sure=false;
        }}
}

function checkpwd(){
    var fpwd=document.getElementById("fir_pwd");
    if(fpwd.value==""||fpwd.value.length<6||fpwd.value.length>20){
        alert("× 请输入6-20位用户密码！");
        psd_sure=false;
    }
    else{
    	psd_sure=true;
    }
}

function admin_log(){
	if(psd_sure==true&&name_sure==true)
		{
		document.all.admin_sign.disabled=false;
		}
	else{
		document.all.admin_sign.disabled=true;
		alert("请输入格式正确的账号或密码");
	}
	document.all.admin_sign.disabled=false;
}