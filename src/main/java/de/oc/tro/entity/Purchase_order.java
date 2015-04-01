package de.oc.tro.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Purchase_order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_fk")
	private Set<MyOrder> order = new HashSet<MyOrder>();

	public Purchase_order() {
		super();
	}

	public Purchase_order(Date date, Set<MyOrder> order) {
		super();
		this.date = date;
		this.order = order;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<MyOrder> getOrder() {
		return order;
	}

	public void setOrder(Set<MyOrder> order) {
		this.order = order;
	}

	public void addOrder(MyOrder order) {
		this.order.add(order);
	}

	@Override
	public String toString() {
		return "Purchase_order [id=" + id + ", date=" + date + ", order="
				+ order + "]";
	}

}
