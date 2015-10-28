//$(document).ready(function(){		
//		$("#btnQuery").click(function(){
//			$.get("../user_search", { keyword: $("#keyword").val() }, function(m){
//				$("table tr:gt(0)").remove();
//				var html = "";
//				for (var i=0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					html +="<tr><td>" + r.stunum + "</td>";
//					html +="<td>" + r.stuname + "</td>";
//					html +="<td>" + r.dormapt + "</td>";
//					html +="<td>" + r.dormnum + "</td>";
//					html +="<td>" + r.grade + "</td>";
//					html +="<td>" + r.major + "</td>";
//					html +="<td>" + r.phone + "</td>";
//					html +="<td>" + r.email + "</td></tr>";
//				}
//				$("table").append(html);
//			});
//			
//		});
//		
//	});
//	$(document).ready(function(){		
//		$("#btn").click(function(){
//			$.get("../user_search1", { dormapt: $("#dormapt").val() }, function(m){
//				$("table tr:gt(0)").remove();
//				var html = "";
//				for (var i=0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					html +="<tr><td>" + r.stunum + "</td>";
//					html +="<td>" + r.stuname + "</td>";
//					html +="<td>" + r.dormapt + "</td>";
//					html +="<td>" + r.dormnum + "</td>";
//					html +="<td>" + r.grade + "</td>";
//					html +="<td>" + r.major + "</td>";
//					html +="<td>" + r.phone + "</td>";
//					html +="<td>" + r.email + "</td></tr>";
//				}
//				$("table").append(html);
//			});
//			
//		});
//		
//	});
$(document).ready(function(){
	$("#btnQuery").click(function(){
		getData();
	});
});	

function getData() {
	
	var page=$('#page').val()-1;
	$.get("../user_search", {keyword:$("#keyword").val(),page:page},function(m){
		$("table tr:gt(0)").remove();
		var html = "";
		$("#total").html(m.total);
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];			
			html += "<tr align='center'><td>" + r.stunum + "</td>";
			html += "<td>" + r.stuname + "</td>";
			html += "<td>" + r.dormapt + "</td>";
			html += "<td>" + r.dormnum + "</td>";
			html += "<td>" + r.email + "</td>";
			html += "<td>" + r.phone + "</td></tr>";
		}
		$("table").append(html);
		$('#pageCount').html(m.total%5==0?m.total/5:parseInt(m.total/5+1));
		
	});
}
function previous(){
	if($('#page').val()>=2){
		$('#page').val(parseInt($('#page').val())-1);
		getData();
	}else{
	}		
}
function next(){
	if(parseInt($('#page').val())<parseInt($('#pageCount').html())){		
		$('#page').val(parseInt($('#page').val())+1);
		getData();
	}		
}
function first(){
	$('#page').val(1);
	getData();
}
function last(){
	$('#page').val($('#pageCount').html());
	getData();
}



$(document).ready(function(){
	$("#btn").click(function(){
		getData1();
	});
});

function getData1() {
	
	var page=$('#page').val()-1;
	$.get("../user_search1", {dormapt:$("#dormapt").val(),page:page},function(m){
		$("table tr:gt(0)").remove();
		var html = "";
		$("#total").html(m.total);
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];			
			html += "<tr align='center'><td>" + r.stunum + "</td>";
			html += "<td>" + r.stuname + "</td>";
			html += "<td>" + r.dormapt + "</td>";
			html += "<td>" + r.dormnum + "</td>";
			html += "<td>" + r.email + "</td>";
			html += "<td>" + r.phone + "</td></tr>";
		}
		$("table").append(html);
		$('#pageCount').html(m.total%5==0?m.total/5:parseInt(m.total/5+1));
		
	});
}
function previous(){
	if($('#page').val()>=2){
		$('#page').val(parseInt($('#page').val())-1);
		getData1();
	}else{
	}		
}
function next(){
	if(parseInt($('#page').val())<parseInt($('#pageCount').html())){		
		$('#page').val(parseInt($('#page').val())+1);
		getData1();
	}		
}
function first(){
	$('#page').val(1);
	getData1();
}
function last(){
	$('#page').val($('#pageCount').html());
	getData1();
}