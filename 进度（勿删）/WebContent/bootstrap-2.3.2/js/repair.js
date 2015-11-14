//
//	$(document).ready(function(){
//		
//			$.get("../Showunrepair", {  }, function(m){
//				$("#repairtab1 table tr:gt(0)").remove();
//				var html = "";
//				for (var i=0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					html += "<tr><td>" + r.fixorder + "</td>";
//					html += "<td>" + r.name + "</td>";
//					html += "<td>" + r.dormapt + "</td>";
//					html += "<td>" + r.dormnum + "</td>";
//					html += "<td>" + r.phone + "</td>";
//					html += "<td>" + r.problem + "</td></tr>";
//					
//				}
//				$("#repairtab1 table").append(html);
//			});
//			
//		});
//
//
//	$(document).ready(function(){
//		
//
//			$.get("../Showokrepair", {  }, function(m){
//				$("#repairtab2 table tr:gt(0)").remove();
//				var html = "";
//				for (var i=0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//                  html += "<tr><td>" + r.fixorder + "</td>";
//					html += "<td>" + r.name + "</td>";
//					html += "<td>" + r.dormapt + "</td>";
//					html += "<td>" + r.dormnum + "</td>";
//					html += "<td>" + r.phone + "</td>";
//					html += "<td>" + r.problem + "</td></tr>"; 
//					
//				}
//				$("#repairtab2 table").append(html);
//			});
//			
//		});
//	
$(document).ready(function(){
	
		getData();
});
function getData() {	
	//alert("asd1");
	var page2=$('#ul1' + ' .p').val()-1;
	$.get("../Showunrepair", {page2:page2},function(w){
		
		$("#repairtab1 table tr:gt(0)").remove();
		var html = "";
		$('#ul1' + ' .total').html(w.total);
		
		for (var i=0; i < w.rows.length; i++) {
			var r = w.rows[i];		

			html += "<tr align='center'><td>" + r.fixorder + "</td>";
			html += "<td>" + r.name + "</td>";
			html += "<td>" + r.dormapt + "</td>";
			html += "<td>" + r.dormnum + "</td>";
			html += "<td>" + r.phone + "</td>";
			html += "<td>" + r.problem + "</td></tr>";
		
		}
		$("#repairtab1 table").append(html);
		$('#ul1' + ' .pageCount').html(w.total%5==0?w.total/5:parseInt(w.total/5+1));
		
	});
}

function previous(){
if($('#ul1' + ' .p').val()>=2){
	$('#ul1' + ' .p').val(parseInt($('#ul1' + ' .p').val())-1);
	getData();
}else{
}		
}
function next(){
if(parseInt($('#ul1' + ' .p').val())<parseInt($('#ul1' + ' .pageCount').html())){		
	$('#ul1' + ' .p').val(parseInt($('#ul1' + ' .p').val())+1);
	getData();
}		
}


//next("#ul1")
//next("#ul2")

function first(){
$('#ul1' + ' .p').val(1);
getData();
}
function last(){
$('#ul1' + ' .p').val($('#ul1' + ' .pageCount').html());
getData();
}




$(document).ready(function(){		
		getData3();
});	

function getData3() {	

var page3=$('#ul2' + ' .p').val()-1;
$.get("../Showokrepair", {page3:page3},function(k){
	$("#repairtab2 table tr:gt(0)").remove();
	var html = "";
	$('#ul2' +' .total').html(k.total);
	for (var i=0; i < k.rows.length; i++) {
		var r = k.rows[i];	
		
        html += "<tr align='center'><td>" + r.fixorder + "</td>";
		html += "<td>" + r.name + "</td>";
		html += "<td>" + r.dormapt + "</td>";
		html += "<td>" + r.dormnum + "</td>";
		html += "<td>" + r.phone + "</td>";
		html += "<td>" + r.problem + "</td></tr>"; 
	
	}
	$("#repairtab2 table").append(html);
	$('#ul2' + ' .pageCount').html(k.total%5==0?k.total/5:parseInt(k.total/5+1));
	
});
}
function previous3(){
	if($('#ul2' + ' .p').val()>=2){
		$('#ul2' + ' .p').val(parseInt($('#ul2' + ' .p').val())-1);
		getData3();
	}else{
	}		
	}
	function next3(){
	if(parseInt($('#ul2' + ' .p').val())<parseInt($('#ul2' + ' .pageCount').html())){		
		$('#ul2' + ' .p').val(parseInt($('#ul2' + ' .p').val())+1);
		getData3();
	}		
	}
	function first3(){
	$('#ul2' + ' .p').val(1);
	getData3();
	}
	function last3(){
	$('#ul2' + ' .p').val($('#ul2' + ' .pageCount').html());
	getData3();
	}