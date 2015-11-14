/**
 * 
 */
	$(document).ready(function(e) {
        $("#main-nav li a").click(function(){
			var iframe = $("iframe");
			var src = "";
				switch($(this).attr("id"))
				{
					case "home":
					src = "DormManager.html";
					break;
					case "announcementview":
					src = "notice_check.html";
					break;
					case "announcementpublish":
					src = "notice_publish.html";
					break;
					case "water_order_undone":
					src = "water_order_undone.html";
					break;
					case "water_done":
					src = "water_order_done.html";
					break;
					case "water_search":
					src = "water_search.html";
					break;
					case "fix_order_undone":
					src = "bgqueryunrepair.html";
					break;
					case "fix_order_done":
					src = "bgqueryokrepair.html";
					break;
					case "fix_search":
					src = "fix_search.html";
					break;
					case "leaving_search":
					src = "leaving_search.html";
					break;
					case "user_search":
					src = "user_search.html";
					break;
					case "note":
					src = "note.html";
					break;
					case "call":
					src = "call.html";
					break;
					case "chaxun":
					src = "welcome.html";
					break;
					case "yinyongshui":
					src = "welcome.html";
					break;
					case "weixiu":
					src = "welcome.html";
					break;
					case "wuye":
					src = "welcome.html";
					break;
					default:
					break;
					}
					iframe.attr("src", src);
			});
    });