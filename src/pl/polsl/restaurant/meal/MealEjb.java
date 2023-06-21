package pl.polsl.restaurant.meal;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MealEjb {
	
	@PersistenceContext(name="restaurant") EntityManager manager;
	
	public void create(Meal meal) {
		manager.persist(meal);
	}
	public List<Meal> get() {
		List<Meal> meals = this
				.manager
				.createQuery("select distinct c from Meal c left join fetch c.includes", Meal.class)
				.getResultList();
		return meals;
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
