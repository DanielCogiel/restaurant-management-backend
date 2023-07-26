package pl.polsl.restaurant.order.OrderDtos;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.restaurant.customer.Customer;
import pl.polsl.restaurant.meal.Meal;

public class OrderUpdateDto {
	private List<Integer> meals = new ArrayList<Integer>();
	private int customer;
	
	public OrderUpdateDto() {}
	public OrderUpdateDto(int id, List<Integer> meals, int customer) {
		this.meals = meals;
		this.customer = customer;
	}

	public List<Integer> getMeals() {
		return meals;
	}

	public int getCustomer() {
		return customer;
	}
	

}
