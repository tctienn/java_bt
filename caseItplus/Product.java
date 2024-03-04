package caseItplus;

import java.io.Serializable;

public class Product implements Serializable {
	private long id;
	private String name;
	private double Price;
	private Catergory category;
	private int Quantity;

	public Product(long id, String name, double price, Catergory category, int quantity) {
		super();
		this.id = id;
		this.name = name;
		Price = price;
		this.category = category;
		Quantity = quantity;
	}

	public Product() {
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

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public Catergory getCategory() {
		return category;
	}

	public void setCategory(Catergory category) {
		this.category = category;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", Price=" + Price + ", category=" + category + ", Quantity="
				+ Quantity + ", loại=" + getCategory() + "]";
	}

//	@Override
//	public int compareTo(Product o) {
//		// TODO Auto-generated method stub
//		if (this.Price > o.Price) {
//			return 1;
//		} else if (this.Price < o.Price) {
//			return -1;
//		} else
//			return 0;
//	}

}
