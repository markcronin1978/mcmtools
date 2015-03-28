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
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}
	
	/**
	 * Display Customer List
	 * @param model
	 * @return customerList view
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.findAll());
		System.out.println("Here ListCustomerMethod");
		return "customerList";
	}
	
	/**
	 * display new Customer form
	 * @param model
	 * @return customerForm view
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String formCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerForm";
	}
	
	/**
	 * saves a new Customer
	 * @param customer
	 * @return redirected view to customerList
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer) {
		System.out.println("CustomerContorller");
		customerService.save(customer);	
		System.out.println("CustomerContorller1");
		return "redirect:/customer/";
	}

}
