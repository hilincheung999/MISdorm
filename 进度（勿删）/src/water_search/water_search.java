package water_search;

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
 * Servlet implementation class water_search
 */
@WebServlet("/water_search")
public class water_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public water_search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();		
		String dormapt=(String) session.getAttribute("dormapt");
		
		String key=request.getParameter("keyword");
		int page = Integer.parseInt(request.getParameter("page"));
		try {
			request.setCharacterEncoding("utf-8");
			Connection conn=DbUtil.getConnection();
			String sql = "select * from water where dormnum=? and dormapt=? limit " + (page * 5) + ",5";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, key);
			stmt.setString(2, dormapt);
			ResultSet rs= stmt.executeQuery();
			
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			
			String j = "{\"rows\": [";
			
			while(rs.next()) {
				
				j += "{";
				j += "\"waterorder\": \"" + rs.getString("waterorder") + "\", ";
				j += "\"stunum\": \"" + rs.getString("stunum") + "\", ";
				j += "\"name\": \"" + rs.getString("name") + "\", ";
				j += "\"dormapt\": \"" + rs.getString("dormapt") + "\", ";
				j += "\"dormnum\": \"" + rs.getString("dormnum") + "\", ";
				j += "\"phone\": \"" + rs.getString("phone") + "\", ";
				j += "\"time\": \"" + rs.getString("time") + "\", ";
				j += "\"type\": \"" + rs.getString("type") + "\"";
				
				j += "}";
				
				j += ", ";
				
			}
			
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			sql = "select count(*) as c from water where dormnum=? and dormapt=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, key);
			stmt.setString(2, dormapt);
			rs= stmt.executeQuery();
			String c = "";	
			if (rs.next()) {			
				c = rs.getString("c");	
			}		
			j += "], \"total\": " + c + "}";
			 
			pw.print(j);
		//	pw.print(c);
			System.out.println(j);
			System.out.println(c);
			System.out.println(page);
			
			
			stmt.close();
			pw.close();
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
