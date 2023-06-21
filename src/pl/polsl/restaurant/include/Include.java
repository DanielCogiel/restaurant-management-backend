package pl.polsl.restaurant.include;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.polsl.restaurant.ingredient.Ingredient;
import pl.polsl.restaurant.meal.Meal;


@Entity
@Table(name="INCLUDE")
public class Include implements Serializable {
	int id;
	Meal meal;
	Ingredient ingredient;
	double amount;
	Unit unit;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	@ManyToOne(mappedBy="includes")
	public Set<Meal> getMeals() {
		return meals;
	}
	public void setMeals(Set<Meal> meals) {
		this.meals = meals;
	}
	
	@ManyToOne(mappedBy="includes")
	public Set<Ingredient> getIndredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
