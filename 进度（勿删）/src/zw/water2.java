package zw;

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
 * Servlet implementation class water2
 */
@WebServlet("/water2")
public class water2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public water2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String stunum=(String) session.getAttribute("stunum");	
		String dormnum=(String) session.getAttribute("dormnum");
		String dormapt=(String) session.getAttribute("dormapt");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String etime=request.getParameter("time");

		String state="未支付";
		
		if (name!=null&&!name.equals("")&&phone!=null&&!phone.equals("")&& etime!=null && !etime.equals("")){
		try {
			Calendar time = Calendar.getInstance();
			String ordernum = String.valueOf(time.get(Calendar.YEAR))   
			+ String.valueOf(time.get(Calendar.MONTH))   
			+ String.valueOf(time.get(Calendar.DAY_OF_MONTH))   
			+ String.valueOf(time.get(Calendar.HOUR_OF_DAY))   
			+ String.valueOf(time.get(Calendar.MINUTE))   
			+ String.valueOf(time.get(Calendar.SECOND));  
			
			

			Connection conn=DbUtil.getConnection();
			
				
				PreparedStatement stmt;
				
			stmt = conn.prepareStatement("insert into water values(?,?,?,?,?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1,stunum);
			stmt.setString(2,name);
			stmt.setString(3,dormapt);
			stmt.setString(4,dormnum);

			stmt.setString(5,phone);
			stmt.setString(6,etime);

			stmt.setString(7,ordernum);
			stmt.setString(8,state);
			
			
			stmt.executeQuery();
			
			stmt.close();
			conn.close();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter ab=response.getWriter();
			
			ab.print("<script language='javascript'>alert('预约送水成功！');window.location.href='MyWeb/water.html';</script>");

			ab.close();
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
			else{
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter ab=response.getWriter();
				
				ab.print("<script language='javascript'>alert('预约送水失败！');window.location.href='MyWeb/water.html';</script>");

				ab.close();
			}
				
			
		}
}
