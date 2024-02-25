package btTruocTet.QLSP;

import java.util.Scanner;

public class ProductManager {

	private Scanner sc;
	private Product[] arProduct;
	private int index = 0;
	private Long idProduct = 1L;
	private Category[] arCategory;

	public ProductManager(Scanner sc, Category[] arCategory) {
		super();
		this.sc = sc;
//		this.index = 1;
//		this.arProduct = new Product[index];
		this.arCategory = arCategory;

	}

	public ProductManager() {
		super();
	}

	public void createProduct() {
//		product
		this.index++;
		if (arProduct == null) {
			this.arProduct = new Product[index];
			arProduct[index - 1] = addProduct();
		} else {
			Product[] arCoppy = this.arProduct;
			this.arProduct = new Product[index];
			System.arraycopy(arCoppy, 0, this.arProduct, 0, arCoppy.length);
			arProduct[index - 1] = addProduct();
		}

	}

	private Product addProduct() {
		this.idProduct++;
		System.out.println(" _______________________tạo sản phẩm___________________ \n Nhập tên sản phẩm: ");
		String name = this.sc.nextLine();
		System.out.println("nhập giá: ");
		Double price = Double.parseDouble(this.sc.nextLine());
		System.out.println("nhập số lượng");
		Integer quantity = Integer.parseInt(this.sc.nextLine());
		System.out.println("nhập số id của catergory muốn chọn \n danh sách catergory \n ");
		for (Category e : arCategory) {
			System.out.println(e.toString());
		}

		int categoryID;
		boolean check = false;
		do {
			if (check) {
				System.out.println("id vừa nhập không hợp lệ nhập lại");
			}
			categoryID = Integer.parseInt(this.sc.nextLine());
			check = true;
		} while (categoryID < 0 || categoryID > (arCategory.length - 1));

		Category catergory = arCategory[categoryID];

		Product product = new Product(this.idProduct, name, price, quantity, catergory);

		return product;
	}

	public void render() {
		for (Product e : this.arProduct) {
			System.out.println(e.toString());
		}
	}

	public void control() {
		int ct = 0;
		do {
			System.out.println(
					"chức năng: \n 1: tạo mới sản phẩm \n 2: hiển thị và lọc \n 3: xóa product theo id \n  4:cập nhật theo id sản phẩm \n  5: cập nhật catergory \n 11: đóng hoạt động");
			ct = Integer.parseInt(this.sc.nextLine());
			switch (ct) {
			case 1: {
				createProduct();
				break;
			}
			case 2: {
				renderControl();
				break;
			}
			case 3: {
				deleteProduct();
			}
			case 4: {
				updateProduct();
			}
			case 5: {
				updateCatergory();
			}
			case 11: {
				break;
			}
			default:
				System.out.println("lệnh điều khiển không hợp lệ");

			}
		} while (ct != 11);
	}

	public void renderControl() {
		System.out.println(
				"hiển thị: \n 1: hiển thị toàn bộ  \n 2: tìm kiếm theo id sản phẩm \n 3: hiển thị sản phẩm theo catergory \n 4: tính giá của tất cả sản phẩm  \n 5: sản phẩm có giá > 100000  ");
		int ct = Integer.parseInt(this.sc.nextLine());

		switch (ct) {
		case 1: {
			render();
			break;
		}
		case 2: {
			findProductByID();
			break;
		}
		case 3: {
			findProductByCatergory();
			break;
		}
		case 4: {
			sumPriceProduct();
			break;
		}
		case 5: {
			findProductByPrice();
			break;
		}
		default:
			System.out.println("lệnh điều khiển không hợp lệ");
		}
	}

	public void findProductByID() {
		System.out.println("nhập id sản phẩm cần tìm ");
		long id = Long.parseLong(this.sc.nextLine());
		for (Product e : arProduct) {
			if (e.getId().equals(id)) {
				System.out.println("sản phẩm cần tìm : " + e.toString());
				return;
			}
		}
		System.out.println("không tìm thấy id của sản phẩm");
	}

