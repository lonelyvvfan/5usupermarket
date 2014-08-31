function userDelete_comfirm(form_id){
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该用户？");
	if(answer==true)
		{
		oform.action="admin/adminshowUser!deleteuserbyid";
		}
}

function addUser_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该用户吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowUser!adduser" ;
		}
}

function updateUser_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该用户信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowUser!alteruser";
		}
}

function goodDelete_comfirm(form_id){
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该商品？");
	if(answer==true)
		{
		oform.action="admin/adminshowGoods!deletegoodsbyid";
		}
}

function update_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该商品信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowGoods!altergoods";
		}
}

function addGood_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该商品吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowGoods!addgoods" ;
		}
}

function secGoodDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该二手商品吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowsecGoods!deletesecgoodsbyid";
		}
}

function addSecGood_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该二手商品吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowsecGoods!addsecgoods" ;
		}
}

function updateSceGood_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该二手商品信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowsecGoods!altersecgoods";
		}
}

function takeoutDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该外卖商品吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowTakeout!deletetakeoutbyid";
		}
}

function addTakeout_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该外卖商品吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowTakeout!addtakeout";
		}
}

function updateTakeout_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该外卖商品信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowTakeout!altertakeout" ;
		}
}


function greatSellerDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该推荐商家吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowGreatseller!deletegreatsellerbyid";
		}
}

function addGreatSeller_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该推荐商家吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowGreatseller!addgreatseller";
		}
}

function updateGreatSeller_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该推荐商家信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowGreatseller!altergreatseller" ;
		}
}

function orderDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该订单吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowOrder!deleteorderbyid";
		}
}

function addOrder_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该订单吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowOrder!addorder1";
		}
}

function updateOrder_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该订单信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowOrder!alterorder" ;
		}
}

function updateOrder1_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该订单信详情息？");
	if(answer==true)
		{
		oform.action="admin/adminshowOrder!alterorderdetail" ;
		}
}

function sellerDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该外卖商家吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowSeller!deletesellerbyid";
		}
}

function addSeller_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该外卖商家吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowSeller!addseller";
		}
}

function updateSeller_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该外卖商家信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowSeller!alterseller";
		}
}

function comboDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该套餐吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowCombo!deletecombobyid";
		}
}

function addCombo_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该套餐吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowCombo!addcombo";
		}
}

function updateCombo_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该套餐信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowCombo!altercombo";
		}
}

function helpDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该帮助信息吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowHelpcenter!deletehelpbyid";
		}
}

function addHelp_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该帮助信息吗？");
	if(answer==true)
		{
		oform.action="admin/adminshowHelpcenter!addhelp";
		}
}

function updateHelp_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该帮助信息？");
	if(answer==true)
		{
		oform.action="admin/adminshowHelpcenter!alterhelp";
		}
}

function user_updateUser_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改信息？");
	if(answer==true)
		{
		oform.action="user/usermanage!alteruser";
		}
}

function user_addSecGoods_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定添加该二手商品吗？");
	if(answer==true)
		{
		oform.action="user/secgoodsmanage!addsecgoods";
		}
}

function user_updatesecGood_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改信息？");
	if(answer==true)
		{
		oform.action="user/secgoodsmanage!altersecgoods";
		}
}

function user_secGoodDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该二手商品吗？");
	if(answer==true)
		{
		oform.action="user/secgoodsmanage!deletesecgoodsbyid";
		}
}

function seller_updateSeller_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改信息？");
	if(answer==true)
		{
		oform.action="seller/sellershowSeller!alterseller";
		}
}

function seller_updateTakeout_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定修改该外卖信息？");
	if(answer==true)
		{
		oform.action="seller/sellershowSeller!altertakeout";
		}
}

function seller_addTakeout_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定发布该外卖商品吗？");
	if(answer==true)
		{
		oform.action="seller/sellershowSeller!addtakeout";
		}
}

