function add(inventory){
	var num=document.getElementById("good_num");
	var number=parseFloat(num.value);
	number+=1;
	num.value=number;
	if(number==inventory){
		document.getElementById("plus").disabled=true;
	}
}

function delese(inventory){
	var num=document.getElementById("good_num");
	var number=parseFloat(num.value);
	if(number==1)
	{	number=1;
	num.value=number;}
	else
		{
		number-=1;
		num.value=number;
		}
	if(number<inventory){
		document.getElementById("plus").disabled=false;
	}
}

function goodnum(inventory){
	var num=document.getElementById("good_num");
	var number=parseFloat(num.value);
	if(number>inventory)
		{
		alert('亲，购买数量不得大于库存数哦');
		num.value=inventory;
		document.getElementById("plus").disabled=true;
		}
	else{
		document.getElementById("plus").disabled=false;
	}
}