package com.tacademy.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_product")
@Getter @Setter
@ToString
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=30)
	private String name;
	
	@Column
	private Double price;
	
	@Column(name = "image_file_name", length=100)
	private String imageFileName;
	
	@Column
	private String color;
	
	@Lob
	private String desription;	
}
