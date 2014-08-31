jia=function(i){
	var num=document.getElementById(i+"");
	var number=parseFloat(num.value);
	number+=1;
	num.value=number;
	$.ajax({
        url: 'ajaxshopping!updategoods?goodsid='+i+'&number='+number,
        type: 'get',
        dataType: 'json',
        error: function(){
        },
        success: function(responseResult){
        	if (responseResult.list1[0]<=number)
        	{
        		document.getElementById("plus"+i).disabled=true;
        		alert("库存只有"+number+"件");
        	}else{
        		document.getElementById("plus"+i).disabled=false;
        		var t=-1;
                $(responseResult.list).each(function(){
                	t++;
                	if (t===0){
                		$('#sum').empty();
                		$('#sum').append(""+this);
                	}
                	else{
                		$('#good'+this.goodsid).empty();
                		$('#good'+this.goodsid).append('&#65509;'+this.total);
                	}
    	        });
        	}
        	
        }
    });
}

jian=function(i){
	var num=document.getElementById(i+"");
	var number=parseFloat(num.value);
	if(number==1)
	{	number=1;
	num.value=number;}
	else
		{
		number-=1;
		num.value=number;
		}
	$.ajax({
		url: 'ajaxshopping!updategoods?goodsid='+i+'&number='+number,
        type: 'get',
        dataType: 'json',
        error: function(){
        },
        success: function(responseResult){
        	if (responseResult.list1[0]>=number){
        		document.getElementById("plus"+i).disabled=false;
        	}
        	var t=-1;
            $(responseResult.list).each(function(){
            	t++;
            	if (t===0){
            		$('#sum').empty();
            		$('#sum').append(""+this);
            	}
            	else{
            		$('#good'+this.goodsid).empty();
            		$('#good'+this.goodsid).append('&#65509;'+this.total);
            	}
	        });
        }
    });
}

