package caseItplus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
	public Long id;
	public List<Catergory> catergory;
	private List<Product> listProduct;
	private Scanner sc;
	private File fileP = new File("C:\\Users\\ADMIN\\Downloads\\output1.txt");
//	private File fileI = new File("C:\\Users\\ADMIN\\Downloads\\output2.txt");

	public ProductManager(Scanner sc) {
		super();
//		this.catergory = catergory;
		this.sc = sc;
		this.listProduct = new ArrayList<Product>();
		this.catergory = new ArrayList<Catergory>();
		this.id = 0L;
		initCatergory();

	}

	private void initCatergory() {
		this.catergory.add(new Catergory(0, "loai 1"));
		this.catergory.add(new Catergory(1, "loai 2"));
		this.catergory.add(new Catergory(2, "loai 3"));
	}

	public void createProduct() {
		this.listProduct.add(addProduct());
	}

	private int checkInt() {
		int a = 0;
		boolean check = false;
		do {
			try {
				a = Integer.parseInt(this.sc.nextLine());
				check = false;
			} catch (Exception e) {
				System.out.println("dữ liệu nhập không đúng kiểu yêu cầu nhập lại");
				check = true;
				// TODO: handle exception
			}

		} while (check);

		return a;
	}

	private double checkDouble() {
		double a = 0d;
		boolean check = false;
		do {
			try {
				a = Double.parseDouble(this.sc.nextLine());
				check = false;
			} catch (Exception e) {
				System.out.println("dữ liệu nhập không đúng kiểu yêu cầu nhập lại");
				check = true;
				// TODO: handle exception
			}

		} while (check);

		return a;
	}

	private Catergory selectCatergory() {
		System.out.println("chọn loại theo mã id \n danh sách catergory ");
		boolean check = false;
		for (Catergory e : this.catergory) {
			System.out.println(e.toString());
		}
		int a;
		do {
			if (check) {
				System.out.println("nhập lại id ");
			}
			a = checkInt();
			for (Catergory e : this.catergory) {
				if (e.getId() == a) {
					check = false;
					return e;

				}
			}
			System.out.println("id không tồn tại yêu cần nhập lại");
			check = true;
		} while (check);
		return new Catergory();

	}

	private Product addProduct() {
		System.out.println("nhập tên sản phẩm ");
		String name = sc.nextLine();
		System.out.println("nhập giá ");
		double price = checkDouble();
		System.out.println("nhập số lượng sản phẩm");
		int quantity = checkInt();
		Catergory cater = selectCatergory();

		Product product = new Product(this.id, name, price, cater, quantity);
		this.id++;
		return product;

	}

	public void render() {

		if (listProduct.size() <= 0) {
			System.out.println("danh sánh sản phẩm trống ");
		} else {

			for (Product e : listProduct) {
				System.out.println(e.toString());
			}
		}
	}

	public void control() {

		int ct;

		do {

			this.listProduct = read(this.fileP);
			System.out.println(
					"chức năng \n 1: thêm sản phẩm \n 2: hiển thị danh sách sản phẩm  \n 3: cập nhật sản phẩm  \n 4: xóa sản phẩm theo id \n 5: lọc sản phẩm theo loại  \n 6: sắp xếp danh sách sản phẩm \n 7: tìm kiếm theo tên sản phẩm  \n 8: tìm kiếm theo giá ");
			ct = checkInt();
			switch (ct) {
			case 1: {
				createProduct();

				write(fileP, this.listProduct);
				break;
			}
			case 2: {
				render();

				break;
			}
			case 3: {
				updateProduct();
				write(fileP, this.listProduct);
				break;
			}
			case 4: {
				deleteProduct();
				write(fileP, this.listProduct);
				break;
			}
			case 5: {
				findByCategory();

				break;
			}
			case 6: {
				sxtheogia();

				break;
			}
			case 7: {
				findProductByName();

				break;
			}
			case 8: {
				findProductByPrice();

				break;
			}
			case 11: {
				write(fileP, this.listProduct);
				break;
			}
			default:
				System.err.println("không tồn tại liện điều khiển ");
			}
		} while (ct != 11);

		return;
	}

