function setOption(){
	var xmlHttp = false;
    //获取服务器时间
    try {
        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e2) {
            xmlHttp = false;
        }
    }

    if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
        xmlHttp = new XMLHttpRequest();
    }

    xmlHttp.open("GET", "null.txt", false);
    xmlHttp.setRequestHeader("Range", "bytes=-1");
    xmlHttp.send(null);

    myDate = new Date(xmlHttp.getResponseHeader("Date"));

    //获取服务器日期
    var myyear = myDate.getFullYear();
    var mymonth = myDate.getMonth() + 1;
    var myday = myDate.getDate();
    //获取服务器时间
    var myhour = myDate.getHours();
    var myminute = myDate.getMinutes();
	var mySelect = document.getElementById("arrivedtime");
	var select=document.getElementById("order_day1").value;
	var sel_year=select.substring(0,4);
	var sel_month=select.substring(6,7);
	var sel_day=select.substring(8,11);
	var option_term=["09:30-10:00","10:30—11:00","11:30 —12:00","12:30—13:00","13:30—14:00","14:30—15:00","15:30—16:00","16:30—17:00",
	                 "17:30—18:00","18:30—19:00","19:30—20:00","20:30—21:00","21:30—22:00"];
	sel_year=parseInt(sel_year);
	sel_month=parseInt(sel_month);
	sel_day=parseInt(sel_day);
	var str=myyear+'/'+mymonth+'/'+myday+' ';
	var j=0;
	var len=0;
	document.getElementById("arrivedtime").options.length=0;
	
	if(sel_year<myyear)
		{
		alert('对不起，只能选择今天或明天哦~');
		}
	else if(sel_year==myyear)
		{
		if(sel_month<mymonth)
			{
			alert('对不起，只能选择今天或明天哦~');
			}
		else if(sel_month==mymonth)
			{
			if(sel_day<myday)
				{
				alert('对不起，只能选择今天或明天哦~');
				}
			else if(sel_day==myday)
				{
				if(myhour<9)
					{
					for(var i=0;i<13;i++)
					{
					var opp = new Option(option_term[i],i);
					mySelect.add(opp);
					}
					}
				else if(myhour==9)
					{
					if(myminute<20)
						{
						for(var i=0;i<13;i++)
						{
						var opp = new Option(option_term[i],i);
						mySelect.add(opp);
						}
						}
					else{
						for(var i=1;i<13;i++)
						{
						var opp = new Option(option_term[i],i);
						mySelect.add(opp);
						}
					}
					}
				else if(myhour>9&&myhour<21)
					{
					j=0;
					do{
						str=myyear+'/'+mymonth+'/'+myday+' ';
					str=str+option_term[j].substring(0,5);
					var testdate=new Date(str);
					len=((testdate-myDate)/1000)/60;
					j++;
					}while(len<10);
				    for(j=j-1;j<13;j++)
				    	{
				    	var opp = new Option(option_term[j],j);
						mySelect.add(opp);
				    	}
					}
				else if(myhour==21)
					{
					if(myminute<20)
						{
						var opp = new Option(option_term[12],12);
						mySelect.add(opp);
						}
					else{
						alert('对不起，今天已无法送货');
					}
					}
				else{
					alert('对不起，今天已无法送货');
				}
				}
			else if(sel_day==(myday+1)){
				for(var i=0;i<13;i++)
					{
					var opp = new Option(option_term[i],i);
					mySelect.add(opp);
					}
			}
			else{
				alert('对不起，只能选择今天或明天哦~');
			}
			}
		else{
			if(myday==30)
				{
				if(mymonth==4||mymonth==6||mymonth==9||mymonth==11)
			{for(var i=0;i<13;i++)
			{
			var opp = new Option(option_term[i],i);
			mySelect.add(opp);
			}}
				else{
					alert('对不起，只能选择今天或明天哦~');
				}
				}
			else if(myday==31)
				{
				if(mymonth==1||mymonth==3||mymonth==5||mymonth==7||mymonth==8||mymonth==10||mymonth==12)
					{
					for(var i=0;i<13;i++)
					{
					var opp = new Option(option_term[i],i);
					mySelect.add(opp);
					}
					}
				else{
					alert('对不起，只能选择今天或明天哦~');
				}
				}
			else if(myday==28)
				{
				if((myyear%4==0&&myyear%100!=0)||myyear%400==0)
					alert('对不起，只能选择今天或明天哦~');
				else{
					if(mymonth==2)
						{
						for(var i=0;i<13;i++)
						{
						var opp = new Option(option_term[i],i);
						mySelect.add(opp);
						}
						}
					else{
						alert('对不起，只能选择今天或明天哦~');
					}
				}
				}
			else if(myday==29)
				{
				if(month==2)
					{
					for(var i=0;i<13;i++)
					{
					var opp = new Option(option_term[i],i);
					mySelect.add(opp);
					}
					}
				else{
					alert('对不起，只能选择今天或明天哦~');
				}
				}
			else{
				alert('对不起，只能选择今天或明天哦~');
			}
		}
		}
	else{
		if(mymonth==12)
			{
			if(myday==31)
				{
				for(var i=0;i<13;i++)
				{
				var opp = new Option(option_term[i],i);
				mySelect.add(opp);
				}
				}
			else{
				alert('对不起，只能选择今天或明天哦~');
			}
			}
		else{
		  alert('对不起，只能选择今天或明天哦~');
		}
	}
}