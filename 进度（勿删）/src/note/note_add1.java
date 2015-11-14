package note;

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

import eb.javaweb.DbUtil;
/**
 * Servlet implementation class note_add1
 */
@WebServlet("/note_add1")
public class note_add1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public note_add1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Connection conn=DbUtil.getConnection();
			//������ѯ
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			PreparedStatement stmt=conn.prepareStatement("select * from suggestion order by date desc");
			ResultSet rs= stmt.executeQuery();
			String j = "{\"rows\": [";
			
			while(rs.next()) {
				
				j += "{";
				j += "\"title\": \"" + rs.getString("title") + "\", ";
				j += "\"name\": \"" + rs.getString("name") + "\", ";
				j += "\"content\": \"" + rs.getString("content") + "\", ";
				j += "\"date\": \"" + rs.getString("date") + "\"";
				
				j += "}";
				
				j += ", ";
				
			}
			
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			j += "]}";
								
			pw.print(j);
			
			stmt.close();
			conn.close();
			
			
			
		} catch (SQLException e) {

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
