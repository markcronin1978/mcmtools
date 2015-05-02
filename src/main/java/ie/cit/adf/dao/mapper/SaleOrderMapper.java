package ie.cit.adf.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.adf.domain.SaleOrder;

import org.springframework.jdbc.core.RowMapper;

public class SaleOrderMapper implements RowMapper<SaleOrder> {
	
	/**
	 * here i am using RowMapper the retrieve and add product information to the database
	 */
	public SaleOrder mapRow(ResultSet rs, int i) throws SQLException {
		SaleOrder so = new SaleOrder();
		so.setId(rs.getString("id"));
		so.setCustomerEmail(rs.getString("customerEmail"));
		so.setProductSKU(rs.getInt("productSKU"));
		so.setQuantity(rs.getInt("quantity"));
		so.setCost(rs.getDouble("cost"));
		
		return so;
	}

}
