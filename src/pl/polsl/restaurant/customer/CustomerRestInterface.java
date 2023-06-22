package pl.polsl.restaurant.customer;

import java.util.ArrayList;

import javax.ejb.Local;

import pl.polsl.restaurant.customer.customerDtos.CustomerCreateDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerUpdateDto;

@Local
public interface CustomerRestInterface {
	public abstract CustomerDto create(CustomerCreateDto createCustomer);
	public abstract CustomerDto find(int id); //CustomerDto
	public abstract ArrayList<CustomerDto> get();
	public abstract NotifierDto update(CustomerUpdateDto updatedCustomer);
	public abstract NotifierDto delete(int id);
}
