package ie.cit.adf.web;

import ie.cit.adf.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/adminController/")
public class AdminController {

	private AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService){
		this.adminService = adminService;
	}
	/**
	 * this URL comes from the UserController
	 * @param model
	 * @return content view & a list of previously purchased orders.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)   
	public String listPurchaseHist(Model model) {
		model.addAttribute("purchaseHist", adminService.findAll());
		return "purchaseHist";
	}

		

}