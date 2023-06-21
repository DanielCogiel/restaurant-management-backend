package pl.polsl.restaurant.ingredient.IngredientDtos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.polsl.restaurant.include.Include;

public class IngredientCreateDto {

	private String name;
	private boolean isGluten;
	private Set<Include> includes = new HashSet<Include>();
	
	public IngredientCreateDto() {};
	public IngredientCreateDto(String name, boolean isGluten, Set<Include> includes) {
		this.setName(name);
		this.setGluten(isGluten);
		this.setIncludes(includes);
		
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
	public Set<Include> getIncludes() {
		return includes;
	}
	public void setIncludes(Set<Include> includes) {
		this.includes = includes;
	}

}
