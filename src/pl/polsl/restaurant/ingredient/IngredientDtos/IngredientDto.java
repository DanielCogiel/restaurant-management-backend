package pl.polsl.restaurant.ingredient.IngredientDtos;

public class IngredientDto {
	private int id;
	private String name;
	private boolean isGluten;
	
	public IngredientDto() {};
	public IngredientDto(int id, String name, boolean isGluten) {
		this.id = id;
		this.name = name;
		this.isGluten = isGluten;
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
}
