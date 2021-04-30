package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductsRepo;
@Service
public class ProductService {

	@Autowired
	ProductsRepo productsRepo;
	
	
	public List<ProductDTO> getProducts(){
		//return productsRepo.findAll();
		return productsRepo.findAll().stream()
				.map(product->{
					ProductDTO productDto=new ProductDTO();
					BeanUtils.copyProperties(product,productDto);
					return productDto;
				}).collect(Collectors.toList());
	}
	
	
	public ProductDTO getProductsById(@PathVariable Long id){
		
		ProductDTO productDto=new ProductDTO();
		BeanUtils.copyProperties(productsRepo.findById(id).get(), productDto);
		return productDto;
	}
	
	public ProductDTO getProductsByName(String name) {
		ProductDTO productDto=new ProductDTO();
		BeanUtils.copyProperties(productsRepo.findByNameIgnoreCase(name).get(), productDto);
		return productDto;
		
	}


	public void createProduct(ProductDTO productdto) {
		Product product=new Product();
		BeanUtils.copyProperties(productdto, product);
		productsRepo.save(product);
	}
}
