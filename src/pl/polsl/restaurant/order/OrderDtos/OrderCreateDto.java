package pl.polsl.restaurant.order.OrderDtos;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.restaurant.customer.Customer;
import pl.polsl.restaurant.customer.customerDtos.CustomerDto;
import pl.polsl.restaurant.meal.Meal;
import pl.polsl.restaurant.meal.MealDtos.MealDto;

public class OrderCreateDto {
	private List<Integer> meals = new ArrayList<Integer>();
	private int userId;
	
	public OrderCreateDto() {}
	public OrderCreateDto(List<Integer> meals, int userId) {
		this.setMeals(meals);
		this.setUserId(userId);
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setMeals(List<Integer> meals) {
		this.meals = meals;
	}
	
	public List<Integer> getMeals() {
		return meals;
	}

}
