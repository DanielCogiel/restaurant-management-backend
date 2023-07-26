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
		if (customer != null) {
			order.setCustomer(customer);	
			manager.persist(order);
		}
		
		for (int mealId : mealsIds) {
			Meal meal = this.manager.find(Meal.class, mealId);
			meal.setOrder(order);
			manager.merge(meal);
		}
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
		if (customer != null) {
			order.setCustomer(customer);
			manager.merge(order);
		}
		
		this.clearMeals(order);
		for (int mealId : mealsIds) {
			Meal meal = this.manager.find(Meal.class, mealId);
			meal.setOrder(order);
			manager.merge(meal);
		}
	}
	public void delete(int id) {
		Order order = this.manager.find(Order.class, id);
		manager.remove(order);
	}
	
	private void clearMeals(Order order) {
		List<Meal> meals = order.getMeals();
		for (Meal meal : meals) {
			meal.setOrder(null);
			this.manager.merge(meal);
		}
	}
}
