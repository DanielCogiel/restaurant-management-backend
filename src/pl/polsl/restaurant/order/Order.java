package pl.polsl.restaurant.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID", referencedColumnName="id")
	public Customer getCustomer() {
		return customer;
	}	

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
