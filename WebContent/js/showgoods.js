function show(now){
	var big=document.getElementById("sec_big");
	big.src=now.src;
}

function good_show(now){
	var big=document.getElementById("big");
	big.src=now.src;
}

function show_big(now){
	var big=document.getElementById("bigsee");
	big.src=now.src;
	big.style.display="inline";
}

function show_secbig(now){
	var big=document.getElementById("sec_bigsee");
	big.src=now.src;
	big.style.display="inline";
}

function disshow_big(){
	var big=document.getElementById("bigsee");
	big.style.display="none";
}

function disshow_secbig(){
	var big=document.getElementById("sec_bigsee");
	big.style.display="none";
}