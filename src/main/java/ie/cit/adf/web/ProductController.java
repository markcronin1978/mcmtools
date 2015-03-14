package ie.cit.adf.web;



import ie.cit.adf.dao.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository pr;
	
	@RequestMapping(value="/", method=RequestMethod.GET)              //this method is used when the to display all products on the web page.
	public String listProducts(Model model) {						  	
		model.addAttribute("products", pr.findAll());	      
		return "productList";	
	}

}
