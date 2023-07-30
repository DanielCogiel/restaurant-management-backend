package pl.polsl.restaurant.order;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import pl.polsl.restaurant.order.OrderDtos.OrderCreateDto;
import pl.polsl.restaurant.order.OrderDtos.OrderDto;
import pl.polsl.restaurant.order.OrderDtos.OrderUpdateDto;

@Path(value="orders")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class OrderRest implements OrderRestInterface {
	
//	@Override
//	@POST
//	public CustomerDto create(CustomerCreateDto createCustomer) {
//		return
//	}
	
	@EJB
	OrderEjb orderBean;
	
	@Override
	@POST
	public Response create(OrderCreateDto createOrder) {
		try {
			Order order = new Order();
			this.orderBean.create(order, createOrder.getUserId(), createOrder.getMeals());
			return Response.ok().entity("{\"message\":\"Utworzono zamówienie.\"}").build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"message\":\"Nie uda³o siê stworzyæ zamówienia.\"}").build();
		}
	}
	
	@Override
	@GET
	public ArrayList<OrderDto> get() {		
		List<Order> orderEntities = this.orderBean.get();
		ArrayList<OrderDto> orders = new ArrayList<OrderDto>();
		
		for (Order order : orderEntities) {
			orders.add(new OrderDto(order.getId(), order.getMeals(), order.getCustomer()));
		}
		
		return orders;
	}
	
	@Override
	@GET
	@Path(value = "/{id}")
	public OrderDto find(@PathParam("id") int id) {
		Order order = this.orderBean.find(id);
		return new OrderDto(order.getId(), order.getMeals(), order.getCustomer());
	}
	
	@Override
	@PUT
	@Path(value = "/{id}/edit")
	public Response update(@PathParam("id") int id, OrderUpdateDto updatedOrder) {
        
        Order order = orderBean.find(id);
        if (order != null) {
            orderBean.update(order, updatedOrder.getCustomer(), updatedOrder.getMeals());
            
            return Response.ok().entity("{\"message\":\"Zamówienie zosta³o zaktualizowane.\"}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Zamówienie o podanym identyfikatorze nie zosta³o znalezione.\"}").build();
        }
    }

	@DELETE
	@Path(value = "/{id}/delete")
	public Response delete(@PathParam("id") int id){
        try {
            orderBean.delete(id);
            return Response.ok().entity("{\"message\":\"Zamówienie zosta³o usuniête.\"}").build();
        } catch(Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Zamówienie o podanym identyfikatorze nie zosta³o znalezione.\"}").build();
        }
	}
	

 }
