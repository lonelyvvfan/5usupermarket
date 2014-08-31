		$(document).ready(function(){
			$.ajax({
		        url: 'test!findpage',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	var t=-1;
		        	goodspage=responseResult.listb;
		            $(responseResult.listb).each(function(){
		            	t++;
		            	if (t>=2){
		            	$('#p'+t).empty();
		            	$('#p'+t).append('<tr>');
		            	for (var i=1;i<=Math.ceil(this/8)&&i<=10;i++)
		            	{
		            		if (i==1){
			            		$('#p'+t).append('<td class='+'"hover" '+'onclick='+'"mOver('+t+','+i+');page(this,'+t+')"'+'>'+i+'</td>');
			            	}
			            	else $('#p'+t).append('<td  onclick='+'"mOver('+t+','+i+');page(this,'+t+')"'+'>'+i+'</td>');
		            	}  
		              	$('#p'+t).append('</tr>');
		            	}
			        });
		        }
		    });
			
			$.ajax({
		        url: 'test!findnotice',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#right_table_content').empty();
		        	var num=1;
		        	var s="";
		        	$(responseResult.listt).each(function(){
		        		if (num===1)
		        		{
		        			s=s+'<a href='+'"showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}
		        		else	if (num===2)
		        		{
		        			s=s+'<a href='+'"showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}else	if (num===3)
		        		{
		        			s=s+'<a href='+'"showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}else	if (num===4)
		        		{
		        			s=s+'<a href='+'"showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>';
		        		}
		            	num++;
			        });
		        	$('#right_table_content').append(s);
		        }
		    });	
			$.ajax({
		        url: 'test!findrecommend',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		            $(responseResult.list).each(function(){
		            	$('#q1').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q1'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });
			$.ajax({
		        url: 'test?suptypeid=2&&subtypeid=1',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$(responseResult.list).each(function(){
		            	$('#q2').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q2'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });
			    $.ajax({
			        url: 'test?suptypeid=3&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$(responseResult.list).each(function(){
			            	$('#q3').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q3'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
				        });
			        }
			    });
			    $.ajax({
			        url: 'test?suptypeid=4&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$(responseResult.list).each(function(){
			            	$('#q4').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q4'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
				        });
			        }
			    });
			    $.ajax({
			        url: 'test?suptypeid=5&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$(responseResult.list).each(function(){
			            	$('#q5').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q5'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
				        });
			        }
			    });
			    $.ajax({
			        url: 'test?suptypeid=6&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$(responseResult.list).each(function(){
			            	$('#q6').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q6'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
				        });
			        }
			    });
			    $.ajax({
			        url: 'test?suptypeid=7&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$(responseResult.list).each(function(){
			            	$('#q7').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q7'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
				        });
			        }
			    });
			    $.ajax({
			        url: 'test?suptypeid=8&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$(responseResult.list).each(function(){
			            	$('#q8').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q8'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
				        });
			          
			        }
			    });	
			});		
		
		function out1()
		{
			var top=document.getElementById("gonggao");
			var content=document.getElementById("right_table_content");
			var other=document.getElementById("wuyou");
			top.bgColor="#e99517";
			top.style.color="white";
			other.bgColor="transparent";
			other.style.color="black";
			$.ajax({
		        url: 'test!findnotice',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#right_table_content').empty();
		        	var num=1;
		        	var s="";
		        	$(responseResult.listt).each(function(){
		        		if (num===1)
		        		{
		        			s=s+'<a href='+'"showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}
		        		else	if (num===2)
		        		{
		        			s=s+'<a href='+'"showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}else	if (num===3)
		        		{
		        			s=s+'<a href='+'"showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}else	if (num===4)
		        		{
		        			s=s+'<a href='+'"showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>';
		        		}
		            	num++;
			        });
		        	$('#right_table_content').append(s);
		        }
		    });	
			
			}
		
		function clickall(n)
		{
			$.ajax({
		        url: 'test!findpage',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	var t=-1;
		        	goodspage=responseResult.listb;
		            $(responseResult.listb).each(function(){
		            	t++;
		            	if (t==n){
		            	$('#p'+t).empty();
		            	$('#p'+t).append('<tr>');
		            	//var int i;
		            	for (var i=1;i<=Math.ceil(this/8)&&i<=10;i++)
		            	{
		            		if (i==1){
			            		$('#p'+t).append('<td class='+'"hover" '+'onclick='+'"mOver('+t+','+i+');page(this,'+t+')"'+'>'+i+'</td>');
			            	}
			            	else $('#p'+t).append('<td  onclick='+'"mOver('+t+','+i+');page(this,'+t+')"'+'>'+i+'</td>');
		            	}  
		              	$('#p'+t).append('</tr>');
		            	}
			        });
		        }
		    });
			 $.ajax({
			        url: 'test?suptypeid='+n+'&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$('#q'+n).empty();
			        	$('#q'+n).append('<li'+' id='+'"sort_left"'+'><img src='+'"image/goods/index'+n+'.png"'+'></li>');
			            $(responseResult.list).each(function(){
			            	$('#q'+n).append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q"+n+"'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
				        });
				
			        }
			    });				  
		}	
		
		function mOver(m,n)
		{
			$('#p'+m).empty();
        	$('#p'+m).append('<tr>');
        	var k=Math.ceil(goodspage[m]/8);
        	if (n>6){
        		if (k-n<4)	{
        			cur=9-(k-n);
        			if (n-cur<=0) cur=n-1;
        		}else{
        			cur=5;
        		}
        		for (var i=n-cur;i<=n+4&&i<=k;i++)
            	{
            		if (i==1){
            			if(i==n)
            			{$('#p'+m).append('<td '+'class='+'"nowpage hover"'+' onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');}
            			
            			else $('#p'+m).append('<td class='+'"hover" '+'onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');
                	}
            		else if(i==n)
            			{$('#p'+m).append('<td '+'class='+'"nowpage"'+' onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');}
                	else $('#p'+m).append('<td  onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');
            	}  
        	}
        	else
        		for (var i=1;i<=10&&i<=k;i++)
            	{
            		if (i==1){
            			if(i==n)
            			{$('#p'+m).append('<td '+'class='+'"nowpage hover"'+' onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');}
            			else $('#p'+m).append('<td class='+'"hover" '+'onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');
                	}
            		else if(i==n)
        			{$('#p'+m).append('<td '+'class='+'"nowpage"'+' onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');}
                	else $('#p'+m).append('<td  onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');
            	}  
          	$('#p'+m).append('</tr>');
			$.ajax({
		        url: 'test?currentPage='+n+'&&suptypeid='+m+'&&subtypeid=1',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q'+m).empty();
		        	$('#q'+m).append('<li'+' id='+'"sort_left"'+'><img src='+'"image/goods/index'+m+'.png"'+'></li>');
		        	$(responseResult.list).each(function(){
		            	$('#q'+m).append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q"+m+"'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
				  
		        }
		    });
		}	
		
		function nOver(m,j,n)
		{
			$('#p'+m).empty();
        	$('#p'+m).append('<tr>');
        	var k=Math.ceil(goodspage[m]/8);
        	if (j>6){
        		if (k-j<4)	{
        			cur=9-(k-j);
        			if (j-cur<=0) cur=j-1;
        		}else{
        			cur=5;
        		}
        		for (var i=j-cur;i<=j+4&&i<=k;i++)
            	{
            		if (i==1){
            			if(i==j)
            			{$('#p'+m).append('<td '+'class='+'"nowpage hover"'+' onclick='+'"nOver('+m+','+i+','+n+');"'+'>'+i+'</td>');}
            			
            			else $('#p'+m).append('<td class='+'"hover" '+'onclick='+'"nOver('+m+','+i+','+n+');"'+'>'+i+'</td>');
                	}
            		else if(i==j)
            			{$('#p'+m).append('<td '+'class='+'"nowpage"'+' onclick='+'"nOver('+m+','+i+','+n+');"'+'>'+i+'</td>');}
                	else $('#p'+m).append('<td  onclick='+'"nOver('+m+','+i+','+n+');"'+'>'+i+'</td>');
            	}  
        	}
        	else
        		for (var i=1;i<=10&&i<=k;i++)
            	{
            		if (i==1){
            			if(i==n)
            			{$('#p'+m).append('<td '+'class='+'"nowpage hover"'+' onclick='+'"nOver('+m+','+i+','+n+');"'+'>'+i+'</td>');}
            			else $('#p'+m).append('<td class='+'"hover" '+'onclick='+'"nOver('+m+','+i+','+n+');"'+'>'+i+'</td>');
                	}
            		else if(i==n)
        			{$('#p'+m).append('<td '+'class='+'"nowpage"'+' onclick='+'"nOver('+m+','+i+','+n+');"'+'>'+i+'</td>');}
                	else $('#p'+m).append('<td  onclick='+'"nOver('+m+','+i+','+n+');"'+'>'+i+'</td>');
            	}  
          	$('#p'+m).append('</tr>');
			$.ajax({
		        url: 'test?currentPage='+j+'&&suptypeid='+m+'&&subtypeid='+n,
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q'+m).empty();
		        	$('#q'+m).append('<li'+' id='+'"sort_left"'+'><img src='+'"image/goods/index'+m+'.png"'+'></li>');	        	  
		        	$(responseResult.list).each(function(){
		            	$('#q'+m).append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q"+m+"'"+','+this.id+')'+'">购买</button></a></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });
		}	
		
		function choose(m,n)
		{
			$.ajax({
		        url: 'test!findpage?suptypeid='+m+'&&subtypeid='+n,
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	var t=-1;
		        	//goodspage=responseResult.listb;
		            $(responseResult.listb).each(function(){
		            	t++;
		            	if (t==m){
		            		$('#p'+m).empty();
		                	$('#p'+m).append('<tr>');
		                	var k=Math.ceil(this/8);
		                		for (var i=1;i<=10&&i<=k;i++)
		                    	{
		                    		if (i==1){
		                    			if(i==n)
		                    			{$('#p'+m).append('<td '+'class='+'"nowpage hover"'+' onclick='+'"nOver('+t+','+i+','+n+');"'+'>'+i+'</td>');}
		                    			else $('#p'+m).append('<td class='+'"hover" '+'onclick='+'"nOver('+t+','+i+','+n+');"'+'>'+i+'</td>');
		                        	}
		                    		else if(i==n)
		                			{$('#p'+m).append('<td '+'class='+'"nowpage"'+' onclick='+'"nOver('+t+','+i+','+n+');"'+'>'+i+'</td>');}
		                        	else $('#p'+m).append('<td  onclick='+'"nOver('+t+','+i+','+n+');"'+'>'+i+'</td>');
		                    	}  
		                  	$('#p'+m).append('</tr>');
		            	}
			        }); 
		        }
		    });
			//init(m,n);
			$.ajax({
		        url: 'test?suptypeid='+m+'&&subtypeid='+n,
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q'+m).empty();
		        	$('#q'+m).append('<li'+' id='+'"sort_left"'+'><img src='+'"image/goods/index'+m+'.png"'+'></li>');		        	  
		        	$(responseResult.list).each(function(){
		            	$('#q'+m).append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q"+m+"'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });	
		}
		
		
		
		function Over1()
		{
			$.ajax({
		        url: 'test!findrecommend',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q1').empty();
		        	$(responseResult.list).each(function(){
		            	$('#q1').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q1'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });
		}
		
		function Over2()
		{
			$.ajax({
		        url: 'test!findcombo',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q1').empty();
		        	$(responseResult.listc).each(function(){
		            	$('#q1').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showCombo!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buycombo('+"'q1'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });
		}
		
		function Over3()
		{
			$.ajax({
		        url: 'test!findhealth',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q1').empty();
		        	$(responseResult.list).each(function(){
		            	$('#q1').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q1'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });
		}	
		function Over4()
		{
			$.ajax({
		        url: 'test!findhot',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q1').empty();
		        	$(responseResult.list).each(function(){
		            	$('#q1').append('<li id='+'"sort_list"'+'><a class='+'"good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q1'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });
		}
		function Over5()
		{
			$.ajax({
		        url: 'test!findspecial',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q1').empty();
		        	$(responseResult.list).each(function(){
		            	$('#q1').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q1'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });
		}
		function Over6()
		{
			$.ajax({
		        url: 'test!findnewgoods',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#q1').empty();
		        	$(responseResult.list).each(function(){
		            	$('#q1').append('<li id='+'"sort_list"'+'><a class='+'"good good'+this.id+'"'+' href='+'"showGoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.nowprice+'</b><strike>&#65509;'+this.price+'</strike><button onclick="'+'buy('+"'q1'"+','+this.id+')'+'">购买</button></p><h3>'+this.reason+'</h3></li></a>');
			        });
		        }
		    });	
		}
		
		function buy(pid,goodsid)
		{
			$.ajax({
		        url: 'ajaxshopping?goodsid='+goodsid+'&&number=1',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	//alert(success);
		        	
		                var good=$("ul#"+pid+" .good"+goodsid),
		                        shop_car=$('#buy_car'),
		                        goodLeft=good.offset().left,
		                        goodTop=good.offset().top,
		                        carLeft=shop_car.offset().left,
		                        carTop=shop_car.offset().top;
		                    if($('.good:eq(1)').is(':animated')){
		                        return;
		                    }
		                    var copyGood=good.clone();

		                    $('body').append(copyGood);
		                    copyGood.css({position:'absolute',left:goodLeft,top:goodTop});
		                    copyGood.animate({width:20,height:20,left:carLeft,top:carTop,opacity:0.5},500,function(){
		                        copyGood.remove();
		                    });
		        	//alert("成功加入购物车，请到购物车查看1");
		        }
		    });	
		}
		
		function buycombo(pid,goodsid)
		{
			$.ajax({
		        url: 'ajaxshopping!buycombo?goodsid='+goodsid+'&&number=1',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	//alert(success);
		        	 var good=$("ul#"+pid+" .good"+goodsid),
                     shop_car=$('#buy_car'),
                     goodLeft=good.offset().left,
                     goodTop=good.offset().top,
                     carLeft=shop_car.offset().left,
                     carTop=shop_car.offset().top;
                 if($('.good:eq(1)').is(':animated')){
                     return;
                 }
                 var copyGood=good.clone();

                 $('body').append(copyGood);
                 copyGood.css({position:'absolute',left:goodLeft,top:goodTop});
                 copyGood.animate({width:20,height:20,left:carLeft,top:carTop,opacity:0.5},500,function(){
                     copyGood.remove();
                 });
		        	//alert("成功加入购物车，请到购物车查看");
		        }
		    });	
		}
		
		
		function buy_incar(goodsid)
		{
			var good_num=$('#good_num').val();
			$.ajax({
		        url: 'ajaxshopping?goodsid='+goodsid+'&&number='+good_num,
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	//alert(success);
		        	
		                var good=$("#big"),
		                        shop_car=$('#buy_car'),
		                        goodLeft=good.offset().left,
		                        goodTop=good.offset().top,
		                        carLeft=shop_car.offset().left,
		                        carTop=shop_car.offset().top;
		                    if($('.good:eq(1)').is(':animated')){
		                        return;
		                    }
		                    var copyGood=good.clone();

		                    $('body').append(copyGood);
		                    copyGood.css({position:'absolute',left:goodLeft,top:goodTop});
		                    copyGood.animate({width:20,height:20,left:carLeft,top:carTop,opacity:0.5},500,function(){
		                        copyGood.remove();
		                    });
		        	//alert("成功加入购物车，请到购物车查看1");
		        }
		    });	
		}
		
		function buycombo_incar(goodsid)
		{
			var good_num=$('#good_num').val();
			$.ajax({
		        url: 'ajaxshopping!buycombo?goodsid='+goodsid+'&&number='+good_num,
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	//alert(success);
		        	 var good=$("#big"),
                     shop_car=$('#buy_car'),
                     goodLeft=good.offset().left,
                     goodTop=good.offset().top,
                     carLeft=shop_car.offset().left,
                     carTop=shop_car.offset().top;
                 if($('.good:eq(1)').is(':animated')){
                     return;
                 }
                 var copyGood=good.clone();

                 $('body').append(copyGood);
                 copyGood.css({position:'absolute',left:goodLeft,top:goodTop});
                 copyGood.animate({width:20,height:20,left:carLeft,top:carTop,opacity:0.5},500,function(){
                     copyGood.remove();
                 });
		        	//alert("成功加入购物车，请到购物车查看");
		        }
		    });	
		}
		
		function deleteone(goodsid)
		{
			$.ajax({
		        url: 'ajaxshopping!delete?goodsid='+goodsid,
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	//alert(success);
		        }
		    });	
		}
		
		