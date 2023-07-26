package pl.polsl.restaurant.ingredient.IngredientDtos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.polsl.restaurant.include.Include;

public class IngredientUpdateDto {
	private int id;
	private String name;
	private boolean gluten;
	private Set<Include> includes = new HashSet<Include>();
	
	public IngredientUpdateDto() {}
	public IngredientUpdateDto(int id, String name, boolean gluten, Set<Include> includes) {
		this.id = id;
		this.name = name;
		this.gluten = gluten;
		this.includes = includes;
		
		}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean getGluten() {
		return gluten;
	}
	public Set<Include> getIncludes() {
		return includes;
	}
}
