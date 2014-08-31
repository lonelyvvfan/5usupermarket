var name_sure=true;
var tel_sure=true;
var fpsd_sure=true;
var spsd_sure=true;
var idcard=true

var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];    // 加权因子   
var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];            // 身份证验证位值.10代表X   
function IdCardValidate(idCard) { 
	var ftname=document.getElementById("snum");
    idCard = trim(idCard.replace(/ /g, ""));               //去掉字符串头尾空格                     
    if (idCard.length == 15) {   
        return isValidityBrithBy15IdCard(idCard);       //进行15位身份证的验证    
    } else if (idCard.length == 18) {   
        var a_idCard = idCard.split("");                // 得到身份证数组   
        if(isValidityBrithBy18IdCard(idCard)&&isTrueValidateCodeBy18IdCard(a_idCard)){   //进行18位身份证的基本验证和第18位的验证
        	ftname.className="frbule";
            ftname.innerHTML="√ 身份证号码格式正确";
            ftname.style.color="green";
            idcard=true;
        }else {   
        	ftname.className="frbule";
            ftname.innerHTML="× 请输入正确格式的身份证号码";
            ftname.style.color="red";
            idcard=false;
        }   
    } else {   
    	ftname.className="frbule";
        ftname.innerHTML="× 请输入正确格式的身份证号码";
        ftname.style.color="red";
        idcard=false;
    }   
}   
/**  
 * 判断身份证号码为18位时最后的验证位是否正确  
 * @param a_idCard 身份证号码数组  
 * @return  
 */  
function isTrueValidateCodeBy18IdCard(a_idCard) {   
    var sum = 0;                             // 声明加权求和变量   
    if (a_idCard[17].toLowerCase() == 'x') {   
        a_idCard[17] = 10;                    // 将最后位为x的验证码替换为10方便后续操作   
    }   
    for ( var i = 0; i < 17; i++) {   
        sum += Wi[i] * a_idCard[i];            // 加权求和   
    }   
    valCodePosition = sum % 11;                // 得到验证码所位置   
    if (a_idCard[17] == ValideCode[valCodePosition]) {   
        return true;   
    } else {   
        return false;   
    }   
}   
/**  
  * 验证18位数身份证号码中的生日是否是有效生日  
  * @param idCard 18位书身份证字符串  
  * @return  
  */  
function isValidityBrithBy18IdCard(idCard18){   
    var year =  idCard18.substring(6,10);   
    var month = idCard18.substring(10,12);   
    var day = idCard18.substring(12,14);   
    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
    // 这里用getFullYear()获取年份，避免千年虫问题   
    if(temp_date.getFullYear()!=parseFloat(year)   
          ||temp_date.getMonth()!=parseFloat(month)-1   
          ||temp_date.getDate()!=parseFloat(day)){   
            return false;   
    }else{   
        return true;   
    }   
}   
  /**  
   * 验证15位数身份证号码中的生日是否是有效生日  
   * @param idCard15 15位书身份证字符串  
   * @return  
   */  
  function isValidityBrithBy15IdCard(idCard15){   
      var year =  idCard15.substring(6,8);   
      var month = idCard15.substring(8,10);   
      var day = idCard15.substring(10,12);   
      var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
      // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   
      if(temp_date.getYear()!=parseFloat(year)   
              ||temp_date.getMonth()!=parseFloat(month)-1   
              ||temp_date.getDate()!=parseFloat(day)){   
                return false;   
        }else{   
            return true;   
        }   
  }   
//去掉字符串头尾空格   
function trim(str) {   
    return str.replace(/(^\s*)|(\s*$)/g, "");   
}

function checkformname(){
    var regname=/^[\u4E00-\u9FA5a-zA-Z0-9_]{4,10}$/;
    var fname=document.getElementById("username");
    var ftname=document.getElementById("sname");
    if(fname.value==""|| fname.value.length<4||fname.value.length>10){
        ftname.className="frbule";
        ftname.innerHTML="× 请输入4-10位用户名，可包含数字、字母、下划线";
        ftname.style.color="red";
        name_sure=false;
    }
    else{
        if(fname.value.match(regname)){
            ftname.className="frbule";
            ftname.innerHTML="√用户名可用!";
            ftname.style.color="green";
            name_sure=true;
        }
        else{
            ftname.className="frbule";
            ftname.innerHTML="× 用户名格式输入错误，请检查！";
            ftname.style.color="red";
            name_sure=false;
        }}
}

