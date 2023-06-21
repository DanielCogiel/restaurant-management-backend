package pl.polsl.restaurant.ingredient.IngredientDtos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.polsl.restaurant.include.Include;

public class IngredientUpdateDto {
	private int id;
	private String name;
	private boolean isGluten;
	private Set<Include> includes = new HashSet<Include>();
	
	public IngredientUpdateDto(int id, String name, boolean isGluten, Set<Include> includes) {
		this.id = id;
		this.name = name;
		this.isGluten = isGluten;
		this.includes = includes;
		
		}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean isGluten() {
		return isGluten;
	}
	public Set<Include> getIncludes() {
		return includes;
	}
}
