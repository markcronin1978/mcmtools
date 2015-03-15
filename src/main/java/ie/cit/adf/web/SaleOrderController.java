package ie.cit.adf.web;

import ie.cit.adf.domain.SaleOrder;
import ie.cit.adf.service.SaleOrderService;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/saleorderController")
public class SaleOrderController {
	
	SaleOrder so = new SaleOrder();	
	
	@Autowired									  
	private SaleOrderService saleOrderService;
	
	//Return a list of all products to the ProductOrderForm
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String listProduct(Model model){
		System.out.println("HI");
		model.addAttribute("productList", saleOrderService.findAll());
		return "ProductOrderForm";                            
	}
	
	//Take the selected Product SKU and display the quantity jsp page..
	@RequestMapping(value="/{SKU}", method = RequestMethod.GET)
	public String selectedSKU(@PathVariable int SKU, Model model){
		System.out.println(SKU);
		model.addAttribute("productSelected", saleOrderService.getBySKU(SKU));
		return "ProductOrderFormQuantity";
	}
	
	//Quantity of selected item to purchase
	@RequestMapping(value= "/quantity", method = RequestMethod.POST)
	public String Quantity(@RequestParam("quantity")int quantity, Model model){
		System.out.println(quantity);
		return "redirect:/";
	}
}