package ie.cit.adf.web;



import ie.cit.adf.domain.Product;
import ie.cit.adf.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService){
		this.productService = productService;
	}
	
	//returns a list of all products..
	@RequestMapping(value="/", method=RequestMethod.GET)             
	public String listProducts(Model model) {						  	
		model.addAttribute("products", productService.findAll());	      
		return "productList";	
	}
	
	//display new product form
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String formProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}
	
	// saves a new product
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String save(@ModelAttribute Product product) {
		productService.save(product);	
		return "redirect:/product/";
	}
}
