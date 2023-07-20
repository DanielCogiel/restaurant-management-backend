package pl.polsl.restaurant.meal.MealDtos;

import pl.polsl.restaurant.meal.DietType;
import pl.polsl.restaurant.meal.Spiciness;

public class MealDtoNoIncludes {
	private int id;
	private String name;
	private Spiciness spiciness;
	private DietType dietType;
	
	public MealDtoNoIncludes(int id, String name, Spiciness spiciness, DietType dietType) {
		this.id = id;
		this.name = name;
		this.spiciness = spiciness;
		this.dietType = dietType;
	}
	
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
}
