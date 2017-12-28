package org.spring.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private double price;
	private int quantity ;
	private boolean instock;
	private int cid;
	private int sid;
	private String image;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid" , updatable = false, insertable = false, nullable = false)
	private Category category;
	 	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sid" , updatable = false, insertable = false, nullable = false)
	private Supplier supplier;



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isInstock() {
		return instock;
	}
	public void setInstock(boolean instock) {
		this.instock = instock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
