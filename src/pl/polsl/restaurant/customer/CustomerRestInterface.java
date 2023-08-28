package pl.polsl.restaurant.customer;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import pl.polsl.restaurant.customer.customerDtos.CustomerCreateDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerUpdateDto;

@Local
public interface CustomerRestInterface {
	public abstract Response create(CustomerCreateDto createCustomer);
	public abstract CustomerDto find(int id); //CustomerDto
	public abstract ArrayList<CustomerDto> get();
	public abstract Response update(int id, CustomerUpdateDto updatedCustomer);
	public abstract Response delete(int id);
}
