package pl.polsl.restaurant.ingredient.IngredientDtos;

public class IngredientCreateDto {
	private String name;
	private boolean isGluten;
	
	public IngredientCreateDto() {};
	public IngredientCreateDto(String name, boolean isGluten) {
		this.setName(name);
		this.setGluten(isGluten);
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
