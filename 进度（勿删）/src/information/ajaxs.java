package information;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ajaxs
 */
@WebServlet("/ajaxs")
public class ajaxs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxs() {
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
		 String dormnum=request.getParameter("dormnum");      
		 String phone = request.getParameter("phone");     
		 String email = request.getParameter("email");     
		 String stuname = request.getParameter("stuname");     
	          

	        if (stuname == null || stuname.trim().length()== 0) { 
	            out.println("没有查询到该信息！"); 
	        } else if(phone == null || phone.trim().length()== 0){ 
	        	out.println("电话号码为空！"); 
	        } else if(dormnum == null || dormnum.trim().length()== 0){
	        	out.println("宿舍号为空！"); 
	        	
	        } else if(email == null || email.trim().length()== 0){
	        	out.println("邮箱为空！"); 
	        } else{
	        	 out.println("OK"); 
	        	
	        }
	        	
	        }
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
