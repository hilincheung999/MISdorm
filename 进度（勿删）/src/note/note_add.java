package note;

import java.io.IOException;
import java.io.PrintWriter;

import eb.javaweb.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.text.SimpleDateFormat;
/**
 * Servlet implementation class note_add
 */
@WebServlet("/note_add")
public class note_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public note_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		HttpSession session=request.getSession();
		String stunum=(String) session.getAttribute("stunum");
		Statement stmt = null;
		try
			{   
			
			    SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");  
			    String date = formatter.format(new java.util.Date());  
				
			    PrintWriter out=response.getWriter();
			    out.println(date);
			    Connection conn=DbUtil.getConnection();
				stmt = conn.createStatement();
				stmt.executeUpdate("insert into suggestion(stunum,title,name,content,date) values('"+stunum+"','"+title+"','"+author+"','"+content+"','"+date+"')");
				stmt.close(); 	 	
				conn.close();
			
			}
			catch(Exception ex)
			{
				System.out.println(ex.toString());
			}
	}

}
