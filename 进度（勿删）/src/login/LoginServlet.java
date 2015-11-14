package login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eb.javaweb.DbUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		String p = "";
		String u = "";
		String fp = "";
		String fu = "";
		String fa = "";
		String stuname="";
		String dormapt="";
		String dormnum="";
		String email="";
		String phone="";
		HttpSession session=request.getSession();
		String stunum = request.getParameter("stunum");
		String password = request.getParameter("password");
		String r=request.getParameter("identity");
		PrintWriter out=response.getWriter();
		Connection conn = eb.javaweb.DbUtil.getConnection();

		try {
		  
			if("1".equals(r)){
				PreparedStatement ftmt = conn
						.prepareStatement("select * from admin where username=?");	
				ftmt.setString(1, stunum);
				ResultSet fs = ftmt.executeQuery();
				while (fs.next()) {
					 fu=fs.getString("username");
					 fp = fs.getString("password");
					 fa=fs.getString("dormapt");
					 fs.close();
				}
					 if(fp.equals(password)){
						 response.sendRedirect("MyWeb/backstage.html");
						 session.setAttribute("dormapt", fa);
					     request.getSession().setAttribute("logined", true);
					 }else{
						 out.print("<script language='javascript'>alert('登录信息错误');window.location.href='MyWeb/login.html';</script>");	
					 }
			}else if("2".equals(r)){		 
			    PreparedStatement stmt = conn
					   .prepareStatement("select * from users where stunum=?");
			     stmt.setString(1, stunum);
			     ResultSet rs = stmt.executeQuery();
			     while (rs.next()) {
				    p = rs.getString("password");
				    u=rs.getString("stunum");
				    stuname=rs.getString("stuname");
			        dormnum=rs.getString("dormnum");
			        dormapt=rs.getString("dormapt");
				    email=rs.getString("email");
				    phone=rs.getString("phone");
				    rs.close();
			     }
				
			     if(password.equals(p)){
				     if(p.equals(u)){
					  out.print("<script language='javascript'>alert('初次登录，请您修改密码！');window.location.href='MyWeb/changepw.html';</script>");			
					
				     }else{
					
					 response.sendRedirect("MyWeb/DormManager.html");
					 session.setAttribute("stuname", stuname);
					 session.setAttribute("dormnum", dormnum);
					 session.setAttribute("dormapt", dormapt);
					 session.setAttribute("email", email);	
					 session.setAttribute("phone", phone);
	
						request.getSession().setAttribute("logined", true);
					 
				     }
			
			     }else{
				 out.print("<script language='javascript'>alert('登录失败！');window.location.href='MyWeb/login.html';</script>");			
			     }	
			} 
			
			session.setAttribute("stunum", stunum);
			session.setAttribute("password", password);
			
		    conn.close();
	} catch (SQLException e) {
	e.printStackTrace();
				
	}}
			
		

	protected void userlogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

}
