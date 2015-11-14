package orders;

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
 * Servlet implementation class A
 */
@WebServlet("/Waterpaid")
public class Waterpaid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Waterpaid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page1"));
         //int page=0;
		HttpSession session=request.getSession();
		String stunum=(String) session.getAttribute("stunum");
		
		
		
		try {
			
			Connection conn=DbUtil.getConnection();
			
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			String j = "{\"rows\": [";
			PreparedStatement stmt=conn.prepareStatement("select * from water where type=? and stunum=? order by time desc limit " + (page * 5) + ",5");
			
			stmt.setString(1,"已支付");
			stmt.setString(2,stunum);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				
					
				String waterorder=rs.getString("waterorder");
				String name=rs.getString("name");
				String dormapt=rs.getString("dormapt");
				String dormnum=rs.getString("dormnum");
				String phone=rs.getString("phone");
				String time=rs.getString("time");
		j += "{";
		
		j += "\"waterorder\": \"" +waterorder + "\", ";
		j += "\"name\": \"" +name + "\", ";
		j += "\"dormapt\": \"" +dormapt + "\", ";
		j += "\"dormnum\": \"" +dormnum + "\", ";
		j += "\"phone\": \"" +phone + "\", ";	
		j += "\"time\": \"" + time + "\"";
		
		j += "}";
		
		j += ", ";
		
		
		
			}
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			String sql = "select count(*) as c from water where type=? and stunum=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, "已支付");
			stmt.setString(2,stunum);
			rs= stmt.executeQuery();
			String c = "";	
			if (rs.next()) {			
				c = rs.getString("c");	
			}		
			j += "], \"total1\": " + c + "}";
			 
			pw.print(j);
		//	pw.print(c);
			System.out.println(j);
			System.out.println(c);
			
			
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