function seller_takeoutDelete_comfirm(form_id){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除该外卖商品吗？");
	if(answer==true)
		{
		oform.action="seller/sellershowSeller!deletetakeoutbyid";
		}
}

function selectAll(){
	var oCheckbox=document.getElementById("check_all");
	var oChboxs=document.getElementsByName("checkbox");
	if(oCheckbox.checked==true)
		{
		for(var i=0;i<oChboxs.length;i++)
			{
			oChboxs[i].checked="ture";
			}
		}
	else
		{
		 for(i=0;i<oChboxs.length;i++)
		 {
		  oChboxs[i].checked="";
		 }
		
		}
}




function upjia(v){
	switch(v){
	case '1':
		var answer=confirm("确定删除所有选中的商品吗？");
		if(answer==true)
			{
			document.getElementById("myform").action="admin/adminshowGoods!deletecheckbox";
			document.getElementById("myform").submit();
			}
		break;
	case '2':
		var answer1=confirm("确定上架所有选中的商品吗？");
		if(answer1==true){
		document.getElementById("myform").action="admin/adminshowGoods!upjia";
		document.getElementById("myform").submit();}
		break;
	case '3':
		var answer2=confirm("确定下架所有选中的商品吗？");
		if(answer2==true){
		document.getElementById("myform").action="admin/adminshowGoods!downjia";
		document.getElementById("myform").submit();}
		break;
	case '4':
		var answer3=confirm("以下是下架的商品");
		if(answer3==true){
			document.getElementById("myform").action="admin/adminshowGoods!findgoodsspecial1?shelves=0";
			document.getElementById("myform").submit();}
		}
	}

function combojia(v){
	switch(v){
	case '1':
		var answer=confirm("确定删除所有选中的商品吗？");
		if(answer==true)
			{
			document.getElementById("myform").action="admin/adminshowCombo!deletecheckbox";
			document.getElementById("myform").submit();
			}
		break;
	case '2':
		var answer1=confirm("确定上架所有选中的商品吗？");
		if(answer1==true){
		document.getElementById("myform").action="admin/adminshowCombo!upjia";
		document.getElementById("myform").submit();}
		break;
	case '3':
		var answer2=confirm("确定下架所有选中的商品吗？");
		if(answer2==true){
		document.getElementById("myform").action="admin/adminshowCombo!downjia";
		document.getElementById("myform").submit();}
		break;
	case '4':
		var answer3=confirm("以下是下架的商品");
		if(answer3==true){
			document.getElementById("myform").action="admin/adminshowCombo!findgoodsspecial1?shelves=0";
			document.getElementById("myform").submit();}
		}
	}

function secupjia(v){
	switch(v){
	case '1':
		var answer=confirm("确定删除所有选中的商品吗？");
		if(answer==true)
			{
			document.getElementById("myform").action="admin/adminshowsecGoods!deletecheckbox";
			document.getElementById("myform").submit();
			}
		break;
	case '2':
		var answer1=confirm("确定上架所有选中的商品吗？");
		if(answer1==true){
		document.getElementById("myform").action="admin/adminshowsecGoods!upjia";
		document.getElementById("myform").submit();}
		break;
	case '3':
		var answer2=confirm("确定下架所有选中的商品吗？");
		if(answer2==true){
		document.getElementById("myform").action="admin/adminshowsecGoods!downjia";
		document.getElementById("myform").submit();}
		break;
	}
	
}


function usersecupjia(v){
	switch(v){
	case '1':
		var answer=confirm("确定删除所有选中的商品吗？");
		if(answer==true)
			{
			document.getElementById("myform").action="user/secgoodsmanage!deletecheckbox";
			document.getElementById("myform").submit();
			}
		break;
	case '2':
		var answer1=confirm("确定上架所有选中的商品吗？");
		if(answer1==true){
		document.getElementById("myform").action="user/secgoodsmanage!upjia";
		document.getElementById("myform").submit();}
		break;
	case '3':
		var answer2=confirm("确定下架所有选中的商品吗？");
		if(answer2==true){
		document.getElementById("myform").action="user/secgoodsmanage!downjia";
		document.getElementById("myform").submit();}
		break;
	}
	
}


