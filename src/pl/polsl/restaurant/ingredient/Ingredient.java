package pl.polsl.restaurant.ingredient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.meal.Meal;


@Entity
@Table(name="INGREDIENTS")
public class Ingredient implements Serializable {
	int id;
	String name;
	boolean isGluten;
	Set<Include> includes = new HashSet<Include>();

	@OneToMany(mappedBy="ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Include> getIncludes() {
		return includes;
	}
	public void setIncludes(Set<Include> includes) {
		this.includes = includes;
	}
	@Id
	@GeneratedValue
	@Column(name="INGREDIENT_ID")
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
