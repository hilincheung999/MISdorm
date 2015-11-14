package login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class loginfilter
 */
   @WebFilter  (description = "Do the Customer Login Filter", 
                urlPatterns = { "/MyWeb/water.html",
		  "/MyWeb/repair.html",
		   "/MyWeb/note.html" ,
		  "/MyWeb/leaveschool.html",
		   "/MyWeb/personal.html" 
   }, 
                initParams = { 
                  })
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

        HttpServletRequest rq = (HttpServletRequest)request;
		
		HttpSession session = rq.getSession();
		
		if (
				session.getAttribute("logined") != null && 
				(Boolean)session.getAttribute("logined")
		) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse)response).sendRedirect("login.html");
		}
		
	}
	// pass the request along the filter chain
		

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
