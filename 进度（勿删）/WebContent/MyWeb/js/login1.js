
$(document).ready(function(){
	
	
			$.get("../B", { }, function(m){
				
			
				var tbl = "";
				
				for (var i = 0; i < m.rows.length; i++) {
					var r = m.rows[i];
					tbl += "<a href='personal.html'> " + r.cstunum + "</a>";
				}
				
				$("#a").append(tbl);
		
			
			
			
		});
		
	});
