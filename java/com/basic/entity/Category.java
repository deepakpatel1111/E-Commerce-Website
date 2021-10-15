package com.basic.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)

	private Integer categoryId;
	private String categoryTitle;
	private String cztegoryDescription;
	
	@OneToMany(mappedBy = "category")
	List<Product> products=new ArrayList<>();

	public Category(Integer categoryId, String categoryTitle, String cztegoryDescription, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.cztegoryDescription = cztegoryDescription;
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryTitle, String cztegoryDescription, List<Product> products) {
		super();
		this.categoryTitle = categoryTitle;
		this.cztegoryDescription = cztegoryDescription;
		this.products = products;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCztegoryDescription() {
		return cztegoryDescription;
	}

	public void setCztegoryDescription(String cztegoryDescription) {
		this.cztegoryDescription = cztegoryDescription;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", cztegoryDescription="
				+ cztegoryDescription + ", products=" + products + "]";
	}
	
	
	
	

}
