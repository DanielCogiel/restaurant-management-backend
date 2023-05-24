package pl.kurs.komis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class KomisEJB {
	
	@PersistenceContext(name="komis")
	EntityManager manager;

	
	public void create(Car car) {
		System.out.println("Creating car!");
		manager.persist(car);
	}

	public void delete(int idc) {
		Car car = manager.find(Car.class, idc);
		manager.remove(car);
	}

	public List<Car> findByMake(String make) {
		Query q = manager.createQuery("select c from Car c where c.make like :make");
		q.setParameter("make", make);
		@SuppressWarnings("unchecked")
		List<Car> lista =q.getResultList();
		return lista;
	}

	public Car find(int idc) {
		return manager.find(Car.class, idc);
	}

	public List<Car> get() {
		Query q = manager.createQuery("select c from Car c");
		@SuppressWarnings("unchecked")
		List<Car> list = q.getResultList();
		return list;
	}

	public void update(Car car) {
		car = manager.merge(car);
	}

	
}
