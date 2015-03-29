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
										  
	private SaleOrderService saleOrderService;
	
	@Autowired
	public SaleOrderController(SaleOrderService saleOrderService){
		this.saleOrderService = saleOrderService;
	}
	
	/**
	 * Return a list of all products to the ProductOrderForm
	 * @param model
	 * @return ProductOrderForm view
	 */
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String listProduct(Model model){
		model.addAttribute("productList", saleOrderService.findAll());
		return "ProductOrderForm";                            
	}
	
	/**
	 * Takes in the selected Product SKU
	 * Sets the SaleOrder Product SKU
	 * @param SKU
	 * @param model
	 * @return ProductOrderFormQuantity view
	 */
	@RequestMapping(value="/{SKU}", method = RequestMethod.GET)
	public String selectedSKU(@PathVariable("SKU")int SKU, Model model){
		model.addAttribute("productSelected", saleOrderService.getBySKU(SKU));
		so.setProductSKU(SKU);
		return "ProductOrderFormQuantity";
	}
	
	/**
	 * Quantity of selected item to purchase
	 * with a two checks, one to verify that a quantity 
	 * has being entered and the other to verify that it
	 * does not exceed the stock level for that product	
	 * @param quantity
	 * @param model
	 * @return possible of three views defined to on the result of the if statement
	 */
	@RequestMapping(value= "/quantity", method = RequestMethod.POST)
	public String Quantity(@RequestParam("quantity")int quantity, Model model){
		if(quantity==0){
			String Error_msg = "Enter the Quantity Required!!";
			model.addAttribute("productSelected", saleOrderService.getBySKU(so.getProductSKU()));
			model.addAttribute("Error_msg", Error_msg); 
			return "ProductOrderFormQuantity";
		}
		else if(quantity > saleOrderService.getQuantityBySKU(so.getProductSKU())){
			String Error_msg = "Not Enough Items in Stock for Order!!";
			model.addAttribute("productSelected", saleOrderService.getBySKU(so.getProductSKU()));
			model.addAttribute("Error_msg", Error_msg); 
			return "ProductOrderFormQuantity";			
		}
		else{
		so.setQuantity(quantity); 
		model.addAttribute("customer", saleOrderService.getByEmailAddress("markcronin120@gmail.com")); //hard coded for now!!
		return "productOrderShippingDetails";
		}
	}
	/**
	 * This method is used to take information from the customer
	 * about the credit card details
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String paymentDetails(Model model){
		System.out.println("Hi all");
		return "redirect:/saleorderController/";
	}
	
}