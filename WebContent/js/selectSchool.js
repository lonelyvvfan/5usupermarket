function changeSch(){
	var sch=document.getElementById("sch").value;
	var buil=document.getElementById("buil");
	var detail=document.getElementById("other_add");
	var order_building=document.getElementById("order_building");
	var order_room=document.getElementById("order_room");
	buil.options.length=0;
	
	switch(sch)
	{
	case '0':
		var opp1 = new Option("钱江湾",0);
		buil.add(opp1);
		var opp2 = new Option("金沙港",1);
		buil.add(opp2);
		order_building.required=true;
		order_room.required=true;
		order_building.disabled=false;
		order_room.disabled=false;
		detail.required=false;
		detail.disabled=true;
		detail.value="";
		break;
	case '1':
		var opp1 = new Option("成蹊苑",2);
		buil.add(opp1);
		var opp2 = new Option("桃李苑",3);
		buil.add(opp2);
		order_building.required=true;
		order_room.required=true;
		order_building.disabled=false;
		order_room.disabled=false;
		detail.required=false;
		detail.disabled=true;
		detail.value="";
		break;
	case '2':
		var opp1 = new Option("计量（东）生活区",4);
		buil.add(opp1);
		order_building.required=true;
		order_room.required=true;
		order_building.disabled=false;
		order_room.disabled=false;
		detail.required=false;
		detail.disabled=true;
		detail.value="";
		break;
	case '3':
		var opp1 = new Option("仁和社区",5);
		buil.add(opp1);
		order_building.required=true;
		order_room.required=true;
		order_building.disabled=false;
		order_room.disabled=false;
		detail.required=false;
		detail.disabled=true;
		detail.value="";
		break;
	case '4':
		var opp1 = new Option("成蹊苑",6);
		buil.add(opp1);
		order_building.required=true;
		order_room.required=true;
		order_building.disabled=false;
		order_room.disabled=false;
		detail.required=false;
		detail.disabled=true;
		detail.value="";
		break;
	case '5':
		var opp1 = new Option("桃李苑",7);
		buil.add(opp1);
		order_building.required=true;
		order_room.required=true;
		order_building.disabled=false;
		order_room.disabled=false;
		detail.required=false;
		detail.disabled=true;
		detail.value="";
		break;
	case '6':
		var opp1 = new Option("水利水电生活区",8);
		buil.add(opp1);
		order_building.required=true;
		order_room.required=true;
		order_building.disabled=false;
		order_room.disabled=false;
		detail.required=false;
		detail.disabled=true;
		detail.value="";
		break;
	case '7':
		var opp1 = new Option("玉屏洲",9);
		buil.add(opp1);
		order_building.required=true;
		order_room.required=true;
		order_building.disabled=false;
		order_room.disabled=false;
		detail.required=false;
		detail.disabled=true;
		detail.value="";
		break;
	case '8':
		var opp1 = new Option("没有我的生活区",10);
		buil.add(opp1);
		order_building.required=false;
		order_room.required=false;
		order_building.disabled=true;
		order_room.disabled=true;
		detail.required=true;
		detail.disabled=false;
		order_building.value="";
		order_room.value="";
		break;
	}
}

function getB(){
	location.href="/chaoshi/normal/userlogin.jsp?name=before";
	return false;
	}