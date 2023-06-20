package pl.polsl.restaurant.order.OrderDtos;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.restaurant.customer.Customer;
import pl.polsl.restaurant.customer.customerDtos.CustomerDto;
import pl.polsl.restaurant.meal.Meal;
import pl.polsl.restaurant.meal.MealDtos.MealDto;

public class OrderCreateDto {
	private List<Meal> meals = new ArrayList<Meal>();
	private Customer customer;
	
	public OrderCreateDto() {}
	public OrderCreateDto(List<Meal> meals, Customer customer) {
		this.setMeals(meals);
		this.setCustomer(customer);
	}
	
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public Customer getCustomer() {
		return customer;
	}

}
