package caseItplus;

public class Catergory {
	private long id;
	private String name;

	public Catergory(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Catergory() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Catergory [id=" + id + ", name=" + name + "]";
	}

}
