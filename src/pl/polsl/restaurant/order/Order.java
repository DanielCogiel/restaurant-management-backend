package pl.polsl.restaurant.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.polsl.restaurant.customer.Customer;
import pl.polsl.restaurant.meal.Meal;

@Entity
@Table(name="ORDERS")
public class Order implements Serializable {
	int id;
	List<Meal> meals = new ArrayList<Meal>();
	Customer customer;

	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
