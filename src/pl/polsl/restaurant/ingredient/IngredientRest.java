package pl.polsl.restaurant.ingredient;

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
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientDto;
import pl.polsl.restaurant.ingredient.IngredientDtos.IngredientUpdateDto;

@Path(value="ingredients")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class IngredientRest implements IngredientRestInterface {
	@EJB
	IngredientEjb ingredientBean;
	
	@Override
	@POST
	public Response create(IngredientCreateDto createIngredient) {
		try {
			Ingredient ingredient = new Ingredient();
			ingredient.setName(createIngredient.getName());
			ingredient.setGluten(createIngredient.isGluten());
			this.ingredientBean.create(ingredient);
			
			return Response.ok().entity("{\"message\":\"Sk�adnik zosta� pomy�lnie utworzony.\"}").build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"message\":\"Nie uda�o si� utworzy� sk�adnika.\"}").build();
		}
	}
	
	@Override
	@GET
	public ArrayList<IngredientDto> get() {
		
		List<Ingredient> ingredientEntities = this.ingredientBean.get();
		ArrayList<IngredientDto> ingredients = new ArrayList<IngredientDto>();
		
		for (Ingredient ingredient : ingredientEntities) {
			ingredients.add(new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.isGluten()));
		}
		
		return ingredients;
	}
	
	@Override
	@GET
	@Path(value = "/{id}")
	public IngredientDto find(@PathParam("id") int id) {
		Ingredient ingredient = this.ingredientBean.find(id);
		return new IngredientDto(ingredient.getId(), ingredient.getName(), ingredient.isGluten());
	}
	
	@Override
	@PUT
	@Path(value = "/{id}/edit")
	public Response update(@PathParam("id") int id, IngredientUpdateDto updatedIngredient) {
		try {
			Ingredient ingredient = ingredientBean.find(id);
        
			if (updatedIngredient.getName() != null) {
				ingredient.setName(updatedIngredient.getName());
			}
			ingredient.setGluten(updatedIngredient.getGluten());            
        	ingredientBean.update(ingredient);
            
            return Response.ok().entity("{\"message\":\"Sk�adnik zosta� zaktualizowany.\"}").build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"message\":\"Sk�adnik o podanym identyfikatorze nie zosta� znaleziony.\"}").build();
        }
    }

	@DELETE
	@Path(value = "/{id}/delete")
	public Response delete(@PathParam("id") int id){
        try {
        	ingredientBean.delete(id);
            return Response.ok().entity("{\"message\":\"Sk�adnik zosta� usuni�ty.\"}").build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"message\":\"Sk�adnik o podanym identyfikatorze nie zosta� znaleziony.\"}").build();
        }
	}
 }