	public void findProductByCatergory() {

		System.out.println(" tìm kiếm theo catergory \n danh sách catergory");
		for (Category e : arCategory) {
			System.out.println(e.toString());
		}
		Integer id;
		boolean check = false;
		int categoryID;
		do {
			id = Integer.parseInt(this.sc.nextLine());
			if (check) {
				System.out.println("id vừa nhập không hợp lệ nhập lại");
			}
			categoryID = Integer.parseInt(this.sc.nextLine());
			check = true;
		} while (categoryID < 0 || categoryID > (arCategory.length - 1));

		System.out.println("danh sách sản phẩm theo " + arCategory[id] + " : ");
		for (Product e : arProduct) {
//			System.out.println(e.getCategory().getId());
			if (e.getCategory().getId().equals(id)) {
				System.out.println(e.toString());
			}
		}
	}

	public void sumPriceProduct() {
		double sum = 0;
		for (Product e : arProduct) {
			sum += e.getPrice();
		}
		System.out.println("giá của tất cả sản phẩm " + sum);
	}

	public void findProductByPrice() {
		System.out.println("sản phẩm có giá > 100000 ");
		for (Product e : arProduct) {
			if (e.getPrice() > 100000)
				continue;
			System.out.println(e.toString());
		}
	}

	public void findProductByPrice2() {
		System.out.println("sản phẩm có giá > 100000 và có category là điện tử ");
		for (Product e : arProduct) {
			if (e.getPrice() > 200000 && e.getCategory().getName().equals("điện tử"))
				continue;
			System.out.println(e.toString());
		}
	}

	public void deleteProduct() {
		System.out.println("nhập id của sản phẩm cần xóa");
		long id = Long.parseLong(this.sc.nextLine());
		Integer indexs = null;
		for (int i = 0; i < arProduct.length; i++) {
			if (arProduct[i].getId().equals(id)) {
				indexs = i;
				Product[] arcop = new Product[arProduct.length - 1];
				System.arraycopy(arProduct, 0, arcop, 0, indexs);
				System.arraycopy(arProduct, indexs + 1, arcop, indexs, arProduct.length - indexs - 1);
				arProduct = arcop;

				break;

//				System.arraycopy(arProduct, 0, arcop, 0, (Arrays.binarySearch(arProduct, e)));
//				System.arraycopy(arProduct, (Arrays.binarySearch(arProduct, e) + 1), arcop,
//						(Arrays.binarySearch(arProduct, e)), arProduct.length - Arrays.binarySearch(arProduct, e) - 1);
//				System.out.println(Arrays.binarySearch(arProduct, e));

			}
		}

		if (indexs == null) {
			System.out.println("không có giá trị nào được tìm thấy");
		}
	}

	public void updateProduct() {

		System.out.println("nhập id sản phẩm cần sửa");
		long id = Long.parseLong(this.sc.nextLine());
		Product product = null;
		for (Product e : arProduct) {
			if (e.getId().equals(id)) {
				product = e;

				break;
			}
		}

		if (product != null) {
			System.out.println("\n sản phẩm đang chờ sửa : " + product.toString());
			System.out.println(" _______________________sửa sản phẩm___________________ \n Nhập tên sản phẩm: ");
			String name = this.sc.nextLine();
			System.out.println("nhập giá: ");
			Double price = Double.parseDouble(this.sc.nextLine());
			System.out.println("nhập số lượng");
			Integer quantity = Integer.parseInt(this.sc.nextLine());
			System.out.println("nhập số id của catergory muốn chọn \n danh sách catergory \n ");
			for (Category e : arCategory) {
				System.out.println(e.toString());
			}

			int categoryID;
			boolean check = false;
			do {
				if (check) {
					System.out.println("id vừa nhập không hợp lệ nhập lại");
				}
				categoryID = Integer.parseInt(this.sc.nextLine());
				check = true;
			} while (categoryID < 0 || categoryID > (arCategory.length - 1));

			Category catergory = arCategory[categoryID];

			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setCategory(catergory);

		}
	}

	public void updateCatergory() {
		System.out.println("nhập id cartergory cần update ");
		Integer id = Integer.parseInt(this.sc.nextLine());
		System.out.println("nhập tên catergory ");
		arCategory[id].setName(this.sc.nextLine());

	}

}
