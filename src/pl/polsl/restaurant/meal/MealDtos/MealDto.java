package pl.polsl.restaurant.meal.MealDtos;

import java.util.HashSet;
import java.util.Set;

import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientDto;
import pl.polsl.restaurant.meal.DietType;
import pl.polsl.restaurant.meal.Spiciness;

public class MealDto {
	private int id;
	private String name;
	private Spiciness spiciness;
	private DietType dietType;
	private Set<IngredientDto> ingredients = new HashSet<IngredientDto>();
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Spiciness getSpiciness() {
		return spiciness;
	}
	public DietType getDietType() {
		return dietType;
	}
	public Set<IngredientDto> getIngredients() {
		return ingredients;
	}
}
