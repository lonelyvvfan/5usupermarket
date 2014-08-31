		$(document).ready(function(){
			$.ajax({
		        url: 'test!findkeyword',
		        type: 'get',
		        dataType: 'json',
		        error: function(){
		        },
		        success: function(responseResult){
		        	$('#term').empty();
		        	$('#term').append('<img src='+'"image/find.png"'+'/>');
		        	$(responseResult.listk).each(function(){
		            	$('#term').append('<a href=search?goodsname='+this.title+'>'+this.title+'</a>');
			        });
		          
		        }
		    });	
			});		
		
		