package information;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eb.javaweb.DbUtil;

/**
 * Servlet implementation class noticepublish
 */
@WebServlet("/noticepublish")
public class noticepublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticepublish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content=request.getParameter("content");
		String title=request.getParameter("title");
		
	    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date now=new java.util.Date(); 
		String etime = formatter.format(now);

     if (title!=null&&!title.equals("")&&content!=null&&!content.equals("")){
    	 HttpSession session=request.getSession();		
 		String dormapt=(String) session.getAttribute("dormapt");
		
		try {
			Connection conn=DbUtil.getConnection();
			//连接数据库
			
			PreparedStatement stmt;
			
		stmt = conn.prepareStatement("insert into information values(?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1,title);
			stmt.setString(2,content);
			stmt.setString(3,etime);
			stmt.setString(4,dormapt);
			
			
			stmt.executeQuery();
			
			stmt.close();
			conn.close();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter ab=response.getWriter();
			
			ab.print("<script language='javascript'>alert('通知已成功发布！');window.location.href='MyWeb/notice_publish.html';</script>");

			ab.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
else{
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter ab=response.getWriter();
	
	ab.print("<script language='javascript'>alert('通知发布失败！');window.location.href='MyWeb/notice_publish.html';</script>");

	ab.close();
}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
