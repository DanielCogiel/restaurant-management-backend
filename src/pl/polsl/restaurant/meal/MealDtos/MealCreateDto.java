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
	private int orderId;
	private List<Integer> includeIds = new ArrayList<Integer>();
	
	public MealCreateDto() {}
	public MealCreateDto(String name, Spiciness spiciness, DietType dietType, int orderId, List<Integer> includeIds) {
		this.setName(name);
		this.setSpiciness(spiciness);
		this.setDietType(dietType);
		this.setOrderId(orderId);
		this.setIncludeIds(includeIds);
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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Integer> getIncludeIds() {
		return includeIds;
	}
	public void setIncludeIds(List<Integer> includeIds) {
		this.includeIds = includeIds;
	}
}
