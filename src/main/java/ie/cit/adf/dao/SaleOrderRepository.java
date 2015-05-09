package ie.cit.adf.dao;


import ie.cit.adf.domain.SaleOrder;

import java.util.List;

public interface SaleOrderRepository {

	/**
	 * save a specific sale order
	 * @param saleOrder
	 */
	void save(SaleOrder saleOrder);

	/**
	 * return a list of previous sale orders.
	 * @return
	 */
	List<SaleOrder> findAll();
	

}
