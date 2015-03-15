package ie.cit.adf.web;


import ie.cit.adf.domain.Customer;
import ie.cit.adf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	// Display Customer List
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "customerList";
	}
	
	//display new Customer form
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String formProduct(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerForm";
	}
	
	// saves a new product
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Customer customer) {
		customerService.save(customer);	
		return "redirect:/customer/";
	}

}
