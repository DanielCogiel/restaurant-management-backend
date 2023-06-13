package pl.polsl.restaurant.customer;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pl.polsl.restaurant.customer.customerDtos.CustomerCreateDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerUpdateDto;

@Path(value="customers")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class CustomerRest implements CustomerRestInterface {
	
//	@Override
//	@POST
//	public CustomerDto create(CustomerCreateDto createCustomer) {
//		return
//	}
	
	@EJB
	CustomerEjb customerBean;
	
	@Override
	@POST
	public CustomerDto create(CustomerCreateDto createCustomer) {
		Customer customer = new Customer();
		customer.setName(createCustomer.getName());
		customer.setSurname(createCustomer.getSurname());
		customer.setTable_number(createCustomer.getTable_number());
		this.customerBean.create(customer);
		
		CustomerDto customerData = new CustomerDto(customer.getId(),
				customer.getName(), customer.getSurname(), customer.getTable_number(), customer.getOrders());
		return customerData;
	}
	
	@Override
	@GET
	public ArrayList<CustomerDto> get() {
//		CustomerDto customer1 = new CustomerDto();
//		CustomerDto customer2 = new CustomerDto();
//		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
//		customers.add(customer1);
//		customers.add(customer2);
		
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
	@Path(value="/{id}")
	public NotifierDto delete(@PathParam("id") int id) {
		try {
			this.customerBean.delete(id);
			return new NotifierDto("Successfully deleted customer.");
		} catch (Exception e) {
			return new NotifierDto("Could not delete given customer.");
		}
	}
	
	@Override
	@PUT
	public NotifierDto update(CustomerUpdateDto updatedCustomer) {
		try {
			Customer currentCustomer = this.customerBean.find(updatedCustomer.getId());
			if (updatedCustomer.getName() != null) 
				currentCustomer.setName(updatedCustomer.getName());
			if (updatedCustomer.getSurname() != null) 
				currentCustomer.setSurname(updatedCustomer.getSurname());
			if (updatedCustomer.getTable_number() != 0) 
				currentCustomer.setTable_number(updatedCustomer.getTable_number());
			this.customerBean.update(currentCustomer);
			return new NotifierDto("Successfully updated customer.");
		} catch (Exception e) {
			return new NotifierDto("Could not update given customer.");
		}
	}
	
 }
