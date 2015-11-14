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
 * Servlet implementation class E
 */
@WebServlet("/E")
public class E extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public E() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String stunum =(String) session.getAttribute("stunum");
		String  stuname=(String) session.getAttribute("stuname");
	//String stunum="B2061";
		//String stuname="ç«?2";
		response.setContentType("text/x-json");
		PrintWriter pw = response.getWriter();
		String j = "{\"rows\": [";
		j += "{";
		j += "\"stunum\": \"" +stunum + "\", ";
j += "\"stuname\": \"" +stuname+ "\"";
		;
		j += "}";
		
		j += ", ";
		if (j != "{\"rows\": [") {
			j = j.substring(0, j.length() - 2);
		}

		j += "]}";
		pw.print(j);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
