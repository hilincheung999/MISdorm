$(document).ready(function(){	
		getData4();
});	

function getData4() {	
	var page4=$('#ul3' + ' .p').val()-1;
	$.get("../myleave", {page4:page4},function(q){
		$("#leave table tr:gt(0)").remove();
		var html = "";
		$('#ul3' + ' .total').html(q.total);
		for (var i=0; i < q.rows.length; i++) {
			var r = q.rows[i];			
			html += "<tr><td>" + r.destination + "</td><td>"
			+r.leavetime+"</td><td>"+ r.backtime+"</td><td>"+ r.phone +"</td></tr>";
		
		}
		$("#leave table").append(html);
		$('#ul3' + ' .pageCount').html(q.total%5==0?q.total/5:parseInt(q.total/5+1));
		
	});
}
function previous4(){
	if($('#ul3' + ' .p').val()>=2){
		$('#ul3' + ' .p').val(parseInt($('#ul3' + ' .p').val())-1);
		getData4();
	}else{
	}		
}
function next4(){
	if(parseInt($('#ul3' + ' .p').val())<parseInt($('#ul3' + ' .pageCount').html())){		
		$('#ul3' + ' .p').val(parseInt($('#ul3' + ' .p').val())+1);
		getData4();
	}		
}
function first4(){
	$('#ul3' + ' .p').val(1);
	getData4();
}
function last4(){
	$('#ul3' + ' .p').val($('#ul3' + ' .pageCount').html());
	getData4();
}