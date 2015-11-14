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
@WebServlet("/Showunrepair")
public class Showunrepair extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showunrepair() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int page = Integer.parseInt(request.getParameter("page2"));
		//int page=0;
		HttpSession session=request.getSession();
		String num=(String) session.getAttribute("stunum");
		
		try {
			//String num="1";
			Connection conn=DbUtil.getConnection();
			//锟斤拷锟斤拷锟斤拷询
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			String j = "{\"rows\": [";
			PreparedStatement stmt=conn.prepareStatement("select * from fix where type=? and stunum=? order by time desc limit " + (page * 5) + ",5");
			
			stmt.setString(1,"未完成");
			stmt.setString(2,num);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				
					
				String fixorder=rs.getString("fixorder");
				String name=rs.getString("name");
				String stunum=rs.getString("stunum");
				String dormapt=rs.getString("dormapt");
				String dormnum=rs.getString("dormnum");
				String phone=rs.getString("phone");
				String time=rs.getString("time");
				String problem=rs.getString("problem");
		j += "{";
		
		j += "\"fixorder\": \"" +fixorder + "\", ";
		j += "\"stunum\": \"" +stunum + "\", ";
		j += "\"name\": \"" +name + "\", ";
		j += "\"dormapt\": \"" +dormapt + "\", ";
		j += "\"dormnum\": \"" +dormnum + "\", ";
		j += "\"phone\": \"" +phone + "\", ";
		j += "\"time\": \"" +time + "\", ";	
		j += "\"problem\": \"" + problem + "\"";
		
		j += "}";
		
		j += ", ";
		
		
		
			}
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			String sql = "select count(*) as c from fix where type='未完成' and stunum=?";
			
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,num);
			rs= stmt.executeQuery();
			String c = "";	
			if (rs.next()) {			
				c = rs.getString("c");	
			}		
			j += "], \"total\": " + c + "}";
			 
			pw.print(j);
		//	pw.print(c);
			System.out.println(j);

			
			
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
