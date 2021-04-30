package com.example.demo;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductsRepo;

@SpringBootApplication
public class ProductsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsAppApplication.class, args);
	}
	
	@Autowired
	ProductsRepo productRepo;
	
	
	@PostConstruct
	private void insertdata() {
		productRepo.save(new Product("Samsung","Mobile Phones",10000,new Date()));
		productRepo.save(new Product("LG","Fridge",25000,new Date()));
	}
	

}
