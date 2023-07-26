package pl.polsl.restaurant.meal.MealDtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientAmount;
import pl.polsl.restaurant.meal.DietType;
import pl.polsl.restaurant.meal.Spiciness;

public class MealUpdateDto {
	private String name;
	private Spiciness spiciness;
	private DietType dietType;
	private List<IngredientAmount> ingredients = new ArrayList<IngredientAmount>();
	
	public MealUpdateDto() {}
	public MealUpdateDto(String name, Spiciness spiciness, DietType dietType, List<IngredientAmount> ingredients) {
		this.name = name;
		this.spiciness = spiciness;
		this.dietType = dietType;
		this.ingredients = ingredients;
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
	public List<IngredientAmount> getIngredients() {
		return ingredients;
	}
}
