        //KindEditor
        KindEditor.ready(function(K) {
                window.editor = K.create('#editor_1',
                { 
                	imageUploadJson : '/kindeditor/jsp/upload_json.jsp',

                	fileManagerJson : '/kindeditor/jsp/file_manager_json.jsp',

      
                    afterUpload :function(url){
                    	alert(url);
                    },
                    afterChange : function() {
                        $('.word_count2').html(this.count('text'));  //字数统计包含纯文本、IMG、EMBED，不包含换行符，IMG和EMBED算一个文字
                        //////////
                        //限制字数
                        var limitNum = 2000;  //设定限制字数
                        var pattern = '还可以输入' + limitNum + '字';
                        $('.word_surplus').html(pattern); //输入显示
                        if(this.count('text') > limitNum) {
                            pattern = ('字数超过限制，请适当删除部分内容');
                            //超过字数限制自动截取
                            var strValue = editor.text();
                            strValue = strValue.substring(0,limitNum);
                            editor.text(strValue);
                        } else {
                            //计算剩余字数
                            var result = limitNum - this.count('text');
                            pattern = '还可以输入' +  result + '字';
                        }
                        $('.word_surplus').html(pattern); //输入显示
                        ////////
                    },
                    allowImageUpload : true, 
                	resizeType : 1,
            	    allowPreviewEmoticons : false,
            	    allowUpload : true,
            	    items : [
            	    'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
            	    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            	    'insertunorderedlist', '|','image', 'emoticons',  'link' , 'unlink']
            	}
                );
        });