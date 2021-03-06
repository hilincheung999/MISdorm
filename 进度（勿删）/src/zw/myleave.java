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
 * Servlet implementation class showinformation
 */
@WebServlet("/myleave")
public class myleave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myleave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page4"));
		
		//������ѯ
		HttpSession session=request.getSession();
				
		String stunum=(String) session.getAttribute("stunum");
		try {
			//String stunum="09133";
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			String j = "{\"rows\": [";
			Connection conn=DbUtil.getConnection();
			PreparedStatement stmt;
			stmt = conn.prepareStatement("select * from destination where stunum=? order by leavetime desc limit " + (page * 5) + ",5");
			stmt.setString(1, stunum);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				
					
			
		
		String destination=rs.getString("destination");
		String leavetime=rs.getString("leavetime");
		String  backtime=rs.getString("backtime");
		String phone=rs.getString("phone");
		
		j += "{";
		j += "\"destination\": \"" +destination + "\", ";
		j += "\"leavetime\": \"" + leavetime + "\", ";
		j += "\"backtime\": \"" +backtime + "\", ";
		j += "\"phone\": \"" + phone + "\"";
		j += "}";
		j += ", ";
			}
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			String sql = "select count(*) as c from destination where stunum=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, stunum);
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
