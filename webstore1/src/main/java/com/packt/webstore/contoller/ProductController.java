package com.packt.webstore.contoller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import com.sun.javafx.collections.MappingChange.Map;

@ComponentScan(basePackages = {"com.packt.webstore.domain.repository.impl","com.packt.webstore.service.impl"})
@Controller
@RequestMapping("market")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String list(Model model)
	{

		model.addAttribute("products", productService.getAllProducts());
		
		return "products";
	}
	
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/market/products";
	}
	
	@RequestMapping("/products/{category}")
	public String getProductByCategory(Model model,@PathVariable("category") String productCategory) {
		
		model.addAttribute("products", productService.getProductByCategory(productCategory));
		return "products";
	}
	
	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "params") java.util.Map<String, List<String>> filterParams,Model model) {
		
		model.addAttribute("products",productService.getProductsByFilter(filterParams));
		return "products";
	}
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId,Model model) {
		model.addAttribute("product",productService.getProductById(productId));
		return "product";
	}
	@RequestMapping("/products/{category}/{price}")
	public String FilterProducts(Model model,@PathVariable("category") String productCategory,@MatrixVariable(pathVar = "price") java.util.Map<String,List<Integer>> filterparams,@RequestParam("brand") String productbrand) {
		model.addAttribute("products", productService.FilterProducts(productCategory,filterparams, productbrand));
		return "products";
	}
	@RequestMapping(value="/products/add", method=RequestMethod.GET)
	public String getAddNewProductForm(Model model ) {
		Product newProduct=new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	@RequestMapping(value="/products/add",method=RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct")Product newProduct) {
		productService.addProduct(newProduct);
		return "redirect:/market/products";
	}
}
