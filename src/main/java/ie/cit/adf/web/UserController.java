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
