package zw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class s
 */
@WebServlet("/B")
public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public B() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		String stunum=(String) session.getAttribute("stunum");
		
		if(stunum==null){
			session.setAttribute("stunum", "null");
			String cstunum=(String) session.getAttribute("cstunum");
			
			response.setContentType("text/x-json");
			PrintWriter pw = response.getWriter();
			String j = "{\"rows\": [";
			j += "{";
	j += "\"cstunum\": \"" + cstunum+ "\"";
			
			j += "}";
			
			j += ", ";
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}

			j += "]}";
			pw.print(j);
			pw.close();
		}
		else{
		session.setAttribute("cstunum",""+stunum+"");
		String cstunum=(String) session.getAttribute("cstunum");
		response.setContentType("text/x-json");
		PrintWriter pw = response.getWriter();
		String j = "{\"rows\": [";
		j += "{";
j += "\"cstunum\": \"" + cstunum+ "\"";
		
		j += "}";
		
		j += ", ";
		if (j != "{\"rows\": [") {
			j = j.substring(0, j.length() - 2);
		}

		j += "]}";
		pw.print(j);
		pw.close();
		}
		
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
