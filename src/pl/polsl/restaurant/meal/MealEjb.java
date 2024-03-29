package pl.polsl.restaurant.meal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.ingredient.Ingredient;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientAmount;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientAmountName;
import pl.polsl.restaurant.meal.MealDtos.MealDto;
import pl.polsl.restaurant.order.Order;

@Stateless
public class MealEjb {
	
	@PersistenceContext(name="restaurant") EntityManager manager;
	
	public void create(Meal meal, List<IngredientAmount> ingredients) {
		manager.persist(meal);
		
		for (IngredientAmount ingredientData : ingredients) {
			Ingredient ingredient = this.manager.find(Ingredient.class, ingredientData.getIngredientId());
			Include include = new Include();
			include.setAmount(ingredientData.getAmount());
			include.setUnit(ingredientData.getUnit());
			include.setIngredient(ingredient);
			include.setMeal(meal);
			this.manager.merge(include);
		}
	}
	public List<MealDto> get() {
		List<Meal> meals = this
				.manager
				.createQuery("select distinct c from Meal c left join fetch c.includes", Meal.class)
				.getResultList();
		List<MealDto> mealsData = new ArrayList<MealDto>();
		for (Meal meal : meals) {
			List<Include> includes = meal.getIncludes();
			List<IngredientAmountName> ingredients = new ArrayList<IngredientAmountName>();
			for (Include include : includes) {
				ingredients.add(new IngredientAmountName(include.getIngredient().getName(), 
						include.getAmount(), include.getUnit()));
			}
			mealsData.add(new MealDto(meal.getId(), meal.getName(), meal.getSpiciness(), meal.getDietType(), ingredients));
		}
		return mealsData;
	}
	public Meal find(int id) {
		Meal meal = (Meal) this
				.manager
				.createQuery("select distinct c from Meal c left join fetch c.includes o where c.id = :id")
				.setParameter("id", id)
				.getSingleResult();
		return meal;
	}
	public void update(Meal meal) {
		 manager.merge(meal);
	}
	public void delete(Meal meal) {
		manager.remove(manager.contains(meal) ? meal : manager.merge(meal));
	}
}
