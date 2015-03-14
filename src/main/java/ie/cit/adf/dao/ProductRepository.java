package ie.cit.adf.dao;


import ie.cit.adf.domain.Product;

import java.util.List;

public interface ProductRepository {

	List<Product> findAll();
}
