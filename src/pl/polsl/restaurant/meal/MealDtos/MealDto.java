package pl.polsl.restaurant.meal.MealDtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.polsl.restaurant.customer.Customer;
import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.ingredient.Ingredient;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientAmount;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientAmountName;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientDto;
import pl.polsl.restaurant.meal.DietType;
import pl.polsl.restaurant.meal.Meal;
import pl.polsl.restaurant.meal.Spiciness;

public class MealDto {
	private int id;
	private String name;
	private Spiciness spiciness;
	private DietType dietType;
	private List<IngredientAmountName> ingredients = new ArrayList<IngredientAmountName>();
	private List<Include> includes = new ArrayList<Include>();
	
	public MealDto(){};
	public MealDto(int id, String name, Spiciness spiciness, DietType dietType, List<IngredientAmountName> ingredients){
		this.id = id;
		this.name = name;
		this.spiciness = spiciness;
		this.dietType = dietType;
		this.ingredients = ingredients;
	};
	
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
	public List<IngredientAmountName> getIngredients() {
		return ingredients;
	}
	public List<Include> getIncludes() {
		return includes;
		
	}
	public void setIngredients(List<IngredientAmountName> ingredients) {
		this.ingredients = ingredients;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpiciness(Spiciness spiciness) {
		this.spiciness = spiciness;
	}
	public void setDietType(DietType dietType) {
		this.dietType = dietType;
	}
	public void setIncludes(List<Include> includes) {
		this.includes = includes;
		
	}

}
