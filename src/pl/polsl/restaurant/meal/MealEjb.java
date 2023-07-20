package pl.polsl.restaurant.meal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.polsl.restaurant.include.Include;
import pl.polsl.restaurant.order.Order;

@Stateless
public class MealEjb {
	
	@PersistenceContext(name="restaurant") EntityManager manager;
	
	public void create(Meal meal, int orderId, List<Integer> includeIds) {
		Order order = this.manager.find(Order.class, orderId);
		meal.setOrder(order);
		
		Set<Include> includeList = new HashSet<Include>();
		for (int includeId : includeIds) {
			Include include = this.manager.find(Include.class, includeId);
			includeList.add(include);
		}
		meal.setIncludes(includeList);
		
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
