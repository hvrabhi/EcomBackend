package org.spring.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Supplier {

	@Id
	@GeneratedValue
	private int sid;
	private String suppliername,supplieraddress;
	@OneToMany(targetEntity=Product.class, fetch = FetchType.EAGER, mappedBy = "supplier", cascade = CascadeType.ALL)
	 private Set<Product> products = new HashSet<Product>(0);
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	public int getId() {
		return sid;
	}
	public void setId(int id) {
		this.sid = sid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
}
