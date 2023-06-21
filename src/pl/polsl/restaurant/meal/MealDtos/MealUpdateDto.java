package pl.polsl.restaurant.meal.MealDtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.meal.DietType;
import pl.polsl.restaurant.meal.Spiciness;

public class MealUpdateDto {
	private int id;
	private String name;
	private Spiciness spiciness;
	private DietType dietType;
	private Set<Include> includes = new HashSet<Include>();
	
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
	public Set<Include> getIncludes() {
		return includes;
	}
}
