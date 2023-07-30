package pl.polsl.restaurant.ingredient;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientCreateDto;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientDto;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientUpdateDto;


@Local
public interface IngredientRestInterface {
	public abstract Response create(IngredientCreateDto createIngredient);
	public abstract IngredientDto find(int id); 
	public abstract ArrayList<IngredientDto> get();
	public abstract Response update(int id, IngredientUpdateDto updatedIngredient);
	public abstract Response delete(int id);
	
}