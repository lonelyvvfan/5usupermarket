package cs.action;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFilter extends HttpServlet implements Filter {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
    }

    public void doFilter(ServletRequest sRequest, ServletResponse sResponse,      
            FilterChain filterChain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) sRequest;      
        HttpServletResponse response = (HttpServletResponse) sResponse;      
        HttpSession session = request.getSession();      
        String url=request.getServletPath().replace("/admin", ""); 
        String contextPath=request.getContextPath();  
        if(url.equals("")) url+="/";  
        if((url.startsWith("/")&&!url.startsWith("/login"))){
             String username=(String)session.getAttribute("username");
             String author=(String)session.getAttribute("author");
             if(username==null||author!="0"){
            	 
           	  response.sendRedirect(contextPath+"/normal/index.jsp");
                  
                  return;  
             }
             else{
             }
        }  
          filterChain.doFilter(sRequest, sResponse);  	
    }  

    public void init(FilterConfig arg0) throws ServletException {

    }
}