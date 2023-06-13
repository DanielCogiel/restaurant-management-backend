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
	public void delete(int id) {
		Customer customer = this.manager.find(Customer.class, id);
		this.manager.remove(customer);
	}
	public void update(Customer customerUpdated) {
		Customer customer = this.manager.find(Customer.class, customerUpdated.getId());
		customer.setName(customerUpdated.getName());
		customer.setSurname(customerUpdated.getSurname());
		customer.setTable_number(customerUpdated.getTable_number());
		customer.setOrders(customerUpdated.getOrders());
		this.manager.merge(customer);
	}
}
