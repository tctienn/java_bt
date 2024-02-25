package btTruocTet.QLSP;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		String[] a = { "loại 1", "loại 2", "Điện tử" };
		Category[] arCategory = new Category[3];
		int i = 0;
		for (String e : a) {
			Category category = new Category(i, e);
			arCategory[i] = category;
			i++;

		}
//
		Scanner sc = new Scanner(System.in);
		ProductManager manager = new ProductManager(sc, arCategory);
		manager.control();
//		manager.createProduct();
//		manager.createProduct();
//		manager.createProduct();
//		manager.findProductByCatergory();

//		String[] b = new String[a.length - 1];
//		System.arraycopy(a, 0, b, 0, Arrays.binarySearch(a, "loại 2"));
//		System.arraycopy(a, (Arrays.binarySearch(a, "loại 2") + 1), b, (Arrays.binarySearch(a, "loại 2")),
//				a.length - Arrays.binarySearch(a, "loại 2") - 1);
//
////
//		for (String e : b) {
//			System.out.println(e);
//
//		}

	}
}
