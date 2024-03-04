package caseItplus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	static File fileP = new File("C:\\Users\\ADMIN\\Downloads\\user.txt");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<user> ay = new ArrayList<user>();
		ay = read(fileP);
		System.out.println("1: đăng nhập \n 2: đăng ký");
		int ct = Integer.parseInt(sc.nextLine());
		switch (ct) {
		case 1: {
			System.out.println("nhập tên người dùng");
			String name = sc.nextLine();
			System.out.println("nhập mật khẩu");
			String pass = sc.nextLine();
			for (user e : ay) {
				System.out.println(e.getName().equals(name) && e.getPass().equals(pass));
				if (e.getName().equals(name) && e.getPass().equals(pass)) {
					ProductManager manager = new ProductManager(sc);
					manager.control();

				}
			}
			break;
		}
		case 2: {
			System.out.println("nhập tên người dùng");
			String name = sc.nextLine();
			System.out.println("nhập mật khẩu");
			String pass = sc.nextLine();
			user us = new user(name, pass);
			ay.add(us);
			write(fileP, ay);
			ProductManager manager = new ProductManager(sc);
			manager.control();
			break;
		}

		}

//		///
//		List<Product> product = new ArrayList<Product>();
//		product.add(new Product(0, "ay", 0, new Catergory(0, "ay"), 0));
//		product.add(new Product(1, "ay", 0, null, 0));
//		write(fileP, product);
//		product = read(fileP);
	}

	private static void write(File file, List<user> ay) {
		try (ObjectOutputStream oj = new ObjectOutputStream(new FileOutputStream(file))) {
			oj.writeObject(ay);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static List<user> read(File file) {
		List<user> ay = new ArrayList<user>();
		try (ObjectInputStream oj = new ObjectInputStream(new FileInputStream(file))) {
			ay = (List<user>) oj.readObject();
			for (user e : ay) {
				System.out.println(e.toString());
			}
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}

		return ay;
	}
}
