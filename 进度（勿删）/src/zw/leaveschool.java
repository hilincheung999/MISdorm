package zw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eb.javaweb.DbUtil;

/**
 * Servlet implementation class leaveschool
 */
@WebServlet("/leaveschool")
public class leaveschool extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leaveschool() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String stunum=(String) session.getAttribute("stunum");

		String stuname=(String) session.getAttribute("stuname");
		String dormapt=(String) session.getAttribute("dormapt");
		String dormnum=(String) session.getAttribute("dormnum");

		String leavetime=request.getParameter("leavetime");
		String backtime=request.getParameter("backtime");
		String phone=request.getParameter("phone");
		String destination=request.getParameter("destination");
		//String stuname="jdaskjd";
		//String stunum="09133";
		//String dormapt="09133";
		//String dormnum="09133";
		if (leavetime!=null&& !leavetime.equals("") && backtime!=null &&!backtime.equals("") && phone!=null&&! phone.equals("") && destination!=null&&!destination.equals("") ){
	try {
		Connection conn=DbUtil.getConnection();
		
		
		PreparedStatement stmt;
		stmt = conn.prepareStatement("insert into destination values(?,?,?,?,?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stmt.setString(1,stunum);
		stmt.setString(2,stuname);
		stmt.setString(3,phone);
		stmt.setString(4,dormapt);
		stmt.setString(5,dormnum);
		stmt.setString(6,destination);

		stmt.setString(7,leavetime);
		stmt.setString(8,backtime);
		
		
		stmt.executeQuery();
		
		stmt.close();
		conn.close();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter ab=response.getWriter();
		
		ab.print("<script language='javascript'>alert('提交申请单成功!');window.location.href='MyWeb/leaveschool.html';</script>");

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
			
			ab.print("<script language='javascript'>alert('提交失败，请重新提交！');window.location.href='MyWeb/leaveschool.html';</script>");

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
