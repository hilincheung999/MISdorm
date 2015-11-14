package information;

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
@WebServlet("/showinformation")
public class showinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showinformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page= Integer.parseInt(request.getParameter("page"));
		
		//·ÖÒ³Æ÷
		HttpSession session=request.getSession();		
		String dormapt=(String) session.getAttribute("dormapt");
		
		try {
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			String j = "{\"rows\": [";
			Connection conn=DbUtil.getConnection();
			PreparedStatement stmt;
			stmt = conn.prepareStatement("select * from information where dormapt=?limit " + (page * 5) + ",5");
			stmt.setString(1,dormapt);
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				
					
			
		
		String title=rs.getString("title");
		String content=rs.getString("content");
		String date=rs.getString("date");
		j += "{";
		
		j += "\"title\": \"" +title + "\", ";
		j += "\"content\": \"" +content + "\", ";
		
		j += "\"date\": \"" + date + "\"";
		
		
		j += "}";
		
		j += ", ";
		
		
		
		
			}
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			String sql = "select count(*) as c from information where dormapt=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,dormapt);
			rs= stmt.executeQuery();
			String c = "";	
			if (rs.next()) {			
				c = rs.getString("c");	
			}		
			j += "], \"total\": " + c + "}";
			 
			pw.print(j);
			System.out.println(j);

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
