package pl.polsl.restaurant.util;

import java.util.ArrayList;

import javax.ejb.Local;

import pl.polsl.restaurant.customer.customerDtos.CustomerCreateDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerDto;
import pl.polsl.restaurant.customer.customerDtos.CustomerUpdateDto;

@Local
public interface RestInterface<Tr, Tc, Tu> {
	public abstract Tr create(Tc createDto);
	public abstract Tr find(int id); //CustomerDto
	public abstract ArrayList<Tr> get();
	public abstract NotifierDto update(Tu updateDto);
	public abstract NotifierDto delete(int id);
}

//@Local
//public interface CustomerRestInterface<Tr, Tc, Tu> {
//	public abstract CustomerDto create(CustomerCreateDto createCustomer);
//	public abstract CustomerDto find(int id); //CustomerDto
//	public abstract ArrayList<CustomerDto> get();
//	public abstract NotifierDto update(CustomerUpdateDto updatedCustomer);
//	public abstract NotifierDto delete(int id);
//}
