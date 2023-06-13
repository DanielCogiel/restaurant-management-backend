package pl.polsl.restaurant.meal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pl.polsl.restaurant.ingredient.Ingredient;

@Entity
@Table(name="MEALS")
public class Meal implements Serializable {
	int id;
	String name;
	Spiciness spiciness;
	DietType dietType;
	Set<Ingredient> ingredients = new HashSet<Ingredient>();
	
	@ManyToMany
	@JoinTable(name="MEAL_INGR",
    joinColumns=
        @JoinColumn(name="MEAL_ID", referencedColumnName="ID"),
    inverseJoinColumns=
        @JoinColumn(name="INGR_ID", referencedColumnName="ID")
    )
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	@Id
	@GeneratedValue
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
	
}
