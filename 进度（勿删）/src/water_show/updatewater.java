package water_show;

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
 * Servlet implementation class updatewater
 */
@WebServlet("/updatewater")
public class updatewater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatewater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();		
		String dormapt=(String) session.getAttribute("dormapt");
		String waterorder=request.getParameter("wo");
		
		try {
			Connection conn=DbUtil.getConnection();
			 
			
			
			String sql="update water set type=? where waterorder=? and dormapt=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,"Î´Íê³É");
			stmt.setString(2,waterorder);
			stmt.setString(3, dormapt);
			
			
			 
		    int affected = stmt.executeUpdate();

			stmt.close();
			conn.close();
			//request.setCharacterEncoding("UTF-8");
			response.setContentType("text/x-json");
			PrintWriter ab=response.getWriter();
			ab.print("{\"S\": " + (affected == 1 ? "true" : "false") + ", \"wo\": \"" + waterorder + "\"}");
			

			ab.close();
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
