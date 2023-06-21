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

import pl.polsl.restaurant.meal.MealDtos.MealCreateDto;
import pl.polsl.restaurant.meal.MealDtos.MealDto;
import pl.polsl.restaurant.meal.MealDtos.MealUpdateDto;

@Path(value="meals")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MealRest implements MealRestInterface {
	
	
	@EJB
	MealEjb mealBean;
	
	@Override
	@POST
	public MealDto create(MealCreateDto createMeal) {
		Meal meal = new Meal();
		meal.setName(createMeal.getName());
		meal.setSpiciness(createMeal.getSpiciness());
		meal.setDietType(createMeal.getDietType());
		meal.setIncludes(createMeal.getIncludes());
		
		this.mealBean.create(meal);
		
		MealDto mealData = new MealDto(meal.getId(),
				meal.getName(), meal.getSpiciness(), meal.getDietType(), meal.getIncludes());
		return mealData;
	}
	
	@Override
	@GET
	public ArrayList<MealDto> get() {
//		CustomerDto customer1 = new CustomerDto();
//		CustomerDto customer2 = new CustomerDto();
//		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
//		customers.add(customer1);
//		customers.add(customer2);
		
		List<Meal> mealEntities = this.mealBean.get();
		ArrayList<MealDto> meals = new ArrayList<MealDto>();
		
		for (Meal meal : mealEntities) {
			meals.add(new MealDto(meal.getId(), meal.getName(), meal.getSpiciness(), meal.getDietType(), meal.getIncludes()));
		}
		
		return meals;
	}
	
	@Override
	@GET
	@Path(value = "/{id}")
	public MealDto find(@PathParam("id") int id) {
		Meal meal = this.mealBean.find(id);
		return new MealDto(meal.getId(), meal.getName(), meal.getSpiciness(), meal.getDietType(), meal.getIncludes());
	}
	
	@Override
	@PUT
	@Path(value = "/{id}/edit")
	public Response update(@PathParam("id") int id, MealUpdateDto updatedMeal) {
        
		Meal meal = mealBean.find(id);
        if (meal != null) {

        	meal.setId(updatedMeal.getId());
        	meal.setName(updatedMeal.getName());
        	meal.setSpiciness(updatedMeal.getSpiciness());
        	meal.setDietType(updatedMeal.getDietType());
        	meal.setIncludes(updatedMeal.getIncludes());
            

            mealBean.update(meal);
            
            return Response.ok().entity("{\"message\":\"Danie zosta這 zaktualizowane.\"}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Danie o podanym identyfikatorze nie zosta這 znalezione.\"}").build();
        }
    }

	@DELETE
	@Path(value = "/{id}/delete")
	public Response delete(@PathParam("id") int id){
		Meal meal = mealBean.find(id);
        if (meal != null) {
        	mealBean.delete(meal);
            
            return Response.ok().entity("{\"message\":\"Danie zosta這 usuni皻e.\"}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Danie o podanym identyfikatorze nie zosta這 znalezione.\"}").build();
        }
	}
	

 }
