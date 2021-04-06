package di.ci.example01;

public class Employee {
	private int id;
	private String name;

	public Employee() {
		super();
	}

	public Employee(int id) {
		super();
		this.id = id;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void show() {
		System.out.println(id + " " + name);
	}
}
