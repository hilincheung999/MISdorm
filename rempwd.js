	$(document).ready(function(){
		
		$("#stunum").val($.cookie("stunum"));
		$("#password").val($.cookie("password"));
		
		$("#form1").submit(function(){
			if ($("input#remember:checked").length > 0) {
				$.cookie("stunum", $("#stunum").val());
				$.cookie("password", $("#password").val());
			}
		});
		
	});
	