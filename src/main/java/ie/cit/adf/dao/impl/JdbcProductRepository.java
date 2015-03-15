package ie.cit.adf.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import ie.cit.adf.dao.ProductRepository;
import ie.cit.adf.dao.mapper.ProductMapper;
import ie.cit.adf.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProductRepository implements ProductRepository {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcProductRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//list all products and return information in a list
	public List<Product> findAll() {
		String sql = "SELECT * FROM product";                        
		return jdbcTemplate.query(sql, new ProductMapper());
	}

	//find a product by a SKU number and return an object
	public Product getBySKU(int SKU) {
		String sql = "SELECT * From product WHERE sku = ?";		
		return jdbcTemplate.queryForObject(sql, new ProductMapper(), SKU);  
	}
	
	/*find a product by the ID number.
	public Product getById(String Id){
		String sql = "SELECT * From product WHERE Id = ?";
		return jdbcTemplate.queryForObject(sql, new ProductMapper(), Id);
	}*/

	//checks to see if new or update product action is required
	public void save(Product product) {
		if (searchBySku(product.getSKU()) == null) {
			System.out.println("SQL CHECK FOR EXISTING SKU");
			add(product);
		} else {
			update(product);
		}
	}
	
	//searches database to check for existing SKU number, if not present catches SQL Exception and returns null
	public Product searchBySku(int SKU) {
		try {
			String sql = "SELECT * FROM product WHERE sku = ?";
			return jdbcTemplate.queryForObject(sql, new ProductMapper(), SKU);
		} catch (DataAccessException e) {

		}
		return null;
	}
	
	//insert new product information
	public void add(Product product) {
		jdbcTemplate  
				.update("INSERT INTO product (id, sku, name, description, priceperunit, stocklevel)"
						+ " VALUES (?, ?, ?, ?, ?, ?)", product.getId(), 
						product.getSKU(), product.getName(), product.getDescription(), 
						product.getPricePerUnit(),product.getStockLevel());

	}

	//update new product information
	private void update(Product product) {
		jdbcTemplate
				.update("UPDATE product SET id= ?, name = ?, description = ?, priceperunit = ?, stocklevel = ?"
						+ " WHERE sku = ?", product.getId(), product.getName(),
						product.getDescription(),product.getPricePerUnit(), 
						product.getStockLevel(), product.getSKU());
	}

}
