package pl.polsl.restaurant.customer;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import pl.polsl.restaurant.customer.customerDtos.CustomerCreateDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerUpdateDto;

@Path(value="customers")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class CustomerRest implements CustomerRestInterface {	
	@EJB
	CustomerEjb customerBean;
	
	@Override
	@POST
	public Response create(CustomerCreateDto createCustomer) {
		try {
			Customer customer = new Customer();
			customer.setName(createCustomer.getName());
			customer.setSurname(createCustomer.getSurname());
			customer.setTable_number(createCustomer.getTable_number());
			this.customerBean.create(customer);
			return Response.ok().entity("{\"message\":\"Klient zosta³ utworzony.\"}").build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"message\":\"Nie uda³o siê utworzyæ klienta.\"}").build();
		}
	}
	
	@Override
	@GET
	public ArrayList<CustomerDto> get() {
		List<Customer> customerEntities = this.customerBean.get();
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		
		for (Customer customer : customerEntities) {
			customers.add(new CustomerDto(customer.getId(), customer.getName(), customer.getSurname(), 
					customer.getTable_number(), customer.getOrders()));
		}
		
		return customers;
	}
	
	@Override
	@GET
	@Path(value = "/{id}")
	public CustomerDto find(@PathParam("id") int id) {
		Customer customer = this.customerBean.find(id);
		return new CustomerDto(customer.getId(), customer.getName(), customer.getSurname(), 
				customer.getTable_number(), customer.getOrders());
	}
	
	@Override
	@DELETE
	@Path(value="/{id}/delete")
	public Response delete(@PathParam("id") int id) {
		try {
			this.customerBean.delete(id);
			return Response.ok().entity("{\"message\":\"Uda³o siê usun¹æ klienta.\"}").build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"message\":\"Usuniêcie klienta nie powiod³o siê.\"}").build();
		}
	}
	
	@Override
	@PUT
	@Path(value = "/{id}/edit")
	public Response update(@PathParam("id") int id, CustomerUpdateDto updatedCustomer) {
		try {
			Customer currentCustomer = this.customerBean.find(id);
			if (updatedCustomer.getName() != null) 
				currentCustomer.setName(updatedCustomer.getName());
			if (updatedCustomer.getSurname() != null) 
				currentCustomer.setSurname(updatedCustomer.getSurname());
			if (updatedCustomer.getTable_number() != 0) 
				currentCustomer.setTable_number(updatedCustomer.getTable_number());
			this.customerBean.update(currentCustomer);
			return Response.ok().entity("{\"message\":\"Pomyœlnie zaktualizowano klienta.\"}").build();
		} catch (Exception e) {
			return Response.status(500).entity("{\"message\":\"Nie uda³o siê zaktualizowaæ klienta.\"}").build();
		}
	}
 }
