package ie.cit.adf.web;



import javax.servlet.http.HttpServletRequest;

import ie.cit.adf.domain.CreditCard;
import ie.cit.adf.domain.Product;
import ie.cit.adf.domain.SaleOrder;
import ie.cit.adf.service.SaleOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/saleorderController")
public class SaleOrderController {
	
	SaleOrder so = new SaleOrder();		
	Product P;
	
										  
	private SaleOrderService saleOrderService;
	
	@Autowired
	public SaleOrderController(SaleOrderService saleOrderService){
		this.saleOrderService = saleOrderService;
	}
	
   /* @RequestMapping(value = "/username", method = RequestMethod.GET)
    public void currentUserName(Principal principal) {
    	so.setCustomerEmail(principal.getName());
        //return principal.getName();
    }*/
	
	/**
	 * Return a list of all products to the ProductOrderForm
	 * @param model
	 * @return ProductOrderForm view
	 */
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String listProduct(Model model){
		model.addAttribute("productList", saleOrderService.findAll());
		so.setCustomerEmail(SecurityContextHolder.getContext().getAuthentication().getName());
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
		model.addAttribute("customer", saleOrderService.getByEmailAddress(so.getCustomerEmail()));
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
		model.addAttribute("email", so.getCustomerEmail());
		CreditCard cc = new CreditCard();
		model.addAttribute("creditCard", cc);
		return "payment";
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String pay(@ModelAttribute CreditCard creditCard, Model model){
		saleOrderService.save(creditCard); 
		return "redirect:/saleorderController/display";
	}
	
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public String displayDetails(Model model){
		
		Product p = saleOrderService.getBySKU(so.getProductSKU());
		so.setCost(p.getPricePerUnit()*so.getQuantity());	
		model.addAttribute("cost", so.getCost());
		
		p.setStockLevel(p.getStockLevel()-so.getQuantity());
		saleOrderService.save(p);
		model.addAttribute("saleOrder", so);
		return "purchaseDisplay";
	}
	
	@RequestMapping(value="/confirm", method=RequestMethod.POST) 
	public String confirmOrder(@ModelAttribute SaleOrder saleOrder, Model model){
		saleOrderService.save(saleOrder);		 
		return "redirect:/saleorderController/";	
	}	
}