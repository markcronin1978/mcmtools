package ie.cit.adf.web;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/userRole")
public class UserController {
	
	/**
	 * This controller is used to distinguish the role of the user logging in. 
	 * Checks is user is administrator, then redirects them to the AdminController
	 * if a customer, redirects them to the SaleOrderController
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String getUserDetails(Model model) {
		   UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().
		   getAuthentication().getPrincipal();
		   
		   if(userDetails.getAuthorities().toString().contains("[ROLE_ADMIN]")){
			   return "redirect:/adminController/";
		   }
		   else{
			   return "redirect:/saleorderController/";
		   }		   
	}
}
