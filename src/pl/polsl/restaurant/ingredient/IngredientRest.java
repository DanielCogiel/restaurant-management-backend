package pl.polsl.restaurant.meal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientCreateDto;
import pl.polsl.restaurant.meal.MealDtos.MealCreateDto;
import pl.polsl.restaurant.meal.MealDtos.MealDto;
import pl.polsl.restaurant.meal.MealDtos.MealUpdateDto;

@Path(value="meals")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class IngredientRest implements IngredientRestInterface {
	
	
	@EJB
	IngredientEjb ingredientBean;
	
	@Override
	@POST
	public IngredientDto create(IngredientCreateDto createIngredient) {
		Ingredient ingredient = new Ingredient();
		ingredient.setName(createIngredient.getName());
		ingredient.setGluten(createIngredient.isGluten());
		ingredient.setIncludes(createIngredient.getIncludes());
		
		this.ingredientBean.create(ingredient);
		
		IngredientDto ingredientData = new IngredientDto(ingredient.getId(),
				ingredient.getName(), ingredient.isGluten(), ingredient.getIncludes());
		return ingredientData;
	}
	
	@Override
	@GET
	public ArrayList<IngredientDto> get() {
		
		List<Ingredient> ingredientEntities = this.ingredientBean.get();
		ArrayList<IngredientDto> ingredients = new ArrayList<IngredientDto>();
		
		for (Ingredient ingredient : ingredientEntities) {
			ingredients.add(new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.isGluten(), ingredient.getIncludes()));
		}
		
		return ingredients;
	}
	
	@Override
	@GET
	@Path(value = "/{id}")
	public IngredientDto find(@PathParam("id") int id) {
		Ingredient ingredient = this.ingredientBean.find(id);
		return new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.isGluten(),ingredient.getIncludes());
	}
	
	@Override
	@PUT
	@Path(value = "/{id}/edit")
	public Response update(@PathParam("id") int id, IngredientUpdateDto updatedIngredient) {
        
		Ingredient ingredient = ingredientBean.find(id);
        if (ingredient != null) {

        	ingredient.setId(updatedIngredient.getId());
        	ingredient.setName(updatedIngredient.getName());
        	ingredient.setGluten(updatedIngredient.isGluten());
        	ingredient.setIncludes(updatedIngredient.getIncludes());
            

        	ingredientBean.update(ingredient);
            
            return Response.ok().entity("{\"message\":\"Sk³adnik zosta³ zaktualizowany.\"}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Sk³adnik o podanym identyfikatorze nie zosta³ znaleziony.\"}").build();
        }
    }

	@DELETE
	@Path(value = "/{id}/delete")
	public Response delete(@PathParam("id") int id){
		Ingredient ingredient = ingredientBean.find(id);
        if (ingredient != null) {
        	ingredientBean.delete(ingredient);
            
            return Response.ok().entity("{\"message\":\"Sk³adnik zosta³ usuniêty.\"}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Sk³adnik o podanym identyfikatorze nie zosta³ znaleziony.\"}").build();
        }
	}
	

 }
