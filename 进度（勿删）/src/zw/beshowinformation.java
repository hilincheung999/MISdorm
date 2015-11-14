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
@WebServlet("/beshowinformation")
public class beshowinformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beshowinformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int page= Integer.parseInt(request.getParameter("page"));
		
		//������ѯ
		HttpSession session=request.getSession();		
		String dormapt=(String) session.getAttribute("dormapt");
		
		try {
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			String j = "{\"rows\": [";
			Connection conn=DbUtil.getConnection();
			PreparedStatement stmt;
			stmt = conn.prepareStatement("select * from information where dormapt=?");
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

			j += "]}";//锟叫讹拷锟角凤拷取锟斤拷锟斤拷锟斤拷锟揭伙拷锟街?
			
			pw.print(j);
			
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
