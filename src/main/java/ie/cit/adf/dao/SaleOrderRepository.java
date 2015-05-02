package ie.cit.adf.dao;


import ie.cit.adf.domain.SaleOrder;

import java.util.List;

public interface SaleOrderRepository {

	/**
	 * return a list of previous purchase products by the customer
	 * @param name
	 * @return
	 */
	List<SaleOrder> purchaseHist(String name);

	void save(SaleOrder saleOrder);
	

}
