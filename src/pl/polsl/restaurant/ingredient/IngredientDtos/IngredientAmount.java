package pl.polsl.restaurant.ingredient.IngredientDtos;

import pl.polsl.restaurant.include.Unit;

public class IngredientAmount {
	private int ingredientId;
	private double amount;
	private Unit unit;
	
	public IngredientAmount() {}
	public IngredientAmount(int ingredientId, double amount, Unit unit) {
		this.ingredientId = ingredientId;
		this.amount = amount;
		this.unit = unit;
	}
	public int getIngredientId() {
		return ingredientId;
	}
	public double getAmount() {
		return amount;
	}
	public Unit getUnit() {
		return unit;
	}
}
