$(document).ready(function(){
	var sellerid=document.getElementById('sellerid').value;
	var suptypeid=document.getElementById('suptypeid').value;
	var subtypeid=document.getElementById('subtypeid').value;
			$.ajax({
		        url: 'test2!findtakeoutpage?sellerid='+sellerid+'&&suptypeid='+suptypeid+'&&subtypeid='+subtypeid,
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	var t=-1;
		        	goodspage=responseResult.listb;
		            $(responseResult.listb).each(function(){
		            	t++;
		            	if (t==suptypeid){
		            	$('#p'+2).empty();
		            	$('#p'+2).append('<tr>');
		            	//var int i;
		            	for (var i=1;i<=Math.ceil(this/8)&&i<=10;i++)
		            	{
		            		if (i==1){
			            		$('#p'+2).append('<td class='+'"hover" '+'onclick='+'"mOver('+t+','+i+')"'+'>'+i+'</td>');
			            	}
			            	else $('#p'+2).append('<td  onclick='+'"mOver('+t+','+i+')"'+'>'+i+'</td>');
		            	}  
		              	$('#p'+2).append('</tr>');
		            	}
			        });
		        }
		    });
			 $.ajax({
			        url: 'test2?sellerid='+sellerid+'&&suptypeid='+suptypeid+'&&subtypeid='+subtypeid,
			        type: 'get',
			        dataType: 'json',
			        error: function(){
			        },
			        success: function(responseResult){
			        	 $(responseResult.list).each(function(){
				            	$('#q2').append('<li><a href='+'"showTakeout!showtakeout?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<h3>'+this.reason+'</h3></li></a>');
					        });
			        }
			    });
			});		

function mOver(m,n)
{
	var sellerid=document.getElementById('sellerid').value;
	var suptypeid=document.getElementById('suptypeid').value;
	var subtypeid=document.getElementById('subtypeid').value;
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
        		$('#p'+m).append('<td class='+'"hover" '+'onclick='+'"mOver('+m+','+i+');page(this,'+m+')"'+'>'+i+'</td>');
        	}
        	else $('#p'+m).append('<td  onclick='+'"mOver('+m+','+i+');page(this,'+m+')"'+'>'+i+'</td>');
    	}  
	}
	else
		for (var i=1;i<=10&&i<=k;i++)
    	{
    		if (i==1){
        		$('#p'+m).append('<td class='+'"hover" '+'onclick='+'"mOver('+m+','+i+');page(this,'+m+')"'+'>'+i+'</td>');
        	}
        	else $('#p'+m).append('<td  onclick='+'"mOver('+m+','+i+');page(this,'+m+')"'+'>'+i+'</td>');
    	}  
  	$('#p'+m).append('</tr>');
	$.ajax({
        url: 'test2?currentPage='+n+'&&sellerid='+sellerid+'&&suptypeid='+m+'&&subtypeid='+subtypeid,
        type: 'get',
        dataType: 'json',
        error: function(){
        },
        success: function(responseResult){
        	$('#q'+2).empty();	        	  
            $(responseResult.list).each(function(){
            	$('#q'+2).append('<li><a href='+'"showTakeout!showtakeout?id='+this.id+'"'+' target='+"_blank"+'><img src='+'"images/goods/'+this.savepath+'"'+' onerror='+'"'+'javascript:this.src='+"'image/error.jpg'"+'"'+'></a>'+'<p id='+'goodsname'+' title='+'"'+this.goodsname+'"'+'>'+this.goodsname+'</p>'+'<h3>'+this.reason+'</h3></li></a>');
	        });
		  
        }
    });
}	
