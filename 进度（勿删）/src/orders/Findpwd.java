package orders;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eb.javaweb.DbUtil;

/**
 * Servlet implementation class sendTextMail
 */
@WebServlet("/Findpwd")
public class Findpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Findpwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		Properties prop=new Properties();
		prop.setProperty("mail.smtp.host", "smtp.163.com");
		prop.setProperty("mail.smtp.port","25");	
		prop.setProperty("mail.smtp.auth", "true");
		Session session=Session.getDefaultInstance(prop,new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("hilincheung999@163.com","163yx1013//");
			}
		});
		PrintWriter out=response.getWriter();
		
		Message message=new MimeMessage(session);
		try {
			Connection conn=DbUtil.getConnection();
			PreparedStatement stmt=conn.prepareStatement("select * from users where stunum=?");   	   
			String stunum= request.getParameter("stunum");
			String email=request.getParameter("email");
			stmt.setString(1,stunum);	
			ResultSet rs= stmt.executeQuery();
			  
			while (rs.next()){	   
		       
		       if(email.equals(rs.getString("email"))){
		    	    message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
					message.setFrom(new InternetAddress("hilincheung999@163.com"));
					message.setSubject("宿舍管家找回密码！");
					String password=rs.getString("password");
					message.setText("请妥善保管您的密码！您的密码是"+password);
					message.setSentDate(new Date());
					
					Transport.send(message);}
					rs.close();
					conn.close();
				  //response.sendRedirect("MyWeb/login.html");
					out.print("<script language='javascript'>alert('邮件已发出，请注意查收！');window.location.href='MyWeb/login.html';</script>");		
		      } 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
