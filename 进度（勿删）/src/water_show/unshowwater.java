package water_show;

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
@WebServlet("/unshowwater")
public class unshowwater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public unshowwater() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		HttpSession session=request.getSession();		
		String dormapt=(String) session.getAttribute("dormapt");
		try {
			
			Connection conn=DbUtil.getConnection();
			
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			String j = "{\"rows\": [";
			PreparedStatement stmt=conn.prepareStatement("select * from water where type=? and dormapt=? limit " + (page * 5) + ",5");
			
			stmt.setString(1,"未付款");
			stmt.setString(2, dormapt);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				
					
			
		String waterorder=rs.getString("waterorder");
		String stunum=rs.getString("stunum");
		String name=rs.getString("name");
		String dormnum=rs.getString("dormnum");
		String phone=rs.getString("phone");
		String time=rs.getString("time");
		j += "{";
		
		j += "\"waterorder\": \"" +waterorder + "\", ";
		j += "\"stunum\": \"" +stunum + "\", ";
		j += "\"name\": \"" +name + "\", ";
		j += "\"dormapt\": \"" +dormapt + "\", ";
		j += "\"dormnum\": \"" +dormnum + "\", ";
		j += "\"phone\": \"" +phone + "\", ";
		
		j += "\"time\": \"" + time + "\"";
		
		j += "}";
		
		j += ", ";
		
		//out.print(waterorder+"<br/>");
		//out.print(stunum+"<br/>");
		//out.print(name+"<br/>");
		//out.print(dormapt+"<br/>");
		//out.print(dormnum+"<br/>");
		//out.print(phone+"<br/>");
		//out.print(time+"<br/>");
		
		
			}
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			String sql = "select count(*) as c from water where type='鏈敮浠�' and dormapt=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, dormapt);
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
			
			//out.close();
			
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
