//
//$(document).ready(function(){
//	
//	
//			$.get("../mysg", { }, function(m){
//				//回调函数    向服务器端发送参数
//				$("table tr:gt(0)").remove();//除了第一行的数据后，其他行都删除
//				
//				var tbl = "";
//				
//				for (var i = 0; i < m.rows.length; i++) {
//					var r = m.rows[i];
//					tbl += "<tr><td>" + r.title + "</td><td><div style='width:100%;height:100;overflow-x:scroll;overflow-y:scroll'>"
//					+r.content+"</div></td><td>"+ r.date +"</td><td>"+ r.name +"</td></tr>";
//				}
//				
//				$("table").append(tbl);
//		
//			
//			
//			
//		});
//		
//	});
$(document).ready(function(){	
		getData5();
});	

function getData5() {	
	var page5=$('#ul4' + ' .p').val()-1;
	$.get("../mysg", {page5:page5},function(m){
		$("#note table tr:gt(0)").remove();
		var html = "";
		$('#ul4' +' .total').html(m.total);
		for (var i=0; i < m.rows.length; i++) {
			var r = m.rows[i];			
			html += "<tr align='center'><td>" + r.title + "</td><td><div style='width:100%;height:100;overflow:auto'>"
		+r.content+"</div></td><td>"+ r.date +"</td><td>"+ r.name +"</td></tr>"
		
		}
		$("#note table").append(html);
		$('#ul4' +' .pageCount').html(m.total%5==0?m.total/5:parseInt(m.total/5+1));
		
	});
}
function previous5(){
	if($('#ul4' + ' .p').val()>=2){
		$('#ul4' + ' .p').val(parseInt($('#ul4' + ' .p').val())-1);
		getData5();
	}else{
	}		
}
function next5(){
	if(parseInt($('#ul4' + ' .p').val())<parseInt($('#ul4' +' .pageCount').html())){		
		$('#ul4' + ' .p').val(parseInt($('#ul4' + ' .p').val())+1);
		getData5();
	}		
}
function first5(){
	$('#ul4' + ' .p').val(1);
	getData5();
}
function last5(){
	$('#ul4' + ' .p').val($('#ul4' +' .pageCount').html());
	getData5();
}