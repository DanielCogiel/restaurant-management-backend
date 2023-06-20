package pl.polsl.restaurant.order;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderEjb {
	
	@PersistenceContext(name="restaurant") EntityManager manager;
	
	public void create(Order order) {
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
	public void update(Order order) {
		 manager.merge(order);
	}
	public void delete(Order order) {
		manager.remove(manager.contains(order) ? order : manager.merge(order));
	}
}
