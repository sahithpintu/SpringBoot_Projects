package com.techprimers.springboot.onetomany.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {

	@Id
    @Column(name = "product_id")//@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_price")
	private Integer productPrice;
	
	/*
	 * @Column(name="customer_id") private Integer customerId;
	 */

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(Integer productId, String productName, Integer productPrice, Integer customerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		//this.customerId = customerId;
	}
	
	

	/*
	 * @Override public String toString() { return "Products [productId=" +
	 * productId + ", productName=" + productName + ", productPrice=" + productPrice
	 * + ", customerId=" + customerId + "]"; }
	 */
	

	public Integer getProductId() {
		return productId;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	/*
	 * public Integer getCustomerId() { return customerId; }
	 * 
	 * public void setCustomerId(Integer customerId) { this.customerId = customerId;
	 * }
	 */
	
	
}
