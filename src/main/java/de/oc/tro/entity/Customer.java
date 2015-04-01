package de.oc.tro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
   // ======================================
   // =             Attributes             =
   // ======================================

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "street")
	private String street;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "country_fk")
	private Country country;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "city_fk")
	private City city;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "purchase_order_fk")
	private Set<Purchase_order> purchase_order = new HashSet<Purchase_order>();
	
	// ======================================
	// =             Constructors           =
	// ======================================
	
	public Customer() {
		super();
	}

	public Customer(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Customer(String firstname, String lastname, String street,
			Country country, City city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.country = country;
		this.city = city;
	}
	
	// ======================================
	// =             Getter/Setter          =
	// ======================================

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<Purchase_order> getPurchase_order() {
		return purchase_order;
	}

	public void setPurchase_order(Set<Purchase_order> purchase_order) {
		this.purchase_order = purchase_order;
	}

	public int getId() {
		return id;
	}

	public void addPurchase_order(Purchase_order purchase_order) {
		this.purchase_order.add(purchase_order);
	}

	// ======================================
	// =             toString()             =
	// ======================================
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", street=" + street
				+ ", country=" + country+ ", purchase_order=" + purchase_order + ", city=" + city + "]";
	}
	
}
