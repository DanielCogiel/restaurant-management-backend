package pl.polsl.restaurant.order.OrderDtos;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.restaurant.customer.Customer;
import pl.polsl.restaurant.meal.Meal;
import pl.polsl.restaurant.meal.MealDtos.MealDtoNoIncludes;

public class OrderDto {
	private int id;
	private List<MealDtoNoIncludes> meals = new ArrayList<MealDtoNoIncludes>();
	private int customerId;
	
	public OrderDto(){};
	public OrderDto(int id, List<Meal> meals, Customer customer){
		this.id = id;
		for (Meal meal : meals) {
			this.meals.add(new MealDtoNoIncludes(meal.getId(), meal.getName(), meal.getSpiciness(), meal.getDietType()));
		}
		this.customerId = customer.getId();
	};
	
	public int getId() {
		return id;
	}
	public List<MealDtoNoIncludes> getMeals() {
		return meals;
	}
	public int getCustomerId() {
		return customerId;
	}
}
