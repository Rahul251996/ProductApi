package com.netset.bean;

public class Product {

	public static final String CRITERIA_NAME = "NAME";
	public static final String CRITERIA_COLOR = "COLOR";
	public static final String CRITERIA_CATAGORY = "CATAGORY";
	private String name;
	private String color;
	private int price;
	private String catagory;
	private byte[] image;
	
	private ProductSearchCriteriaHelper productSearchCriteria;

	
	
	public Product() {
	
	}

	public Product(String name, String color, int price, String catagory, byte[] image) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.catagory = catagory;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ProductSearchCriteriaHelper getProductSearchCriteria() {
		return productSearchCriteria;
	}

	public void setProductSearchCriteria(ProductSearchCriteriaHelper productSearchCriteria) {
		this.productSearchCriteria = productSearchCriteria;
	}
	
	
}
