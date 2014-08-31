 function bro(){  
            var is360 = false;  
            var isIE = false;  
			var isFirefox = false;
			var isCrome = false;
			var broName = '';
			if(window.navigator.userAgent.indexOf('MSIE')!=-1&&window.navigator.appName.indexOf("Microsoft") != -1){
				isIE = true;
				broName = 'IE';
			}
			if(window.navigator.userAgent.indexOf('Firefox')!=-1){
				isFirefox = true;
				broName = 'Firefox';
			}
			if(window.navigator.userAgent.indexOf('Chrome')!=-1){
				if(window.navigator.webkitPersistentStorage){
					isCrome = true;
					broName = 'Chrome';
				}else{
					is360 = true;
					broName = '360';
				}
			}
			if(is360==true)
				{
				document.getElementById('main_right').style.marginRight='30px';
				document.getElementById('two').style.right='310px';
				document.getElementById('pho').style.right='50px';
				document.getElementById('right').style.marginRight='178px';
				document.getElementById('slider').style.left='180px';
				}

        }  