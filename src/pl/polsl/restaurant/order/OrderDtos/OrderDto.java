package pl.polsl.restaurant.order.OrderDtos;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.restaurant.customer.Customer;
import pl.polsl.restaurant.meal.Meal;

public class OrderDto {
	private int id;
	private List<Meal> meals = new ArrayList<Meal>();
	private int customerId;
	
	public OrderDto(){};
	public OrderDto(int id, List<Meal> meals, Customer customer){
		this.id = id;
		this.meals = meals;
		this.customerId = customer.getId();
	};
	
	public int getId() {
		return id;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public int getCustomerId() {
		return customerId;
	}	
}
