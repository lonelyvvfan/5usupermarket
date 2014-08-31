package cs.action;

import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.TextParseUtil;

public class UserloginInterceptor extends AbstractInterceptor{
	 private static final long serialVersionUID = 1L;  
     
     private String username;//session 中放的值；  
     private String exclude;//不需要拦截的页面;  
  
     @Override  
     public String intercept(ActionInvocation invocation) throws Exception {  
             Set<String> set = TextParseUtil.commaDelimitedStringToSet(exclude); 
             System.out.println("in the intercept the username="+username);  
             System.out.println(invocation.getProxy().getActionName());  
             if (set.contains(invocation.getProxy().getActionName())) { 
            	 System.out.println("action in ?"); 
                     return invocation.invoke();  
             } else {  
                     if (ServletActionContext.getRequest().getSession().getAttribute("username") != null&&ServletActionContext.getRequest().getSession().getAttribute("author")=="2") { 
                    	 System.out.println("not in username"); 
                    	 System.out.println(ServletActionContext.getRequest().getSession().getAttribute("author")+"小p孩你是这个权限的哟");
                             return invocation.invoke();  
                     }  
             }  
             return "login";  
     }  
  
  
  
     public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getExclude() {  
             return exclude;  
     }  
  
     public void setExclude(String exclude) {  
             this.exclude = exclude;  
     }  
  

}
