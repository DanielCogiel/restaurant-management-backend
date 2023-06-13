package pl.polsl.restaurant.ingredient.IngredientDtos;

import java.util.HashSet;
import java.util.Set;

import pl.polsl.restaurant.ingredient.Unit;
import pl.polsl.restaurant.meal.MealDtos.MealDto;

public class IngredientDto {
	private int id;
	private String name;
	private boolean isGluten;
	private Set<MealDto> meals = new HashSet<MealDto>();
	private double amount;
	private Unit unit;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean isGluten() {
		return isGluten;
	}
	public Set<MealDto> getMeals() {
		return meals;
	}
	public double getAmount() {
		return amount;
	}
	public Unit getUnit() {
		return unit;
	}
}
