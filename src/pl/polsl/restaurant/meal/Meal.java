package pl.polsl.restaurant.meal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.ingredient.Ingredient;
import pl.polsl.restaurant.meal.MealDtos.MealDto;
import pl.polsl.restaurant.order.Order;

@Entity
@Table(name="MEALS")
public class Meal implements Serializable {
	int id;
	String name;
	Spiciness spiciness;
	DietType dietType;
	List<Include> includes = new ArrayList<Include>();
	Order order;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID", referencedColumnName="ORDER_ID")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@OneToMany(mappedBy="meal")
	public List<Include> getIncludes() {
		return includes;
	}
	public void setIncludes(List<Include> includes) {
		this.includes = includes;
	}
	
	@Id
	@GeneratedValue
	@Column(name="MEAL_ID")
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
	
	public MealDto toDTO() {
		MealDto dto = new MealDto();
        dto.setName(name);
        dto.setSpiciness(spiciness);
        dto.setDietType(dietType);
        dto.setIncludes(includes);

        return dto;
    }
}
