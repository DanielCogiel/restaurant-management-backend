package pl.polsl.restaurant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="INGREDIENTS")
public class Ingredient implements Serializable {
	int id;
	String name;
	boolean isGluten;
	Set<Meal> meals = new HashSet<Meal>();
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
	@ManyToMany(mappedBy="ingredients")
	public Set<Meal> getMeals() {
		return meals;
	}
	public void setMeals(Set<Meal> meals) {
		this.meals = meals;
	}
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGluten() {
		return isGluten;
	}
	public void setGluten(boolean isGluten) {
		this.isGluten = isGluten;
	}
}
