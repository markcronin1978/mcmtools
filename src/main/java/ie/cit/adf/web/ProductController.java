package ie.cit.adf.web;



import javax.validation.Valid;

import ie.cit.adf.domain.Product;
import ie.cit.adf.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	/**
	 * returns a list of all products..
	 * @param model
	 * @return productList view
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)             
	public String listProducts(Model model) {						  	
		model.addAttribute("products", productService.findAll());	      
		return "productList";	
	}
	
	/**
	 * display new product form
	 * @param model
	 * @return productForm view
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String formProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}
	
	/**
	 * saves a new product
	 * validates information being entered
	 * @param product
	 * @return redirect to productList view.
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid Product product, BindingResult results, Model model) {
		if(results.hasErrors()){
			return "productForm";
		}else{
			productService.save(product);	
			return "redirect:/product/";
		}
	}
}
