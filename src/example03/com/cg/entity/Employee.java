package example03.com.cg.entity;

public class Employee {
	private int id;
	private String name;

	public Employee() {
		super();
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void displayEmp() {
		System.out.println("ID:" + id + "\nName:" + name);
	}
}
