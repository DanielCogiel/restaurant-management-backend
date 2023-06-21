package pl.polsl.restaurant.meal;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import pl.polsl.restaurant.meal.MealDtos.MealCreateDto;
import pl.polsl.restaurant.meal.MealDtos.MealDto;
import pl.polsl.restaurant.meal.MealDtos.MealUpdateDto;


@Local
public interface MealRestInterface {
	public abstract MealDto create(MealCreateDto createMeal);
	public abstract MealDto find(int id); 
	public abstract ArrayList<MealDto> get();
	public abstract Response update(int id, MealUpdateDto updatedMeal);
	public abstract Response delete(int id);
	
}