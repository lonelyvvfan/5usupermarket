 function fileChange(target,up_file,imgPreviewId, divPreviewId){
//检测上传文件的类型 
            var imgName = up_file.value;
            var ext,idx;
            if (imgName == ''){
                return;
            } else {
                idx = imgName.lastIndexOf(".");
                if (idx != -1){
                    ext = imgName.substr(idx+1).toUpperCase();
                    ext = ext.toLowerCase( );
                    // alert("ext="+ext);
                    if (ext != 'jpg' && ext != 'jpeg' && ext != 'gif'){
                        alert("只能上传.jpg  .jpeg  .gif类型的文件!");
                        up_file.outerHTML=up_file.outerHTML;
                        return;
                    }
                } else {
                    alert("只能上传.jpg  .jpeg  .gif类型的文件!");
                    up_file.outerHTML=up_file.outerHTML;
                    return;
                }
            }

            //检测上传文件的大小
            var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
            var fileSize = 0;
            if (isIE && !target.files){
                var filePath = target.value;
                var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
                var file = fileSystem.GetFile (filePath);
                fileSize = file.Size;
            } else {
                fileSize = target.files[0].size;
            }

            var size = fileSize / 1024*1024;

            if(size>(1024*1024*2)){
                up_file.outerHTML=up_file.outerHTML;
                alert("文件大小不能超过2M");
            }
           
     
     var allowExtention = ".jpg,.bmp,.gif"; //,允许上传文件的后缀名
     var extention = target.value.substring(target.value.lastIndexOf(".") + 1).toLowerCase();
     var browserVersion = window.navigator.userAgent.toUpperCase();
     if (allowExtention.indexOf(extention) > -1) {
         if (browserVersion.indexOf("MSIE") > -1) {
             if (browserVersion.indexOf("MSIE 6.0") > -1) {//ie6
                 document.getElementById(imgPreviewId).setAttribute("src", target.value);
             } else {//ie[7-8]、ie9
                 target.select();
                 var newPreview = document.getElementById(divPreviewId + "New");
                 if (newPreview == null) {
                     newPreview = document.createElement("div");
                     newPreview.setAttribute("id", divPreviewId + "New");
                     newPreview.style.width = 160;
                     newPreview.style.height = 170;
                     newPreview.style.border = "solid 1px #d2e2e2";
                 }
                 newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
                 var tempDivPreview = document.getElementById(divPreviewId);
                 tempDivPreview.parentNode.insertBefore(newPreview, tempDivPreview);
                 tempDivPreview.style.display = "none";
             }
         } else if (browserVersion.indexOf("FIREFOX") > -1) {//firefox
             var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
             if (firefoxVersion < 7) {//firefox7以下版本
                 document.getElementById(imgPreviewId).setAttribute("src", target.files[0].getAsDataURL());
             } else {//firefox7.0+                    
                 document.getElementById(imgPreviewId).setAttribute("src", window.URL.createObjectURL(target.files[0]));
             }
         } else if (target.files) {
             //兼容chrome、火狐等，HTML5获取路径                   
             if (typeof FileReader !== "undefined") {
                 var reader = new FileReader();
                 reader.onload = function (e) {
                     document.getElementById(imgPreviewId).setAttribute("src", e.target.result);
                 }
                 reader.readAsDataURL(target.files[0]);
             } else if (browserVersion.indexOf("SAFARI") > -1) {
                 alert("暂时不支持Safari浏览器!");
             }
         } else {
             document.getElementById(divPreviewId).setAttribute("src", target.value);
         }
     } else {
         alert("仅支持" + allowSuffix + "为后缀名的文件!");
         target.value = ""; //清空选中文件
         if (browserVersion.indexOf("MSIE") > -1) {
             target.select();
             document.selection.clear();
         }
         target.outerHTML = target.outerHTML;
     }
 }