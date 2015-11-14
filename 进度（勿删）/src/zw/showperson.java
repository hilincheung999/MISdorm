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
 * Servlet implementation class showperson
 */
@WebServlet("/showperson")
public class showperson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showperson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	String stunum="10";
		
		HttpSession session=request.getSession();
		
		String stunum=(String) session.getAttribute("stunum");		
		
	

	try {
		response.setContentType("text/x-json");
		PrintWriter pw = response.getWriter();
		String j = "{\"rows\": [";
		Connection conn=DbUtil.getConnection();
		PreparedStatement stmt;
		stmt = conn.prepareStatement("select * from users where stunum=?");
		stmt.setString(1, stunum);
		ResultSet rs= stmt.executeQuery();
		while(rs.next()){
			
			 String stuname = rs.getString("stuname");
		String phone=rs.getString("phone");
		String dormapt=rs.getString("dormapt");
		String dormnum=rs.getString("dormnum");
		String email=rs.getString("email");
		
		j += "{";
		
		j += "\"stuname\": \"" +stuname + "\", ";
		j += "\"phone\": \"" +phone + "\", ";
		j += "\"dormapt\": \"" +dormapt + "\", ";
		j += "\"dormnum\": \"" +dormnum + "\", ";
		
		j += "\"email\": \"" + email + "\"";
		
		
		j += "}";
		
		j += ", ";
		
		
		
		
			}
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			j += "]}";//�ж��Ƿ�ȡ�������һ���?
			
			pw.print(j);
			
			stmt.close();
			conn.close();
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