var isexist=function(){
	var username=document.getElementById("username").value;
	$.ajax({
        url: 'ajaxshopping!checkusername?username='+username,
        type: 'get',
        dataType: 'json',
        error: function(){
			alert("加载失败");
        },
        
        success: function(responseResult){
        	$(responseResult.list).each(function(){
        		if (this==false)
        			{
        			   var ftname=document.getElementById("sname");
        			   ftname.className="frbule";
        		        ftname.innerHTML="× 用户名已存在请重新输入！";
        		        ftname.style.color="red";
        				document.getElementById("username").value='';
        				name_sure==false;
        			}
        		else{
        			var regname=/^[\u4E00-\u9FA5a-zA-Z0-9_]{4,10}$/;
        		    var fname=document.getElementById("username");
        		    var ftname=document.getElementById("sname");
        		    if(fname.value==""|| fname.value.length<4||fname.value.length>10){
        		        ftname.className="frbule";
        		        ftname.innerHTML="× 请输入4-10位用户名，可包含中文、数字、字母、下划线";
        		        ftname.style.color="red";
        		        name_sure=false;
        		    }
        		    else{
        		        if(fname.value.match(regname)){
        		            ftname.className="frbule";
        		            ftname.innerHTML="√用户名可用!";
        		            ftname.style.color="green";
        		            name_sure=true;
        		        }
        		        else{
        		            ftname.className="frbule";
        		            ftname.innerHTML="× 用户名格式输入错误，请检查！";
        		            ftname.style.color="red";
        		            name_sure=false;
        		        }}
        			    if(name_sure==true)
        			    	{
         			   ftname.className="frbule";
         		        ftname.innerHTML="恭喜您该用户名尚未被注册";
         		        ftname.style.color="green";}
        		}
        	});
        }
    });
};

function checkpwd(){
    var fpwd=document.getElementById("first_pwd");
    var ftpwd=document.getElementById("spwd");
    if(fpwd.value==""||fpwd.value.length<6||fpwd.value.length>20){
        ftpwd.className="frbule";
        ftpwd.innerHTML="× 请输入6-20位用户密码！";
        ftpwd.style.color="red";
        fpsd_sure=false;
    }
    else{
        ftpwd.className="frbule";
        ftpwd.innerHTML="√密码可用！";
        ftpwd.style.color="green";
        fpsd_sure=true;
    }
}
function rcheckpwd(){
    var fpwd=document.getElementById("first_pwd");
    var frpwd=document.getElementById("second_pwd");
    var ftrpwd=document.getElementById("srpwd");
    if(frpwd.value==""||frpwd.value.length<6||frpwd.value.length>20){
        ftrpwd.className="frbule";
        ftrpwd.innerHTML="× 请输入6-20位用户密码！";
        ftrpwd.style.color="red";
        spsd_sure=false;
    }
    else{
    if(frpwd.value=="")
    {
        ftrpwd.className="frbule";
        ftrpwd.innerHTML="× 请输入您的重复密码！";
        ftrpwd.style.color="red";
        spsd_sure=false;
    }
    else{
        if(frpwd.value!=fpwd.value)
        {
            ftrpwd.className="frbule";
            ftrpwd.innerHTML="× 俩次密码输入不一致，请重新输入！";
            ftrpwd.style.color="red";
            spsd_sure=false;
        }
        else
        {
            ftrpwd.className="frbule";
            ftrpwd.innerHTML=" √ 密码输入正确";
            ftrpwd.style.color="green";
            spsd_sure=true;
        }
    }
    }
}

function checkmobile()
{
	var tele=document.getElementById("telephone");
	var telephone=tele.value;
	var tel=document.getElementById("tel");
	var myreg = /1[3-8]+\d{9}/;
    if(telephone.length==0)
    {
    	tel.className="frbule";
        tel.innerHTML="× 请输入手机号码";
        tel.style.color="red";
        tel_sure=false;
    }    
    else if(telephone.length!=11)
    {
    	tel.className="frbule";
        tel.innerHTML="× 请输入有效的手机号码";
        tel.style.color="red";
        tel_sure=false;
    }
    
    
    else if(!myreg.test(telephone))
    {
    	tel.className="frbule";
        tel.innerHTML="× 请输入有效的手机号码";
        tel.style.color="red";
        tel_sure=false;
    }
    else{
    	tel.className="frbule";
        tel.innerHTML="√手机号码可用";
        tel.style.color="green";
        tel_sure=true;
    }
    
}

