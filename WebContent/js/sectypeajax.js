$("document").ready(function(){
	var v=$('#sup').val();
	if (!v) v='1';
	getLocation('suptype', 'suptype',0,v);
	var u=$('#sub').val()
	if (!u) u='1';
	if (v != '1') {
        $('#subtype').children().remove();
        $.ajax({
            url: 'secsubtype?suptypeid=' + v ,
            type: 'get',
            dataType: 'json',
            error: function(){
                alert('请求错误');
            },
            success: function(responseResult){
            	 $('#subtype').append('<option value=1>全部</option>');
                $(responseResult.list).each(function(){
                	if (u==this.id){
                		$('#subtype').append('<option selected="selected" value="' + this.id + '">' + this.typename + '</option>');
                	}
                	else $('#subtype').append('<option value="' + this.id + '">' + this.typename + '</option>');
                });
            }
        });
    }
	else{
		$('#subtype').empty();
		$('#subtype').append('<option value="' + 1 + '">全部</option>');
	}
});

//get data by ajax
function getLocation(targetid, mark, parent,select){
    //			alert(mark);
    //			alert(parent);
    var aurl;
    if (mark == 'subtype') {
        aurl = 'secsubtype'+'?suptypeid=' + parent;
    }
    else {
          aurl = 'secsuptype';
    }
    $.ajax({
        url: aurl,
        type: 'get',
        //data: "{parent:0}",
        dataType: 'json',
        timeout: 10000,
        error: function(){
            alert('您操作过于频繁，请稍后再试！');
        },
        success: function(responseResult){
            $(responseResult.list).each(function(){
                //alert(this.id);
                if(select==this.id){
                	$("#" + targetid).append('<option selected="selected" value=' + this.id + '>' +
			                this.typename +
			                '</option>');
                }
                else {$("#" + targetid).append('<option value=' + this.id + '>' +
                this.typename +
                '</option>');
                }
            });
        }
    });
};
function changesup(){
	var v=$('#suptype option:selected') .val();//选中的值;
	if (v != '1') {
        $('#subtype').children().remove();
        $.ajax({
            url: 'secsubtype?suptypeid=' + v ,
            type: 'get',
            dataType: 'json',
            error: function(){
                alert('请求错误');
            },
            success: function(responseResult){
            	 $('#subtype').append('<option value=1>全部</option>');
                $(responseResult.list).each(function(){
                    $('#subtype').append('<option value="' + this.id + '">' + this.typename + '</option>');
                });
            }
        });
    }
	else{
		$('#subtype').empty();
		$('#subtype').append('<option value="' + 1 + '">全部</option>');
	}
}

