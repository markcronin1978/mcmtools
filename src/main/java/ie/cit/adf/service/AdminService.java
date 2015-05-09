package ie.cit.adf.service;

import ie.cit.adf.domain.SaleOrder;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public interface AdminService {

	/**
	 * Return a list of SaleOrders
	 * @return
	 */
	List<SaleOrder> findAll();

}
