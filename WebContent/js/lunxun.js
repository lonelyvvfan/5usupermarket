$(document).ready(function(){
    setInterval(function(){
        $.ajax({
            url: 'lunxun',
            type: 'get',
            dataType: 'json',
            error: function(){
            },
            success: function(responseResult){
                if (responseResult.list[0]===true){
                	var audio = document.createElement('audio');
                	var source = document.createElement('source');
                	source.type = "audio/mpeg";
                	//source.src = "audio/neworder.mp3"; 
                	source.autoplay = "autoplay";
                	source.controls = "controls";
                	audio.appendChild(source);
                	audio.play();
                	//setTimeout(function(){
                		//audio.pause();
                	//},9000);
                }
            }
        });
    },10000);
});
