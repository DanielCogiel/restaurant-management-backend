package pl.polsl.restaurant.order.OrderDtos;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.restaurant.customer.customerDtos.CustomerDto;
import pl.polsl.restaurant.meal.MealDtos.MealDto;

public class OrderDto {
	private int id;
	private List<MealDto> meals = new ArrayList<MealDto>();
	private CustomerDto customer;
	
	public int getId() {
		return id;
	}
	public List<MealDto> getMeals() {
		return meals;
	}
	public CustomerDto getCustomer() {
		return customer;
	}	
}
