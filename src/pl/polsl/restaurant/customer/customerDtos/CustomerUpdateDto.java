package pl.polsl.restaurant.customer.customerDtos;

public class CustomerUpdateDto {
	private int id;
	private String name;
	private String surname;
	private int table_number;
	
	public CustomerUpdateDto(int id, String name, String surname, int table_number) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.table_number = table_number;
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
}
