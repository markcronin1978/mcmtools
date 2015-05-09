package ie.cit.adf.web;




import javax.validation.Valid;

import ie.cit.adf.domain.Customer;
import ie.cit.adf.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService customerService;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
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
	 * encodes the new customer password
	 * @param customer
	 * @return redirected view to customerList
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute @Valid Customer customer, BindingResult results, Model model) {
		if(results.hasErrors()){
			return "customerForm";
		}else{
			String encodedPass = passwordEncoder.encode(customer.getPassword());
			customer.setPassword(encodedPass);
			customerService.save(customer);	
			return "redirect:/customer/";
		}		
	}

}
