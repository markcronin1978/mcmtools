package ie.cit.adf.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.adf.dao.SaleOrderRepository;
import ie.cit.adf.dao.mapper.ProductMapper;
import ie.cit.adf.dao.mapper.SaleOrderMapper;
import ie.cit.adf.domain.Product;
import ie.cit.adf.domain.SaleOrder;

@Repository
public class JdbcSaleOrderRepository implements SaleOrderRepository {
	
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSaleOrderRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * return a list of previously purchased products.
	 */
	public List<SaleOrder> purchaseHist(String name) {
		String sql = "SELECT * From product WHERE email = ?";	
		return jdbcTemplate.query(sql, new SaleOrderMapper(), name);

	}

	public void save(SaleOrder saleOrder) {
		jdbcTemplate
			.update("INSERT INTO saleorder (id, customeremail, productsku, quantity, cost)"
							+ " VALUES (?, ?, ?, ?, ?)", saleOrder.getId(), 
							saleOrder.getCustomerEmail(), saleOrder.getProductSKU(), saleOrder.getQuantity(), 
							saleOrder.getCost());
		}
		
}	


