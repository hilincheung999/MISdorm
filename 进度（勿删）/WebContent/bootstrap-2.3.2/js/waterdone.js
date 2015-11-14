$(document).ready(function(){	
		getData();
});	

function getData() {	
	var page=$('#page').val()-1;
	$.get("../showwater", {page:page},function(m){
		$("table tr:gt(0)").remove();
		var html = "";
		$("#total").html(m.total);
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];			
			html += "<tr><td>" + r.waterorder + "</td>";
			html += "<td>" + r.stunum + "</td>";
			html += "<td>" + r.name + "</td>";
			html += "<td>" + r.dormnum + "</td>";
			html += "<td>" + r.phone + "</td>";
			html += "<td>" + r.time + "</td><td>已完成</td></tr>";
		
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