package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productsService;
	
	@GetMapping("/")
	public List<ProductDTO> getProducts(){
		return productsService.getProducts();
	}
	
	@GetMapping("/{id}")
	public ProductDTO getProducts(@PathVariable Long id){
		return productsService.getProductsById(id);
	}
	
	@GetMapping("/getProd/{name}")
	public ProductDTO getProducts(@PathVariable String name){
		return productsService.getProductsByName(name);
	}
	
	@PostMapping("/")
	public String createProduct(@RequestBody ProductDTO productdto) {
		productsService.createProduct(productdto);
		return "Success";
	}
}

