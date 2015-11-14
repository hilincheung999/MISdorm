//$(document).ready(function(){
//	
//	
//			$.get("../queryokrepair", { }, function(m){
//				
//				$("table tr:gt(0)").remove();
//				var tbl = "";
//				
//				for (var i = 0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					tbl += "<tr align='center' id='tr" + r.fixorder + "'><td>" + r.fixorder + "</td><td>" +r.stunum + "</td><td>"+ r.name +"</td><td>" +r.dormnum+"</td><td>" +r.phone+"</td><td>" +
//					r.time+"</td><td>"+ r.problem +"</td><td>已完成</a></td></tr>";
//				}
//				
//				
//				$("table").append(tbl);
//			
//		});
//		
//	});
$(document).ready(function(){	
		getData();
});	

function getData() {	
	var page=$('#page').val()-1;
	$.get("../queryokrepair", {page:page},function(m){
		$("table tr:gt(0)").remove();
		var html = "";
		$("#total").html(m.total);
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];			
			html += "<tr align='center' id='tr" + r.fixorder + "'><td>" + r.fixorder + "</td><td>" +r.stunum + "</td><td>"+ r.name +"</td><td>" +r.dormapt+"</td><td>"+r.dormnum+"</td><td>" +r.phone+"</td><td>" +
		    r.time+"</td><td>"+ r.problem +"</td><td>已完成</a></td></tr>";		
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