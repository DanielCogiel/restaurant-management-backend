package pl.polsl.restaurant.customer.customerDtos;

public class CustomerCreateDto {
	private String name;
	private String surname;
	private int table_number;
	
	public CustomerCreateDto() {}
	public CustomerCreateDto(String name, String surname, int table_number) {
		this.name = name;
		this.surname = surname;
		this.table_number = table_number;
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
}
