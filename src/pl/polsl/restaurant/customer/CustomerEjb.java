package pl.polsl.restaurant.customer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerEjb {
	
	@PersistenceContext(name="restaurant") EntityManager manager;
	
	public void create(Customer customer) {
		manager.persist(customer);
	}
	public List<Customer> get() {
		List<Customer> customers = this
				.manager
				.createQuery("select distinct c from Customer c left join fetch c.orders", Customer.class)
				.getResultList();
		return customers;
	}
	public Customer find(int id) {
		Customer customer = (Customer) this
				.manager
				.createQuery("select distinct c from Customer c left join fetch c.orders o where c.id = :id")
				.setParameter("id", id)
				.getSingleResult();
		return customer;
	}
}
