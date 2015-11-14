//
//	$(document).ready(function(){		
//		
//			$.get("../Waterunpaid", {  }, function(m){
//				$("#watertab1 table tr:gt(0)").remove();
//				var html = "";
//				for (var i=0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					html += "<tr><td>" + r.waterorder + "</td>";
//					html += "<td>" + r.name + "</td>";
//					html += "<td>" + r.dormapt + "</td>";
//					html += "<td>" + r.dormnum + "</td>";
//					html += "<td>" + r.phone + "</td>";
//					html += "<td>" + r.time + "</td></tr>";
//					
//				}
//				$("#watertab1 table").append(html);
//			});
//			
//		});
//	
//	$(document).ready(function(){
//		
//	
//			$.get("../Waterpaid", {  }, function(m){
//				$("#watertab2 table tr:gt(0)").remove();
//				var html = "";
//				for (var i=0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					html += "<tr><td>" + r.waterorder + "</td>";
//					html += "<td>" + r.name + "</td>";
//					html += "<td>" + r.dormapt + "</td>";
//					html += "<td>" + r.dormnum + "</td>";
//					html += "<td>" + r.phone + "</td>";
//					html += "<td>" + r.time + "</td></tr>";
//					
//				}
//				$("#watertab2 table").append(html);
//			});
//			
//		});
//	

$(document).ready(function(){	
		getData6();
});
function getData6() {	
	
	var page6=$('#ul5' + ' .p').val()-1;
	$.get("../Waterunpaid", {page6:page6},function(m){
		
		$("#watertab1 table tr:gt(0)").remove();
		var html = "";
		$('#ul5' + ' .total').html(m.total);
		
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];		

			html += "<tr><td>" + r.waterorder + "</td>";
			html += "<td>" + r.name + "</td>";
			html += "<td>" + r.dormapt + "</td>";
			html += "<td>" + r.dormnum + "</td>";
			html += "<td>" + r.phone + "</td>";
     		html += "<td>" + r.time + "</td></tr>";
		
		}
		$("#watertab1 table").append(html);
		$('#ul5' + ' .pageCount').html(m.total%5==0?m.total/5:parseInt(m.total/5+1));
		
	});
}
function previous6(){
	if($('#ul5' + ' .p').val()>=2){
		$('#ul5' + ' .p').val(parseInt($('#ul5' + ' .p').val())-1);
		getData6();
	}else{
	}		
	}
	function next6(){
	if(parseInt($('#ul5' + ' .p').val())<parseInt($('#ul5' + ' .pageCount').html())){		
		$('#ul5' + ' .p').val(parseInt($('#ul5' + ' .p').val())+1);
		getData6();
	}		
	}
	function first6(){
	$('#ul5' + ' .p').val(1);
	getData6();
	}
	function last6(){
	$('#ul5' + ' .p').val($('#ul5' + ' .pageCount').html());
	getData6();
	}
//function previous(){
//	if($(ul + ' .p').val()>=2){
//		$(ul + ' .p').val(parseInt($(ul + ' .p').val())-1);
//		getData();
//	}else{
//	}		
//}
////function next(){
////	if(parseInt($('#page').val())<parseInt($('#pageCount').html())){		
////		$('#page').val(parseInt($('#page').val())+1);
////		getData();
////	}		
////}
//
//function next(ul){
//	if(parseInt($(ul + ' .p').val())<parseInt($(ul + ' .pageCount').html())){		
//		$(ul + ' .p').val(parseInt($(ul + ' .p').val())+1);
//		getData();
//	}		
//}
//
//
////next("#ul1")
////next("#ul2")
//
//function first(){
//	$(ul + ' .p').val(1);
//	getData();
//}
//function last(){
//	$(ul + ' .p').val($(ul + ' .pageCount').html());
//	getData();
//}




$(document).ready(function(){	
		getData1();
});	

function getData1() {	

var page1=$('#page1').val()-1;
$.get("../Waterpaid", {page1:page1},function(n){
	$("#watertab2 table tr:gt(0)").remove();
	var html = "";
	$("#total1").html(n.total1);
	for (var i=0; i < n.rows.length; i++) {
		var r = n.rows[i];			
		html += "<tr align='center'><td>" + r.waterorder + "</td>";
		html += "<td>" + r.name + "</td>";
		html += "<td>" + r.dormapt + "</td>";
		html += "<td>" + r.dormnum + "</td>";
		html += "<td>" + r.phone + "</td>";
		html += "<td>" + r.time + "</td></tr>";
	
	}
	$("#watertab2 table").append(html);
	$('#pageCount1').html(n.total1%5==0?n.total1/5:parseInt(n.total1/5+1));
	
});
}
function previous1(){
if($('#page1').val()>=2){
	$('#page1').val(parseInt($('#page1').val())-1);
	getData1();
}else{
}		
}
function next1(){
if(parseInt($('#page1').val())<parseInt($('#pageCount1').html())){		
	$('#page1').val(parseInt($('#page1').val())+1);
	getData1();
}		
}
function first1(){
$('#page1').val(1);
getData1();
}
function last1(){
$('#page1').val($('#pageCount1').html());
getData1();
}