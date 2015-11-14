package zw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eb.javaweb.DbUtil;
/**
 * Servlet implementation class sugg
 */
@WebServlet("/sugg")
public class sugg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sugg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		
		try {
			Connection conn=DbUtil.getConnection();
			
			
			String name=request.getParameter("name");
			String subject=request.getParameter("subject");
			String message=request.getParameter("message");
			//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ñ¯
			
			
			String sql="insert into create2 values(?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,name);
			stmt.setString(2,subject);
			stmt.setString(3, message);
			stmt.executeUpdate();
			
			

			 
		    

			stmt.close();
			conn.close();
			out.print("<script language='javascript'>alert('Ìá½»³É¹¦£¡');window.location.href='MyWeb/DormManager.html';</script>");
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
