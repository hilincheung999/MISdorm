package leave_search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eb.javaweb.DbUtil;

/**
 * Servlet implementation class leave_search1
 */
@WebServlet("/leave_search1")
public class leave_search1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leave_search1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();		
		String dormapt=(String) session.getAttribute("dormapt");
		
		try {

			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			request.setCharacterEncoding("utf-8");
			Connection conn=DbUtil.getConnection();
			int page = Integer.parseInt(request.getParameter("page"));
			String start=request.getParameter("start");
			String end=request.getParameter("end");
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date1 =df1.parse(start);
			java.sql.Date sqlDate1=new java.sql.Date(date1.getTime());  
			System.out.print(sqlDate1);
			Date date2 =df1.parse(end);
			java.sql.Date sqlDate2=new java.sql.Date(date2.getTime());  
			System.out.print(sqlDate2);
		 
			String sql = "select * from destination where dormapt=? and leavetime between ? and ? limit " + (page * 5) + ",5";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,dormapt);
			stmt.setDate(2,sqlDate1);
			stmt.setDate(3,sqlDate2);
			ResultSet rs= stmt.executeQuery();
			String j = "{\"rows\": [";
			
			while(rs.next()) {
				
				j += "{";
				j += "\"stunum\": \"" + rs.getString("stunum") + "\", ";
				j += "\"stuname\": \"" + rs.getString("stuname") + "\", ";
				j += "\"dormapt\": \"" + rs.getString("dormapt") + "\", ";
				j += "\"dormnum\": \"" + rs.getString("dormnum") + "\", ";
				j += "\"phone\": \"" + rs.getString("phone") + "\", ";
				j += "\"destination\": \"" + rs.getString("destination") + "\", ";
				j += "\"leavetime\": \"" + rs.getString("leavetime") + "\", ";
				j += "\"backtime\": \"" + rs.getString("backtime") + "\"";
				j += "}";
				
				j += ", ";
				
			}
			
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			sql = "select count(*) as c from destination where dormapt=? and leavetime between ? and ?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,dormapt);
			stmt.setDate(2,sqlDate1);
			stmt.setDate(3,sqlDate2);
			rs= stmt.executeQuery();
			String c = "";	
			if (rs.next()) {			
				c = rs.getString("c");	
			}		
			j += "], \"total\": " + c + "}";
			 
			pw.print(j);
		
			System.out.println(j);
			System.out.println(c);

			stmt.close();
			pw.close();
			conn.close();
			
			
		} 
	     catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
