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

	/**
	 * query's database for a list of products
	 */
	public List<Product> findAll() {
		String sql = "SELECT * FROM product";                        
		return jdbcTemplate.query(sql, new ProductMapper());
	}

	/**
	 * query's database for a product by SKU number and returns
	 * a product object
	 */
	public Product getBySKU(int SKU) {
		String sql = "SELECT * From product WHERE sku = ?";		
		return jdbcTemplate.queryForObject(sql, new ProductMapper(), SKU);  
	}
	
	/**
	 * checks to see if product being passed in is new of existing product 
	 * that is being updated. Here i call the searchBySku function which
	 * will either return null, if the product doesn't exist or the product
	 * information if it does exist
	 */
	public void save(Product product) {
		if (searchBySku(product.getSKU()) == null) {
			add(product);
		} else {
			update(product);
		}
	}
	
	/**
	 * searches database to check for existing SKU number, if not present catches SQL Exception and returns null
	 * @param SKU
	 * @return null / product
	 */
	public Product searchBySku(int SKU) {
		try {
			String sql = "SELECT * FROM product WHERE sku = ?";
			return jdbcTemplate.queryForObject(sql, new ProductMapper(), SKU);
		} catch (DataAccessException e) {

		}
		return null;
	}
	
	/**
	 * add new product information
	 * @param product
	 */
	public void add(Product product) {
		jdbcTemplate  
				.update("INSERT INTO product (id, sku, name, description, priceperunit, stocklevel)"
						+ " VALUES (?, ?, ?, ?, ?, ?)", product.getId(), 
						product.getSKU(), product.getName(), product.getDescription(), 
						product.getPricePerUnit(),product.getStockLevel());

	}

	/**
	 * update existing product information
	 * @param product
	 */
	private void update(Product product) {
		jdbcTemplate
				.update("UPDATE product SET id= ?, name = ?, description = ?, priceperunit = ?, stocklevel = ?"
						+ " WHERE sku = ?", product.getId(), product.getName(),
						product.getDescription(),product.getPricePerUnit(), 
						product.getStockLevel(), product.getSKU());
	}
	
	/**
	 * return quantity of selected item for purchase
	 */
	public int getQuantityBySKU(int productSKU) {
		String sql = "SELECT * FROM product WHERE sku = ?";
		Product quantity = jdbcTemplate.queryForObject(sql, new ProductMapper(),productSKU);
		return quantity.getStockLevel();
		
	}

	/**
	 * return a list of previously purchased products.
	 */
	public List<Product> purchaseHist(String name) {
		String sql = "SELECT * From product WHERE email = ?";	
		return jdbcTemplate.query(sql, new ProductMapper(), name);
	}

}
