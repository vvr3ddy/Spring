package example02.com.cg.entity;

public class Employee {
	private int id;
	private String name;
	private Address address;

	public Employee() {
		super();
	}

	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void displayEmployee() {
		System.out.println("Id:" + id + " Name:" + name + "\nAddress:");
		address.displayAddress();
	}

}
