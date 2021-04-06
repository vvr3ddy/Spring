package example01.com.cg.entity;

public class Restaurant {

	private int id;
	private String name;

	public Restaurant(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Restaurant() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void displayResto() {
		System.out.println("Name:" + name + "\nId:" + id);
	}
}
