package pl.polsl.restaurant.order;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import pl.polsl.restaurant.order.OrderDtos.OrderCreateDto;
import pl.polsl.restaurant.order.OrderDtos.OrderDto;
import pl.polsl.restaurant.order.OrderDtos.OrderUpdateDto;
import pl.polsl.restaurant.order.OrderDtos.OrderNoRelations;

@Local
public interface OrderRestInterface {
	public abstract Response create(OrderCreateDto createOrder);
	public abstract OrderDto find(int id); //CustomerDto
	public abstract ArrayList<OrderDto> get();
	public abstract Response update(int id, OrderUpdateDto updatedOrder);
	public abstract Response delete(int id);
	
}