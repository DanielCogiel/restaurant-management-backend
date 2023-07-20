package pl.polsl.restaurant.include;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="MEAL_ID", referencedColumnName="MEAL_ID")
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
	@ManyToOne
	@JoinColumn(name="INGREDIENT_ID", referencedColumnName="INGREDIENT_ID")
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	@Id
	@GeneratedValue
	@Column(name="INCLUDE_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
