package pl.polsl.restaurant.meal.MealDtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.meal.DietType;
import pl.polsl.restaurant.meal.Meal;
import pl.polsl.restaurant.meal.Spiciness;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientAmount;


public class MealCreateDto {
	private String name;
	private Spiciness spiciness;
	private DietType dietType;
	private List<IngredientAmount> ingredients = new ArrayList<IngredientAmount>();
	private List<Include> includes = new ArrayList<Include>();
	
	public MealCreateDto() {}
	public MealCreateDto(String name, Spiciness spiciness, DietType dietType, ArrayList<IngredientAmount> ingredients) {
		this.name = name;
		this.spiciness = spiciness;
		this.dietType = dietType;
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Spiciness getSpiciness() {
		return spiciness;
	}
	public void setSpiciness(Spiciness spiciness) {
		this.spiciness = spiciness;
	}
	public DietType getDietType() {
		return dietType;
	}
	public void setDietType(DietType dietType) {
		this.dietType = dietType;
	}
	public void setIncludes(List<Include> includes) {
		this.includes = includes;
		
	}
	public List<Include> getIncludes() {
		return includes;
	}
	public List<IngredientAmount> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<IngredientAmount> ingredients) {
		this.ingredients = ingredients;
	}
	

}
