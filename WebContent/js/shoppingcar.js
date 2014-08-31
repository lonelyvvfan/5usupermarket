 function car(){
        var msgw,msgh,bordercolor;
        msgw=850;//提示窗口的宽度
        msgh=560;//提示窗口的高度
        titleheight=25 //提示窗口标题高度
        bordercolor="#c51100";//提示窗口的边框颜色
        titlecolor="#c51100";//提示窗口的标题颜色

        var sWidth,sHeight;
        sWidth=screen.width;
        sHeight=screen.height;
        var is360=false;
        if(window.navigator.userAgent.indexOf('Chrome')!=-1){
			if(window.navigator.webkitPersistentStorage){
				isCrome = true;
			}else{
				is360 = true;
			}
		}
        var bgObj=document.createElement("div");
        bgObj.setAttribute('id','bgDiv');
        bgObj.style.position="fixed";
        bgObj.style.top="0";
        bgObj.style.background="#cccccc";
        bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
        bgObj.style.opacity="0.6";
        bgObj.style.left="0";
        bgObj.style.width=sWidth + "px";
        bgObj.style.height=sHeight + "px";
        bgObj.style.zIndex = "10000";
        document.getElementById('forcar').appendChild(bgObj);

        var msgObj=document.createElement("div");
        msgObj.setAttribute("id","msgDiv");
        msgObj.setAttribute("align","center");
        msgObj.style.background="white";
        msgObj.style.position = "fixed";
        msgObj.style.top = "0px";
        msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
        msgObj.style.marginLeft = "280px" ;
        msgObj.style.width = msgw + "px";
        msgObj.style.height =(msgh+18) + "px";
        msgObj.style.textAlign = "center";
        msgObj.style.lineHeight ="25px";
        msgObj.style.zIndex = "10001";

        var title=document.createElement("h4");
        title.setAttribute("id","msgTitle");
        title.setAttribute("align","right");
        title.style.margin="0";
        if(is360==true)
    	{
        	title.style.padding="0px";
    	}
    else{
    	title.style.padding="3px";
    }
        title.style.padding="3px";
        title.style.background=bordercolor;
        title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
        title.style.opacity="0.75";
        title.style.border="1px solid " + bordercolor;
        title.style.height="18px";
        title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
        title.style.color="white";
        title.style.cursor="pointer";
        title.innerHTML="关闭";
        title.onclick=function(){
            document.getElementById('forcar').removeChild(bgObj);
            document.getElementById("msgDiv").removeChild(title);
            document.getElementById('forcar').removeChild(msgObj);
        };

        
        
        
        
        var msgframe=document.createElement("iframe");
        msgframe.setAttribute("id","msgframe");
        msgframe.setAttribute("align","center");
        msgframe.setAttribute("scrolling","yes");
        msgframe.setAttribute("src","showdetail/shoppingcar.jsp");
        msgframe.style.background="white";
        msgframe.style.border="1px solid " + bordercolor;
        msgframe.style.bottom = "50px";
        msgframe.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
        msgframe.style.width = msgw + "px";
        msgframe.style.height =msgh +40+ "px";
        msgframe.style.textAlign = "center";
        msgframe.style.lineHeight ="25px";
        
        document.getElementById('forcar').appendChild(msgObj);
        document.getElementById("msgDiv").appendChild(title);
        document.getElementById("msgDiv").appendChild(msgframe);
      
  
    }