function takeupjia(v){
	switch(v){
	case '1':
		var answer=confirm("确定删除所有选中的商品吗？");
		if(answer==true)
			{
			document.getElementById("myform").action="admin/adminshowTakeout!deletecheckbox";
			document.getElementById("myform").submit();
			}
		break;
	case '2':
		var answer1=confirm("确定上架所有选中的商品吗？");
		if(answer1==true)
			{
		document.getElementById("myform").action="admin/adminshowTakeout!upjia";
		document.getElementById("myform").submit();}
		break;
	case '3':
		var answer2=confirm("确定下架所有选中的商品吗？");
		if(answer2==true)
			{
		document.getElementById("myform").action="admin/adminshowTakeout!downjia";
		document.getElementById("myform").submit();}
		break;
	}
	
}


function omg(v){
	switch(v){
	case '1':
		var answer=confirm("确定删除所有选中的商品吗？");
		if(answer==true)
			{
			document.getElementById("myform").action="seller/sellershowSeller!deletecheckbox";
			document.getElementById("myform").submit();
			}
		break;
	case '2':
		var answer2=confirm("确定上架所有选中的商品吗？");
		if(answer2==true){
		document.getElementById("myform").action="seller/sellershowSeller!upjia";
		document.getElementById("myform").submit();}
		break;
	case '3':
		var answer3=confirm("确定下架所有选中的商品吗？");
		if(answer3==true){
		document.getElementById("myform").action="seller/sellershowSeller!downjia";
		document.getElementById("myform").submit();}
		break;
	}
	
}


function greatsellerupjia(v){
	switch(v){
	case '1':
		var answer=confirm("确定删除所有选中的商品吗？");
		if(answer==true)
			{
			document.getElementById("myform").action="admin/adminshowGreatseller!deletecheckbox";
			document.getElementById("myform").submit();
			}
		break;
	case '2':
		var answer1=confirm("确定上架所有选中的商品吗？");
		if(answer1==true)
			{
		document.getElementById("myform").action="admin/adminshowGreatseller!upjia";
		document.getElementById("myform").submit();}
		break;
	case '3':
		var answer2=confirm("确定下架所有选中的商品吗？");
		if(answer2==true)
			{
		document.getElementById("myform").action="admin/adminshowGreatseller!downjia";
		document.getElementById("myform").submit();}
		break;
	}
	
}

function orderupjia(v){
	switch(v){
	case '1':
		var answer=confirm("确定删除所有选中的订单吗？");
		if(answer==true)
			{
			document.getElementById("myform").action="admin/adminshowOrder!deletecheckbox";
			document.getElementById("myform").submit();
			}
		break;
	case '2':
		var answer1=confirm("确定修改选中的订单状态为完成吗？");
		if(answer1==true)
			{
		document.getElementById("myform").action="admin/adminshowOrder!upjia";
		document.getElementById("myform").submit();}
		break;
	case '3':
		var answer2=confirm("确定修改选中的订单状态为配送中吗？");
		if(answer2==true)
			{
		document.getElementById("myform").action="admin/adminshowOrder!downjia";
		document.getElementById("myform").submit();}
		break;
	case '4':
		var answer2=confirm("确定导出所选的到excel吗？");
		if(answer2==true)
			{
		document.getElementById("myform").action="admin/adminshowOrder!toexcel";
		document.getElementById("myform").submit();}
		break;
case '5':
	var answer2=confirm("确定导出所选的到excel吗？");
	if(answer2==true)
		{
	document.getElementById("myform").action="admin/adminshowOrder!toprint";
	document.getElementById("myform").submit();}
	break;
}
	
}

function FormSubmit(){
	document.getElementById("myform").submit();
}


