$(document).ready(function(){
			$.ajax({
		        url: 'test1!findsecpage',
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
		        			s=s+'<a href='+'"user/showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}
		        		else	if (num===2)
		        		{
		        			s=s+'<a href='+'"user/showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}else	if (num===3)
		        		{
		        			s=s+'<a href='+'"user/showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
		        		}else	if (num===4)
		        		{
		        			s=s+'<a href='+'"user/showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>';
		        		}
		            	num++;
			        });
		        	$('#right_table_content').append(s);
		        }
		    });	
			$.ajax({
		        url: 'test1?suptypeid=2&&subtypeid=1',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	 $(responseResult.list).each(function(){
			            	$('#q2').append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
				        });
		        }
		    });
			    $.ajax({
			        url: 'test1?suptypeid=3&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$(responseResult.list).each(function(){
			            	$('#q3').append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
				        });
			        }
			    });
			    $.ajax({
			        url: 'test1?suptypeid=4&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	$(responseResult.list).each(function(){
			            	$('#q4').append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
				        });
			        }
			    });
			    $.ajax({
			        url: 'test1?suptypeid=5&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			            $(responseResult.list).each(function(){
			            	$('#q5').append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
				        });
			        }
			    });
			    $.ajax({
			        url: 'test1?suptypeid=6&&subtypeid=1',
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			            $(responseResult.list).each(function(){
			            	$('#q6').append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
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
        			s=s+'<a href='+'"user/showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
        		}
        		else	if (num===2)
        		{
        			s=s+'<a href='+'"user/showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
        		}else	if (num===3)
        		{
        			s=s+'<a href='+'"user/showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>'+'<br>';
        		}else	if (num===4)
        		{
        			s=s+'<a href='+'"user/showNotice!altershow?id='+this.id+'"'+' target='+"_blank"+'>'+'公告'+num+'：'+this.title+'</a>';
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
        url: 'test1!findsecpage',
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
	        url: 'test1?suptypeid='+n+'&&subtypeid=1',
	        type: 'get',
	        dataType: 'json',
	        error: function(){
	        },
	        success: function(responseResult){
	        	$('#q'+n).empty();
	        	$('#q'+n).append('<li'+' id='+'"sort_left"'+'><img src='+'"image/secondgoods/index'+n+'.png"'+'></li>');	        	  
	            $(responseResult.list).each(function(){
	            	$('#q'+n).append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
		        });
		
	        }
	    });				
	}

function choose(m,n)
{
	$.ajax({
        url: 'test1!findsecpage?suptypeid='+m+'&&subtypeid='+n,
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
                    			{$('#p'+m).append('<td '+'class='+'"nowpage hover"'+' onclick='+'"nOver('+t+','+i+','+n+');page(this,'+t+')"'+'>'+i+'</td>');}
                    			else $('#p'+m).append('<td class='+'"hover" '+'onclick='+'"nOver('+t+','+i+','+n+');page(this,'+t+')"'+'>'+i+'</td>');
                        	}
                    		else if(i==n)
                			{$('#p'+m).append('<td '+'class='+'"nowpage"'+' onclick='+'"nOver('+t+','+i+','+n+');page(this,'+t+')"'+'>'+i+'</td>');}
                        	else $('#p'+m).append('<td  onclick='+'"nOver('+t+','+i+','+n+');page(this,'+t+')"'+'>'+i+'</td>');
                    	}  
                  	$('#p'+m).append('</tr>');
            	}
	        }); 
        }
    });
	//init(m,n);
	$.ajax({
        url: 'test1?suptypeid='+m+'&&subtypeid='+n,
        type: 'get',
        dataType: 'json',
        error: function(){
        },
        success: function(responseResult){
        	$('#q'+m).empty();
        	$('#q'+m).append('<li'+' id='+'"sort_left"'+'><img src='+'"image/secondgoods/index'+m+'.png"'+'></li>');	        	          	  
            $(responseResult.list).each(function(){
            	$('#q'+m).append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
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
    			{$('#p'+m).append('<td '+'class='+'"hover nowpage"'+' onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');}
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
    			{$('#p'+m).append('<td '+'class='+'"hover nowpage"'+' onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');}
    			else $('#p'+m).append('<td class='+'"hover" '+'onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');
        	}
    		else if(i==n)
			{$('#p'+m).append('<td '+'class='+'"nowpage"'+' onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');}
        	else $('#p'+m).append('<td  onclick='+'"mOver('+m+','+i+')"'+'>'+i+'</td>');
    	}  
  	$('#p'+m).append('</tr>');
	$.ajax({
        url: 'test1?currentPage='+n+'&&suptypeid='+m+'&&subtypeid=1',
        type: 'get',
        dataType: 'json',
        error: function(){
        },
        success: function(responseResult){
        	$('#q'+m).empty();
        	$('#q'+m).append('<li'+' id='+'"sort_left"'+'><img src='+'"image/secondgoods/index'+m+'.png"'+'></li>');	        	  
            $(responseResult.list).each(function(){
            	$('#q'+m).append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
	        });
		  
        }
    });
}	

function nOver(m,i,n)
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
        url: 'test1?currentPage='+i+'&&suptypeid='+m+'&&subtypeid='+n,
        type: 'get',
        dataType: 'json',
        error: function(){
        },
        success: function(responseResult){
        	$('#q'+m).empty();
        	$('#q'+m).append('<li'+' id='+'"sort_left"'+'><img src='+'"image/secondgoods/index'+m+'.png"'+'></li>');	        	  
            $(responseResult.list).each(function(){
            	$('#q'+m).append('<li><a href='+'"user/showSecgoods!altershow?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/secondgoods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<p><b class='+'"price"'+'>&#65509;'+this.price+'</b></p><h3>'+this.reason+'</h3></li></a>');
	        });
        }
    });
}	
