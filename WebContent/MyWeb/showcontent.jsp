<%@ page import="java.sql.*,javax.sql.*,eb.javaweb.DbUtil" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宿舍管家|公告栏</title>
<link href="../bootstrap-2.3.2/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="../bootstrap-2.3.2/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="../bootstrap-2.3.2/css/style.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-default  navbar-fixed-top">
<div class="container-fluid">   
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#defaultNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
      <a class="navbar-brand" href="DormManager.html">主页</a></div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="defaultNavbar1">
      <ul class="nav navbar-nav">            
        <li ><a href="water.html">预约送水<span class="sr-only">(current)</span></a></li>
        <li><a href="note.html">留言板</a></li>       
        <li><a href="repair.html">预约维修</a></li>
        <li><a href="leaveschool.html">去向表填写</a></li>
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">常用链接<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="http://www.cumt.edu.cn">矿大主页</a></li>          
            <li class="divider"></li>
            <li><a href="http://sm.cumt.edu.cn">学院主页</a></li>
            <li class="divider"></li>
            <li><a href="http://jwb.cumt.edu.cn">教务处</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">&nbsp;搜索</button>
      </form>
      <ul class="nav navbar-nav navbar-right">        
        <li class=""><a href="login.html">退出登录</a></li>
      </ul>
    </div>
    <!-- /.navbar-collapse --> 
 </div>
  <!-- /.container-fluid --> 

 </nav>
 <br></br> 
 <br></br> 
  
<div class="container-fluid "  style="background-color:white;margin:0px 30px;">


<%
String title=request.getParameter("title");
Connection conn=DbUtil.getConnection();
PreparedStatement stmt;
stmt = conn.prepareStatement("select * from information where title=?");
stmt.setString(1, title);
ResultSet rs= stmt.executeQuery();
while(rs.next()){
	
String content=rs.getString("content");
String date=rs.getString("date");
%>

 
<h3> <%=title%></h3>
<h6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=content %></h6>
 <%=date %>


<%
}
stmt.close();
conn.close();

%>

</div>
</body>
</html>