function seller_secGoodDeleteAll_comfirm(){
	
	//var oform=document.getElementById(form_id);
	var answer=confirm("确定删除所有选中的外卖商品吗？");
	if(answer==true)
		{
		}
}

function admin_GoodDeleteAll_comfirm(){
	
	//var oform=document.getElementById(form_id);
	var answer=confirm("确定删除所有选中的商品吗？");
	if(answer==true)
		{
		}
}

function admin_secGoodDeleteAll_comfirm(){
	
	var oform=document.getElementById(form_id);
	var answer=confirm("确定删除所有选中的二手商品吗？");
	if(answer==true)
		{
		oform.action = "admin/adminshowUser!deletecheckbox";
		}
}

function admin_takeoutDeleteAll_comfirm(){
	
	//var oform=document.getElementById(form_id);
	var answer=confirm("确定删除所有选中的外卖商品吗？");
	if(answer==true)
		{
		}
}

function admin_comboDeleteAll_comfirm(){
	
	//var oform=document.getElementById(form_id);
	var answer=confirm("确定删除所有选中的套餐吗？");
	if(answer==true)
		{
		}
}

function user_allOption_comfirm(){
	
	//var oform=document.getElementById(form_id);
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.del_all.disabled=false;
		}
	else
		{
		document.all.del_all.disabled=true;
		alert("请选择要进行删除的商品");
		}
	document.all.del_all.disabled=false;
}

function user_allUp_comfirm(){
	
	//var oform=document.getElementById(form_id);
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.up_all.disabled=false;
		}
	else
		{
		document.all.up_all.disabled=true;
		alert("请选择要上架的商品");
		}
	document.all.up_all.disabled=false;
}

function user_allDown_comfirm(){
	
	//var oform=document.getElementById(form_id);
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.down_all.disabled=false;
		}
	else
		{
		document.all.down_all.disabled=true;
		alert("请选择要下架的商品");
		}
	document.all.down_all.disabled=false;
}

function delAll_confirm(){
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.bt1.disabled=false;
		}
	else
		{
		document.all.bt1.disabled=true;
		alert("请先选择要删除的选项");
		}
	document.all.bt1.disabled=false;
}

function upAll_confirm(){
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.bt2.disabled=false;
		}
	else
		{
		document.all.bt2.disabled=true;
		alert("请选择要上架的商品");
		}
	document.all.bt2.disabled=false;
}

function downAll_confirm(){
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.bt3.disabled=false;
		}
	else
		{
		document.all.bt3.disabled=true;
		alert("请选择要下架的商品");
		}
	document.all.bt3.disabled=false;
}

function admin_delAllOrder_confirm(){
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.bt1.disabled=false;
		}
	else
		{
		document.all.bt1.disabled=true;
		alert("请选择要删除的订单");
		}
	document.all.bt1.disabled=false;
}

function admin_finishAllOrder_confirm()
{
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.bt2.disabled=false;
		}
	else
		{
		document.all.bt2.disabled=true;
		alert("请选择要修改的订单");
		}
	document.all.bt2.disabled=false;
	}
function admin_doingAllOrder_confirm(){
	var oChboxs=document.getElementsByName("checkbox");
	var count=0;
	for(var i=0;i<oChboxs.length;i++)
		{
		if(oChboxs[i].checked==true)
			count++;
		}
	if(count>0)
		{
		document.all.bt3.disabled=false;
		}
	else
		{
		document.all.bt3.disabled=true;
		alert("请选择要修改的订单");
		}
	document.all.bt3.disabled=false;
}

function checkNum(obj) {
    //检查是否是非数字值
    if (isNaN(obj.value)) {
    	alert("请输入数字");
        obj.value = "";
    }
    if (obj != null) {
        //检查小数点后是否对于两位http://blog.csdn.net/shanzhizi
        if (obj.value.toString().split(".").length > 1 && obj.value.toString().split(".")[1].length > 2) {
            alert("小数点后多于两位！");
            obj.value = "";
        }
    }
}