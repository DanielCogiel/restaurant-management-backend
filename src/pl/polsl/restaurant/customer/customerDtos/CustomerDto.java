package pl.polsl.restaurant.customer.customerDtos;

import java.util.ArrayList;
import java.util.List;

import pl.polsl.restaurant.order.Order;
import pl.polsl.restaurant.order.OrderDtos.OrderNoRelations;

public class CustomerDto {
	private int id;
	private String name;
	private String surname;
	private int table_number;
	private List<OrderNoRelations> orders = new ArrayList<OrderNoRelations>();
	
	public CustomerDto() {};
	public CustomerDto(int id, String name, String surname, int table_number, List<Order> orders) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.table_number = table_number;
		
		for (Order order : orders) {
			this.orders.add(new OrderNoRelations(order.getId()));
		}
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public int getTable_number() {
		return table_number;
	}
	public List<OrderNoRelations> getOrders() {
		return orders;
	}
}
