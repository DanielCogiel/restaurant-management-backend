package pl.polsl.restaurant.order;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.polsl.restaurant.customer.Customer;
import pl.polsl.restaurant.meal.Meal;

@Stateless
public class OrderEjb {
	
	@PersistenceContext(name="restaurant") EntityManager manager;
	
	public void create(Order order, int customerId, List<Integer> mealsIds) {
		Customer customer = this.manager.find(Customer.class, customerId);
		order.setCustomer(customer);
		
		List <Meal> mealList = new ArrayList<Meal>();
		for (int mealId : mealsIds) {
			Meal meal = this.manager.find(Meal.class, mealId);
			mealList.add(meal);
		}
		order.setMeals(mealList);	
		manager.persist(order);
	}
	
	
	public List<Order> get() {
		List<Order> orders = this
				.manager
				.createQuery("select distinct c from Order c left join fetch c.meals", Order.class)
				.getResultList();
		return orders;
	}
	public Order find(int id) {
		Order order = (Order) this
				.manager
				.createQuery("select distinct c from Order c left join fetch c.meals o where c.id = :id")
				.setParameter("id", id)
				.getSingleResult();
		return order;
	}
	public void update(Order order, int customerId, List<Integer> mealsIds) {
		Customer customer = this.manager.find(Customer.class, customerId);
		order.setCustomer(customer);
		
		List <Meal> mealList = new ArrayList<Meal>();
		for (int mealId : mealsIds) {
			Meal meal = this.manager.find(Meal.class, mealId);
			mealList.add(meal);
		}
		order.setMeals(mealList);
		manager.merge(order);
	}
	public void delete(Order order) {
		manager.remove(manager.contains(order) ? order : manager.merge(order));
	}
}
