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
	@ManyToOne
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
	@ManyToOne
	public Ingredient getIndredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
