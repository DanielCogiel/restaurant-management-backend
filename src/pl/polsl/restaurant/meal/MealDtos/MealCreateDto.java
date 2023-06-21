package pl.polsl.restaurant.meal.MealDtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.meal.DietType;
import pl.polsl.restaurant.meal.Spiciness;


public class MealCreateDto {
	private String name;
	private Spiciness spiciness;
	private DietType dietType;
	private Set<Include> includes = new HashSet<Include>();
	
	public MealCreateDto() {}
	public MealCreateDto(String name, Spiciness spiciness, DietType dietType, Set<Include> includes) {
		this.setName(name);
		this.setSpiciness(spiciness);
		this.setDietType(dietType);
		this.setIncludes(includes);
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
	public Set<Include> getIncludes() {
		return includes;
	}
	public void setIncludes(Set<Include> includes) {
		this.includes = includes;
	}
	


}
