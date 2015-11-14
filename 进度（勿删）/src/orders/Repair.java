package orders;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties; 

import javax.servlet.jsp.PageContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eb.javaweb.DbUtil;

import com.jspsmart.upload.*;
/**
 * Servlet implementation class PaySuccessfully
 */
@WebServlet("/Repair")
public class Repair extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

	

    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }
    final public ServletConfig getServletConfig() {
        return config;
    }
    public Repair() {
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
	 
		PrintWriter out=response.getWriter();
		ServletConfig config;
        response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	    HttpSession session=request.getSession();
		String stunum=(String) session.getAttribute("stunum");	
		String dormnum=(String) session.getAttribute("dormnum");
		String dormapt=(String) session.getAttribute("dormapt");
		//String time=request.getParameter("time");
		
	
	    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date now=new java.util.Date(); 
		String str_date1 = formatter.format(now);
		String year=str_date1.substring(0,4);
		String month=str_date1.substring(5,7);
		String day=str_date1.substring(8,10);
		String hour=str_date1.substring(11,13);
		String minute=str_date1.substring(14,16);
		String second=str_date1.substring(17,19);	
			
		
		 SmartUpload su =new SmartUpload(); 
		 String fileExt="";
	     String url="image/";
	     su.initialize(getServletConfig(), request, response); 
	     

	     
	    try {
	        su.upload(); 
	   } catch (Exception e){
	   }
	    
	    try{
	      com.jspsmart.upload.File myFile = su.getFiles().getFile(0);  
	      fileExt= myFile.getFileExt();    
	      String fileurl="";
	  
		
			Connection conn=DbUtil.getConnection();
			PreparedStatement stmt=conn.prepareStatement("insert into fix values(?,?,?,?,?,?,?,?,?,'鏈畬鎴�')",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    String fixorder=year+month+day+hour+minute+second;
//			String stunum=(String) session.getAttribute("stunum");
			String name=su.getRequest().getParameter("name");
//			String dormapt=(String) session.getAttribute("dormapt");
//			String dormnum=(String) session.getAttribute("dormnum");
			String phone=su.getRequest().getParameter("phone");
			String time=su.getRequest().getParameter("time");
			String img=myFile.getFileName();
			String problem=su.getRequest().getParameter("problem");
		
			
			stmt.setString(1,fixorder);
			stmt.setString(2,stunum);
			stmt.setString(3,name);
			stmt.setString(4,dormapt);
			stmt.setString(5,dormnum);
			stmt.setString(6,phone);
			stmt.setString(7,time);
			stmt.setString(8,img);
			stmt.setString(9,problem);
			
			stmt.executeQuery();

			stmt.close();
			conn.close();
    myFile.saveAs("/image/"+ img);
   
	out.print("<script language='javascript'>alert('提交成功！');window.location.href='MyWeb/repair.html';</script>");
   
		} catch (SQLException | SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	     }
	   
    }


