package pl.polsl.restaurant.ingredient.IngredientDtos;

import pl.polsl.restaurant.include.Unit;

public class IngredientAmountName {
	private String name;
	private double amount;
	private Unit unit;
	
	public IngredientAmountName(String name, double amount, Unit unit) {
		this.name = name;
		this.amount = amount;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
}
