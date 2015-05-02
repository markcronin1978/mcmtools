package ie.cit.adf.web;



import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	
	@RequestMapping(value="/userRole",method=RequestMethod.GET)
	public String loginDetails(HttpSession session, HttpServletRequest request, ModelMap modelMap){
		String userName= request.getRemoteUser();    //This is to extract the userName/emailAddress of the user logged in. 
		
		
		//boolean b = request.isUserInRole("ROLE_ADMIN");  //this boolean statement verifies wheither or not the user logging in as the ROLE "ROLE_ADMIN"

		if (request.isUserInRole("ROLE_ADMIN")){
			System.out.println("Here we are!!!");
			return "redirect:adminController/";
		}
		else{								//if user has not role of "ROLE_ADMIN", they are a customer and redirect them to saleOrderController, plus send		
			return "redirect:saleorderController/";  //the userName at the end of the URL. 
		}	
	}

/**@Controller
public class UserController {
	
	//private Authentication auth = SecurityContextHolder.getContext()
			//.getAuthentication();
	
	@RequestMapping(value="/userRole",method=RequestMethod.GET)
	public void welcome(HttpServletRequest request, Model model){
		
		if(request.isUserInRole("ROLE_ADMIN")){
			System.out.println("ROLE_ADMIN=");
		}
	  	//request.isUserInRole("ROLE_CUSTOMER");
	    System.out.println("ROLE_USER=");
	}**/
	
	//Object user = SecurityContextHolder.getContext().getAuthentication().getCredentials();
}
