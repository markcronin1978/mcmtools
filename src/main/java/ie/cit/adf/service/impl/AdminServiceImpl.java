package ie.cit.adf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.dao.SaleOrderRepository;
import ie.cit.adf.domain.SaleOrder;
import ie.cit.adf.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	private SaleOrderRepository saleOrderRepository;
	
	@Autowired
	public AdminServiceImpl (SaleOrderRepository saleOrderRepository){
		this.saleOrderRepository = saleOrderRepository;
	}
	
	/**
	 * return a list of SaleOrders
	 */
	public List<SaleOrder> findAll() {
		return saleOrderRepository.findAll();
	}

}
