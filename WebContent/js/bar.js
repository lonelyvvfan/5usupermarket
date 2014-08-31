function active()
{
	var bar=document.getElementById("c_top_term");
	var addsec=document.getElementById("two");
	var o_link=bar.getElementsByTagName("a");
	var index1=document.getElementById("index1");
	var index2=document.getElementById("index2");
	var index3=document.getElementById("index3");
	var index4=document.getElementById("index4");
	var index5=document.getElementById("index5");
	for(var i=0;i<o_link.length;i++)
		{
		o_link[i].className="";
		}
	if(index1)
		{
		o_link[0].className="set_red";
		}
	else if(index2)
		{
		o_link[1].className="set_palevioletred";
		}
	else if(index3)
	    {
		o_link[2].className="set_plum";
	    }
	else if(index4)
		{
		o_link[3].className="set_greenyellow";
		}
	else if(index5)
		{
		addsec.className='set_pink';
		}
	};
	
	function right_active(now)
	{
		var bar=document.getElementById("right_sort");
		var o_li=bar.getElementsByTagName("li");
		for(var i=0;i<o_li.length;i++)
		{
		o_li[i].className="";
		}
		now.className="set_margin";
	}
	function right_active1(id)
	{
		var now=document.getElementById(id);
		var bar=document.getElementById("right_sort");
		var o_li=bar.getElementsByTagName("li");
		for(var i=0;i<o_li.length;i++)
		{
		o_li[i].className="";
		}
		now.className="set_margin";
	}
	function right_over(now){
		now.style.marginLeft="-10px";
	}
	function right_out(now){
		now.style.marginLeft="";
	}
	function admin_active(){
		var bar=document.getElementById("menu");
		var o_link=bar.getElementsByTagName("a");
		var index1=document.getElementById("index1");
		var index2=document.getElementById("index2");
		var index3=document.getElementById("index3");
		var index4=document.getElementById("index4");
		var index5=document.getElementById("index5");
		var index6=document.getElementById("index6");
		var index7=document.getElementById("index7");
		var index8=document.getElementById("index8");
		var index9=document.getElementById("index9");
		var index10=document.getElementById("index10");
		var index11=document.getElementById("index11");
		var index12=document.getElementById("index12");
		for(var i=0;i<o_link.length;i++)
			{
			o_link[i].className="";
			}
		if(index1)
			{
			o_link[0].className="now";
			}
		else if(index2)
			{
			o_link[1].className="now";
			}
		else if(index3)
		    {
			o_link[2].className="now";
		    }
		else if(index4)
			{
			o_link[3].className="now";
			}
		else if(index5)
		{
		o_link[4].className="now";
		}
		else if(index6)
		{
		o_link[5].className="now";
		}
		else if(index7)
		{
		o_link[6].className="now";
		}
		else if(index8)
		{
		o_link[7].className="now";
		}
		else if(index9)
		{
		o_link[8].className="now";
		}
		else if(index10)
		{
		o_link[9].className="now";
		}
		else if(index11)
		{
		o_link[10].className="now";
		}
		else if(index12)
		{
		o_link[11].className="now";
		}
	}
	
	function now(pretent){
		var first_line=document.getElementById("first_line");
		var o_td=first_line.getElementsByTagName("td");
		for(var i=0;i<o_td.length;i++)
			{
			o_td[i].style.color="black";
			o_td[i].bgColor="white";
			}
		pretent.bgColor="#e99518";
		pretent.style.color="#FFF";
	}
	function rtwo(){
		var two=document.getElementById("two");
		two.style.background='';
		two.style.borderColor='';
		
	};
	function ctwo(){
		var two=document.getElementById("two");
		two.style.background='pink';
		two.style.borderColor='pink';
		
	};
	function rtwo(){
		var two=document.getElementById("two");
		two.style.background='';
		two.style.borderColor='';
		
	};
	
	function two_active(id,now)
	{
		var o_id=document.getElementById(id);
		var o_b=o_id.getElementsByTagName('b');
		for(var i=0;i<o_b.length;i++)
			{
			o_b[i].className=' ';
			}
		now.className="two_active";
	}
	