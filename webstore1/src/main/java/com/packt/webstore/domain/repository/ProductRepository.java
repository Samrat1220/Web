package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Product;
import com.sun.javafx.collections.MappingChange.Map;

public interface ProductRepository {

	List<Product>getAllProducts();
	
	void updateStock(String productId,long noOfUnits);

	List<Product>getProductByCategory(String category);
	
	List<Product>getProductsByFilter(java.util.Map<String,List<String>>filterParams);
	
	Product getProductById(String productID);
	
	List<Product> FilterProducts(String category,java.util.Map<String, List<Integer>>filterparams,String brand);
	
	void addProduct(Product product);
}
