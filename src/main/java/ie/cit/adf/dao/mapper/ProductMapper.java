package ie.cit.adf.dao.mapper;


import ie.cit.adf.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int i) throws SQLException {
		Product p = new Product();
		p.setId(rs.getString("id"));
		p.setSKU(rs.getInt("sku"));
		p.setName(rs.getString("name"));
		p.setDescription(rs.getString("description"));
		p.setPricePerUnit(rs.getDouble("pricePerUnit"));
		p.setStockLevel(rs.getInt("stocklevel"));
		return p;
	}

}