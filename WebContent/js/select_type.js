function changeGoods(){
	var goods=document.getElementById("goods").value;
	var subgoods=document.getElementById("subgoods");
	subgoods.options.length=0;
	
	switch(goods)
	{
	case '1':
		var opp1 = new Option("全部", 1);
		subgoods.add(opp1);
		break;
	case '2':
		var opp1 = new Option("零食进口",2);
		subgoods.add(opp1);
		var opp2 = new Option("饮料",3);
		subgoods.add(opp2);
		var opp3 = new Option("其他",4);
		subgoods.add(opp3);
		break;
	case '3':
		var opp1 = new Option("苹果",5);
		subgoods.add(opp1);
		var opp2 = new Option("香蕉",6);
		subgoods.add(opp2);
		var opp3 = new Option("梨",7);
		subgoods.add(opp3);
		var opp4 = new Option("其他",8);
		subgoods.add(opp4);
		break;
	case '4':
		var opp1 = new Option("零食",9);
		subgoods.add(opp1);
		var opp2 = new Option("方便面",10);
		subgoods.add(opp2);
		var opp3 = new Option("其他",11);
		subgoods.add(opp3);
		break;
	case '5':
		var opp1 = new Option("奶制品",12);
		subgoods.add(opp1);
		var opp2 = new Option("饮料",13);
		subgoods.add(opp2);
		var opp3 = new Option("其他",14);
		subgoods.add(opp3);
		var opp4 = new Option("水",22);
		subgoods.add(opp4);
		break;
	case '6':
		var opp1 = new Option("纸制品",15);
		subgoods.add(opp1);
		var opp2 = new Option("美容",16);
		subgoods.add(opp2);
		var opp3 = new Option("洗护",17);
		subgoods.add(opp3);
		var opp4 = new Option("其他",18);
		subgoods.add(opp4);
		break;
	case '7':
		var opp1 = new Option("电子数码",19);
		subgoods.add(opp1);
		var opp2 = new Option("办公文具",20);
		subgoods.add(opp2);
		var opp3 = new Option("其他",21);
		subgoods.add(opp3);
		break;
	case '8':
		var opp1 = new Option("暂无分类",23);
		subgoods.add(opp1);
		break;
	}
}

function changeSecGoods(){
	var secgoods=document.getElementById("secgoods").value;
	var subsecgoods=document.getElementById("subsecgoods");
	subsecgoods.options.length=0;
	
	switch(secgoods)
	{
	case '1':
		var opp1 = new Option("全部", 1);
		subsecgoods.add(opp1);
		break;
	case '2':
		var opp1 = new Option("英语类",2);
		subsecgoods.add(opp1);
		var opp2 = new Option("数学类",3);
		subsecgoods.add(opp2);
		var opp3 = new Option("公共科学",4);
		subsecgoods.add(opp3);
		var opp4 = new Option("其他",5);
		subsecgoods.add(opp4);
		break;
	case '3':
		var opp1 = new Option("手机数码",6);
		subsecgoods.add(opp1);
		var opp2 = new Option("其他数码",7);
		subsecgoods.add(opp2);
		break;
	case '4':
		var opp1 = new Option("自行车",8);
		subsecgoods.add(opp1);
		var opp2 = new Option("电瓶车",9);
		subsecgoods.add(opp2);
		var opp3 = new Option("其他",10);
		subsecgoods.add(opp3);
		break;
	case '5':
		var opp1 = new Option("笔记本相关",11);
		subsecgoods.add(opp1);
		var opp2 = new Option("台式机相关",12);
		subsecgoods.add(opp2);
		var opp3 = new Option("其他",13);
		subsecgoods.add(opp3);
		break;
	case '6':
		var opp1 = new Option("暂无分类",14);
		subsecgoods.add(opp1);
		break;
	}
}

function changeTakeout(){
	var takeout=document.getElementById("takeout").value;
	var subtakeout=document.getElementById("subtakeout");
	subtakeout.options.length=0;
	
	switch(takeout)
	{
	case '1':
		var opp1 = new Option("全部", 1);
		subtakeout.add(opp1);
		break;
	case '2':
		var opp1 = new Option("豆制品",2);
		subtakeout.add(opp1);
		var opp2 = new Option("面包",3);
		subtakeout.add(opp2);
		var opp3 = new Option("其他",4);
		subtakeout.add(opp3);
		break;
	case '3':
		var opp1 = new Option("面类",5);
		subtakeout.add(opp1);
		var opp2 = new Option("饭类",6);
		subtakeout.add(opp2);
		var opp3 = new Option("煲仔类",7);
		subtakeout.add(opp3);
		var opp4 = new Option("其他",8);
		subtakeout.add(opp4);
		break;
	case '4':
		var opp1 = new Option("面类",9);
		subtakeout.add(opp1);
		var opp2 = new Option("汤类",10);
		subtakeout.add(opp2);
		var opp3 = new Option("其他",11);
		subtakeout.add(opp3);
		break;
	}
}

function changeGreatseller(){
	var greatseller=document.getElementById("greatseller").value;
	var subgreatseller=document.getElementById("subgreatseller");
	subgreatseller.options.length=0;
	
	switch(greatseller)
	{
	case '1':
		var opp1 = new Option("全部", 1);
		subgreatseller.add(opp1);
		break;
	case '2':
		var opp1 = new Option("套装",2);
		subgreatseller.add(opp1);
		var opp2 = new Option("上衣",3);
		subgreatseller.add(opp2);
		var opp3 = new Option("下衣",4);
		subgreatseller.add(opp3);
		break;
	case '3':
		var opp1 = new Option("休闲",5);
		subgreatseller.add(opp1);
		var opp2 = new Option("运动套装",6);
		subgreatseller.add(opp2);
		var opp3 = new Option("其他",7);
		subgreatseller.add(opp3);
		break;
	case '4':
		var opp1 = new Option("套装",8);
		subgreatseller.add(opp1);
		var opp2 = new Option("上衣",9);
		subgreatseller.add(opp2);
		var opp3 = new Option("下衣",10);
		subgreatseller.add(opp3);
		break;
	case '5':
		var opp1 = new Option("手机",11);
		subgreatseller.add(opp1);
		var opp2 = new Option("相机",12);
		subgreatseller.add(opp2);
		var opp3 = new Option("手表",13);
		subgreatseller.add(opp3);
		var opp4 = new Option("其他",14);
		subgreatseller.add(opp4);
		break;
	case '6':
		var opp1 = new Option("电脑",15);
		subgreatseller.add(opp1);
		var opp2 = new Option("电脑配件",16);
		subgreatseller.add(opp2);
		var opp3 = new Option("其他",17);
		subgreatseller.add(opp3);
		break;
	case '7':
		var opp1 = new Option("进口",18);
		subgreatseller.add(opp1);
		var opp2 = new Option("饮料",19);
		subgreatseller.add(opp2);
		var opp3 = new Option("其他",20);
		subgreatseller.add(opp3);
		break;
	case '8':
		var opp1 = new Option("专业书籍",21);
		subgreatseller.add(opp1);
		var opp2 = new Option("文学",22);
		subgreatseller.add(opp2);
		var opp3 = new Option("法律",23);
		subgreatseller.add(opp3);
		var opp4 = new Option("其他",24);
		subgreatseller.add(opp4);
		break;
	case '8':
		var opp1 = new Option("食疗保健",25);
		subgreatseller.add(opp1);
		var opp2 = new Option("医药保健",26);
		subgreatseller.add(opp2);
		var opp3 = new Option("其他",27);
		subgreatseller.add(opp3);
		break;
	}
}