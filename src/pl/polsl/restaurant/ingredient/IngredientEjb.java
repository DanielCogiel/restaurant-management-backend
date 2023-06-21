package pl.polsl.restaurant.ingredient;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class IngredientEjb {
	
	@PersistenceContext(name="restaurant") EntityManager manager;
	
	public void create(Ingredient ingredient) {
		manager.persist(ingredient);
	}
	public List<Ingredient> get() {
		List<Ingredient> ingredients = this
				.manager
				.createQuery("select distinct c from Ingredient c left join fetch c.includes", Ingredient.class)
				.getResultList();
		return ingredients;
	}
	public Ingredient find(int id) {
		Ingredient ingredient = (Ingredient) this
				.manager
				.createQuery("select distinct c from Ingredient c left join fetch c.includes o where c.id = :id")
				.setParameter("id", id)
				.getSingleResult();
		return ingredient;
	}
	public void update(Ingredient ingredient) {
		 manager.merge(ingredient);
	}
	public void delete(Ingredient ingredient) {
		manager.remove(manager.contains(ingredient) ? ingredient : manager.merge(ingredient));
	}
}
