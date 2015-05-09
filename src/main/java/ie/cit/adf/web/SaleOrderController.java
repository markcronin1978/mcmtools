package ie.cit.adf.web;


import javax.validation.Valid;

import ie.cit.adf.domain.CreditCard;
import ie.cit.adf.domain.Product;
import ie.cit.adf.domain.SaleOrder;
import ie.cit.adf.service.SaleOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	/**
	 * Return a list of all products to the ProductOrderForm.
	 * Setting the Customer Email to the sale Order.
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
	 * does not exceed the stock level for that product.	
	 * Setting the quantity of item in the sale order.
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
	 * about the credit card details, if credit card information
	 * already exists for the customer it will return it to the customer
	 * @param model
	 * @return payment view
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String paymentDetails(Model model){
		model.addAttribute("email", so.getCustomerEmail());
		CreditCard cc = new CreditCard();
		model.addAttribute("creditCard", cc);
		return "payment";
	}
	
	/**
	 * This method is used to save the credit card information to the database, 
	 * If the payment information is entered fully an error is declared and the
	 * customer is redirected back to the payment.jsp page to reenter the information
	 * correctly.
	 * @param creditCard
	 * @param model
	 * @return redirects to SaleorderController/display method
	 */
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String pay(@ModelAttribute @Valid CreditCard creditCard, BindingResult results, Model model){
		if(results.hasErrors()){
			return "payment";
		}else{
			saleOrderService.save(creditCard); 
			return "redirect:/saleorderController/display";
		}
	}
	
	/**
	 * Here i am display the purchase order to the customer, 
	 * also setting the cost of the order
	 * @param model
	 * @return purchaseDisplay view.
	 */
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
	/**
	 * Method will save the order the database and return the customer 
	 * to the list product page. 
	 * Reinitializes SaleOrder Class.
	 * @param saleOrder
	 * @param model
	 * @return redirects to saleorderController/ method
	 */
	@RequestMapping(value="/confirm", method=RequestMethod.POST) 
	public String confirmOrder(@ModelAttribute SaleOrder saleOrder, Model model){
		String message = "Thank You!, Youre Order will be dispatched as soon as possible";
		saleOrderService.save(saleOrder);
		so = new SaleOrder();
		return "redirect:/saleorderController/";	
	}	
}