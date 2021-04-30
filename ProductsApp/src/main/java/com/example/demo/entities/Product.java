package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.PackagePrivate;

@Entity(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	public Product(String name, String category, Integer price, Date expiryDate) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.expiryDate = expiryDate;
	}
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String category;
	private Integer price;
	private Date expiryDate;
	
}
