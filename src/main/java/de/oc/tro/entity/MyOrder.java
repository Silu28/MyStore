package de.oc.tro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_fk")
	private Product product;

	public MyOrder() {
		super();
	}

	public MyOrder(String description, int quantity, Product product) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description
				+ ", quantity=" + quantity + "]";
	}

}
