package ie.cit.adf.dao;


import ie.cit.adf.domain.SaleOrder;

import java.util.List;

public interface SaleOrderRepository {


	//List<SaleOrder> purchaseHist(String name);

	void save(SaleOrder saleOrder);

	List<SaleOrder> findAll();
	

}
