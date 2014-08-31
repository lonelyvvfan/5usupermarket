$(function () {
        var ie6 = document.all;
        var dv = $('#container_top'), st;
        dv.attr('container_top', dv.offset().top); //存储原来的距离顶部的距离
        $(window).scroll(function () {
            st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
            if (st > parseInt(dv.attr('container_top'))) {
                if (ie6) {//IE6不支持fixed属性，所以只能靠设置position为absolute和top实现此效果
                    dv.css({ position: 'fixed',top:0});
                }
                else if (dv.css('position') != 'fixed') dv.css({ 'position': 'fixed', top: 0 });
            } else if (dv.css('position') != 'static') dv.css({ 'position': 'static' });
        });
    });
    $(function () {
        var dv = $('#right_sort'), st;
        dv.attr('right_sort', dv.offset().top); //存储原来的距离顶部的距离
        $(window).scroll(function () {
            st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
            if (st > parseInt(dv.attr('right_sort'))) {
                if (dv.css('top') != '50px') dv.css({ 'position': 'fixed', top: 50 });
            } else if (dv.css('top') != '245px') dv.css({ 'position': 'fixed',top:245 });
        });
    });
    
    $(function () {
        var dv = $('#top_img'), st;
        var m=$('#index_gotop');
        dv.attr('top_img', dv.offset().top+245); //存储原来的距离顶部的距离
        $(window).scroll(function () {
            st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
            if (st > parseInt(dv.attr('top_img'))) {
                if (dv.css('display') != 'block') {dv.css({ 'display': 'block'});m.css({'bottom':'66px'});}
            } else if (dv.css('diplay') != 'none'){ dv.css({ 'display': 'none' });m.css({'bottom':'20px'});}
        });
    });