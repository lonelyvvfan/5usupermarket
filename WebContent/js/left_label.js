var isclosed={
		"0":"已完成",
		"1":"配送中",
		"2":"全部",
		"3":"已下单",
};
function select(type){
	document.write(isclosed[type]);
}

	var status={
			"0":"上架",
			"1":"下架",
			"2":"缺货",
		};
		function selectstatus(type){
			document.write(status[type]);
		}
	
var author={
		"0":"超级管理员",
		"1":"外卖卖家",
		"2":"普通用户",
	};
	function selectauthor(type){
		document.write(author[type]);
	}

var newgoods={
			"0":"否",
			"1":"是",
		};
function selectnewgoods(type){
	document.write(newgoods[type]);
}
	
var hot={
		"0":"否",
		"1":"是",
	};
	function selecthot(type){
		document.write(hot[type]);
	}
	
	var health={
			"0":"否",
			"1":"是",
		};
		function selecthealth(type){
			document.write(health[type]);
		}

var special={
		"0":"否",
		"1":"是",
};
function selectspecial(type){
	document.write(special[type]);
}

var recommend={
		"0":"否",
		"1":"是",
};
function selectrecommend(type){
	document.write(recommend[type]);
}

var shelves={
		"0":"下架",
		"1":"上架",
		"2":"全部",
};
function selectshelves(type){
	document.write(shelves[type]);
}

var recency={
		"":"未选择",
		"0":"全新",
		"1":"非全新",
};
function selectrecency(type){
	document.write(recency[type]);
}

var payway={
		"0":"支付宝",
		"1":"当面付",
};
function selectpayway(type){
	document.write(payway[type]);
}

var sex={
		"":"未选择",
		"0":"女",
		"1":"男",
};
function selectsex(type){
	document.write(sex[type]);
}

var school={
		"":"未选择校区",
		"0":"浙江工商大学",
		"1":"浙江财经大学",
		"2":"中国计量学院现代科技学院",
		"3":"杭州师范大学",
		"4":"浙江经贸职业技术学院",
		"5":"浙江金融职业技术学院",
		"6":"浙江水利水电学院",
		"7":"浙江经济职业技术学院",
		"8":" ",
};
function selectschool(type){
	document.write(school[type]);
}

var living={
		"":"未选择生活区",
		"0":"钱江湾",
		"1":"金沙港",
		"2":"成蹊苑",
		"3":"桃李苑",
		"4":"计量（东）生活区",
		"5":"仁和社区",
		"6":"成蹊苑",
		"7":"桃李苑",
		"8":"水利水电生活区",
		"9":"玉屏洲",
		"10":" ",
};
function selectliving(type){
	document.write(living[type]);
}

var arrivedtime={
		"":"",
		"0":"09:30-10:00",
		"1":"10:30—11:00",
		"2":"11:30 —12:00",
		"3":"12:30—13:00",
		"4":"13:30—14:00",
		"5":"14:30—15:00",
		"6":"15:30—16:00",
		"7":"16:30—17:00",
		"8":"17:30—18:00",
		"9":"18:30—19:00",
		"10":"19:30-20:00",
		"11":"20:30—21:00",
		"12":"21:30—22:00",
};
function selectarrivedtime(type){
	document.write(arrivedtime[type]);
}

var goods_subtypes={
		"1":"全部",
		"2":"零食进口",
		"3":"饮料",
		"4":"其他",
		"5":"苹果",
		"6":"香蕉",
		"7":"梨",
		"8":"其他",
		"9":"零食",
		"10":"方便面",
		"11":"其他",
		"12":"奶制品",
		"13":"饮料",
		"14":"其他",
		"15":"纸制品",
		"16":"美容",
		"17":"洗护",
		"18":"其他",
		"19":"电子数码",
		"20":"办公文具",
		"21":"其他",
		"22":"水",
		"23":"其他专区"
		
};
function selectgoods_subtypes(type){
	document.write(goods_subtypes[type]);
}

var goods_supertypes={
		"1":"全部",
		"2":"进口零食",
		"3":"水果专区",
		"4":"休闲素食",
		"5":"乳品饮料",
		"6":"生活用品",
		"7":"办公数码",
		"8":"其他专区",
};
function selectgoods_supertypes(type){
	document.write(goods_supertypes[type]);
}


var secgoods_subtypes={
		"1":"全部",
		"2":"英语类",
		"3":"数学类",
		"4":"公共科学",
		"5":"其他",
		"6":"手机数码",
		"7":"其他数码",
		"8":"自行车",
		"9":"电瓶车",
		"10":"其他",
		"11":"笔记本相关",
		"12":"台式机相关",
		"13":"其他",
		"14":"其他专区"
};
function selectsecgoods_subtypes(type){
	document.write(secgoods_subtypes[type]);
}

var secgoods_supertypes={
		"1":"全部",
		"2":"二手书籍",
		"3":"手机数码",
		"4":"电瓶单车",
		"5":"电脑周边",
		"6":"其他专区",
};
function selectsecgoods_supertypes(type){
	document.write(secgoods_supertypes[type]);
}

var takeout_subtypes={
		"1":"全部",
		"2":"豆制品",
		"3":"面包",
		"4":"其他",
		"5":"面类",
		"6":"饭类",
		"7":"煲仔类",
		"8":"其他",
		"9":"面类",
		"10":"汤类",
		"11":"其他",
};
function selecttakeout_subtypes(type){
	document.write(takeout_subtypes[type]);
}

var takeout_supertypes={
		"1":"全部",
		"2":"早餐",
		"3":"中餐",
		"4":"晚餐",
};
function selecttakeout_supertypes(type){
	document.write(takeout_supertypes[type]);
}



var greatseller_subtypes={
		"1":"全部",
		"2":"套装",
		"3":"上衣",
		"4":"下衣",
		"5":"休闲",
		"6":"运动套装",
		"7":"其他",
		"8":"套装",
		"9":"上衣",
		"10":"下衣",
		"11":"手机",
		"12":"相机",
		"13":"手表",
		"14":"其他",
		"15":"电脑",
		"16":"电脑配件",
		"17":"其他",
		"18":"进口",
		"19":"饮料",
		"20":"其他",
		"21":"专业书籍",
		"22":"文学",
		"23":"法律",
		"24":"其他",
		"25":"食疗保健",
		"26":"医药保健",
		"27":"其他",
		
};
function selectgreatseller_subtypes(type){
	document.write(greatseller_subtypes[type]);
}

var greatseller_supertypes={
		"1":"全部",
		"2":"女装/内衣",
		"3":"运动休闲",
		"4":"男装/内衣",
		"5":"手机数码",
		"6":"电脑办公",
		"7":"食品",
		"8":"图书影像",
		"9":"医药保健",
};
function selectgreatseller_supertypes(type){
	document.write(greatseller_supertypes[type]);
}



var over={
		"1":"是",
        "0":"否",
};
function overhead(a){
	document.write(over[a]);
}

function sub(a){
	document.write(a.substr(0,10));
}

function change(a){
	if(a==0)
		return false;
    document.getElementById('l1').style.display='none';
    document.getElementById('l2').style.display='block';
    document.getElementById('r').style.display='none';
    for(var i=1;i<5;i++){
        document.getElementById('r'+i).style.display='none';
    }
    document.getElementById('r'+a).style.display='block';
}

