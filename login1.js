
$(document).ready(function(){
	
	
			$.get("../B", { }, function(m){
				//�ص�����    ��������˷��Ͳ���
				//$("table tr:gt(0)").remove();//���˵�һ�е����ݺ������ж�ɾ��
				
			
				var tbl = "";
				
				for (var i = 0; i < m.rows.length; i++) {
					var r = m.rows[i];
					tbl += "<a href='personal.html'> " + r.cstunum + "</a>";
				}
				
				$("#a").append(tbl);
		
			
			
			
		});
		
	});
