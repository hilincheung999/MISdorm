package updatepwd;

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
 * Servlet implementation class updatepwd
 */
@WebServlet("/updatepwd")
public class updatepwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		Connection conn=DbUtil.getConnection();
		
		try {
			
			String stunum=request.getParameter("stunum");
			String oldpw=request.getParameter("oldpw");
			String newpw=request.getParameter("newpw");
			String d="";
			String ap="";
			
			
			PreparedStatement stmt=conn.prepareStatement("select * from users where stunum=? and password=?");
			
		    stmt.setString(1,stunum);
			stmt.setString(2,oldpw);
			ResultSet rs= stmt.executeQuery();
			
				
			
			if (rs.next()){
				d=rs.getString("dormnum");
				ap=rs.getString("dormapt");
			
			String sql="update users set password=? where stunum=?";
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setString(1,newpw);
			stm.setString(2,stunum);
			
			
			stm.executeUpdate();

			stm.close();
				
		 
			    if(d!=null&&!d.equals("")&& ap!=null&&!ap.equals("")){    
			    	response.sendRedirect("MyWeb/DormManager.html");
			    }else
			        
			    	out.print("<script language='javascript'>alert('修改成功！');window.location.href='MyWeb/personal.html';</script>");
			    	//response.sendRedirect("MyWeb/personal.html");
			     }
			
			
			else {
				out.print("<script language='javascript'>alert('修改失败，请重新尝试！');window.location.href='MyWeb/changepw.html';</script>");
	
				
			}
			 
			stmt.close();
			conn.close();
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