// ghi đè phương thức equal trong đối tượng để chạy indexof của list lấy index chạy set ?
	private void updateProduct() {
		System.out.println("nhập id sản phẩm cần cập nhật");
		long idProduct = checkInt();
		for (int i = 0; i < listProduct.size(); i++) {
			if (listProduct.get(i).getId() == idProduct) {
				System.out.println("sản phẩm đang chọn : \n" + listProduct.get(i).toString());
				System.out.println(" nhập thông tin sản phẩm cần cập nhật ");
				listProduct.set(i, addProduct());
				return;
			}
		}
	}

	private void deleteProduct() {
		render();
		System.out.println("nhập id sản phẩm cần xóa");
		long idProduct = checkInt();
		for (int i = 0; i < listProduct.size(); i++) {
			if (listProduct.get(i).getId() == idProduct) {
				listProduct.remove(i);
				return;
			}
		}
		System.out.println("id không tồn tại");
	}

	private void findByCategory() {
		System.out.println("lọc sản phẩm theo loại ");
		Catergory cate = selectCatergory();

		if (cate == null) {
			System.out.println("không có loại sản phẩm nào");
			return;
		}
		System.out.println("lọc sản phẩm theo " + cate.getName());
		for (Product e : listProduct) {
			if (e.getCategory().getId() == cate.getId()) {
				System.out.println(e.toString());
			}
		}
	}

	private void sxtheogia() {
		System.out.println("chọn thuộc tính sắp xếp \n 1: sắp xết theo giá \n 2: sắp xếp theo số lượng");
		int ct = checkInt();
		switch (ct) {
		case 1: {

			Collections.sort(listProduct, new Comparator<Product>() {

				@Override
				public int compare(Product o1, Product o2) {
					if (o1.getPrice() > o2.getPrice()) {
						return -1;
					} else if (o1.getPrice() < o2.getPrice()) {
						return 1;
					} else
						return 0;
				}

			});

			render();
			break;
		}
		case 2: {
			Collections.sort(listProduct, new Comparator<Product>() {

				@Override
				public int compare(Product o1, Product o2) {
					if (o1.getQuantity() > o2.getQuantity()) {
						return -1;
					} else if (o1.getQuantity() < o2.getQuantity()) {
						return 1;
					} else
						return 0;
				}

			});

			render();

			break;
		}
		default:
			System.out.println("không tồn tại lệnh điều khiển");
		}
	}

	private void findProductByName() {
		System.out.println(" nhập tên sản phẩm cần tìms");
		String name = this.sc.nextLine();
		for (Product e : listProduct) {
			if (e.getName().contains(name)) {
				System.out.println(e.toString());
			}
		}
	}

	private void findProductByPrice() {
		System.out.println(" nhập khoảng giá trên ");
		double price1 = checkDouble();
		System.out.println(" nhập khoảng giá dưới");
		double price2 = checkDouble();
		System.out.println("danh sách sản phẩm trong khoảng giá từ " + price2 + "đến" + price1);
		for (Product e : listProduct) {
			if (e.getPrice() <= price1 && e.getPrice() >= price2) {
				System.out.println(e.toString());
			}
		}
	}

	private void write(File file, List<Product> product) {
		try (ObjectOutputStream oj = new ObjectOutputStream(new FileOutputStream(file))) {
			oj.writeObject(product);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private List<Product> read(File file) {
		List<Product> product = new ArrayList<Product>();
		try (ObjectInputStream oj = new ObjectInputStream(new FileInputStream(file))) {
			product = (List<Product>) oj.readObject();
//			for (Product e : product) {
//				System.out.println(e.toString());
//			}
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}

		return product;
	}

//	private void updateFile() {
//		read
//	}
}
