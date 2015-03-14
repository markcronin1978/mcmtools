package ie.cit.adf.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.dao.mapper.ProductMapper;
import ie.cit.adf.domain.Product;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProductRepository implements ProductRepository {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcProductRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Product> findAll() {
		String sql = "SELECT * FROM product";                        
		return jdbcTemplate.query(sql, new ProductMapper());
	}

}
