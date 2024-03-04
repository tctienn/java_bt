package caseItplus;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ProductManager manager = new ProductManager(sc);
		manager.control();
	}
}