function sign_able()
{
	if(name_sure==true&&tel_sure==true&&fpsd_sure==true&&spsd_sure==true)
	{
		document.all.sign.disabled=false;
	}
	else{
		document.all.sign.disabled=true;
		alert("请填写正确的信息");
	}
	document.all.sign.disabled=false;
	}

function find_able()
{
	if(name_sure==true&&tel_sure==true)
	{
		document.all.find.disabled=false;
	}
	else{
		document.all.find.disabled=true;
		alert("请填写正确的信息");
	}
	document.all.find.disabled=false;
	}
function find_able1()
{
	if(name_sure==true&&tel_sure==true&&idcard==true)
	{
		document.all.find.disabled=false;
	}
	else{
		document.all.find.disabled=true;
		alert("请填写正确的信息");
	}
	document.all.find.disabled=false;
	}

function o_checkformname(){
    var fname=document.getElementById("order_name");
    var ftname=document.getElementById("oname");
    if(fname.value==""){
        ftname.className="frbule";
        ftname.innerHTML="× 请输入姓名";
        ftname.style.color="red";
        return false;
    }
    else{
            ftname.className="frbule";
            ftname.innerHTML="√";
            ftname.style.color="green";
            return true;
        }
}

function foraddr(){
	var ftname=document.getElementById("addr");
	ftname.className="frbule";
    ftname.innerHTML="*为方便送货必须写成数字，谢谢~";
    ftname.style.color="gray";
}

function buid(){
    var build=document.getElementById("order_building");
    var ftname=document.getElementById("addr");
    var num=/^\d*$/;
    if(build.value==""||!num.test(build.value)){
        ftname.className="frbule";
        ftname.innerHTML="× 请输入数字";
        ftname.style.color="red";
        return false;
    }
    else{
            ftname.className="frbule";
            ftname.innerHTML="√";
            ftname.style.color="green";
            return true;
        }
}

function room(){
	var build=document.getElementById("order_building");
    var room=document.getElementById("order_room");
    var ftname=document.getElementById("addr");
    var num=/^\d*$/;
    if(room.value==""||!num.test(room.value)||build.value==""||!num.test(build.value)){
        ftname.className="frbule";
        ftname.innerHTML="× 请输入数字";
        ftname.style.color="red";
        return false;
    }
    else{
            ftname.className="frbule";
            ftname.innerHTML="√";
            ftname.style.color="green";
            return true;
        }
}

function out()
{
	var a_way=document.getElementById("a_way");
    if(window.event.toElement.id!="a_way"&&window.event.toElement.id!="a_weibo"&&window.event.toElement.id!="a_link"&&window.event.toElement.id!="a_qq"&&window.event.toElement.id!="a_renren")
        a_way.style.visibility="hidden";
}


function log()
{
	var log=document.getElementById("login");
    if(window.event.toElement.id!="login"&&window.event.toElement.id!="l_weibo"&&window.event.toElement.id!="l_link"&&window.event.toElement.id!="l_qq"&&window.event.toElement.id!="l_renren")
        log.style.visibility="hidden";
}





function checkformname1(){
    var regname=/^[\u4E00-\u9FA5a-zA-Z0-9_]{4,10}$/;
    var fname=document.getElementById("username1");
    if(fname.value==""|| fname.value.length<4||fname.value.length>10){
       alert("× 请输入4-10位用户名，可包含中文、数字、字母、下划线");
    }
    else{
        if(fname.value.match(regname)){}
        else{
            alert("× 用户名格式输入错误，请检查！");
        }}
}

function checkpwd1(){
    var fpwd=document.getElementById("first_pwd1");
    if(fpwd.value==""||fpwd.value.length<4||fpwd.value.length>20){
       alert("× 请输入4-20位用户密码！");
    }
}

function checkmobile1()
{
	var tele=document.getElementById("telephone1");
	var telephone=tele.value;
	var myreg = /1[3-8]+\d{9}/;
    if(telephone.length==0)
    {
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


function isCardNo()  
{  
   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X=
   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
   if(reg.test(card) === false)  
   {  
       alert("身份证输入不合法");  
   }  
}  

