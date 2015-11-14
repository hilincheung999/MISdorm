package orders;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eb.javaweb.DbUtil;

/**
 * Servlet implementation class updatefix
 */
@WebServlet("/updatefix")
public class updatefix extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatefix() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fixorder=request.getParameter("myfix");
		
		try {
			Connection conn=DbUtil.getConnection();
		
			
			String sql="update fix set type=? where fixorder=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,"已完成");
			stmt.setString(2,fixorder);
			
			
			//仅有宿舍管理员有权利更改订单状态
		    int affected = stmt.executeUpdate();

			stmt.close();
			conn.close();
			//request.setCharacterEncoding("UTF-8");
			response.setContentType("text/x-json");
			PrintWriter out=response.getWriter();
			out.print("{\"S\": " + (affected == 1 ? "true" : "false") + ", \"myfix\": \"" + fixorder + "\"}");
			out.close();
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
