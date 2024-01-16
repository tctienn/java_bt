package ay;

import java.util.Scanner;

public class bt_ondition {
	
	
	
	public static void main(String[] args) {
		
//		b1
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("nhập 3 số nguyên");
//		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
//		int max = 0;
//		if(a>b) {
//			if(a>c)
//			{
//				max = a;
//			}
//			else {
//				max = c;
//			}
//		}else {
//			if(b>c) {
//				max =b;
//			}
//			else {
//				max = c;
//			}
//			
//			System.out.println("ay");
//		}
//		
//		System.out.println("số lớn nhất là" + max);
		
//		b2
//		System.out.print("nhập số điểm sinh viên :");
//		float diem = sc.nextFloat();
//		String tb = "";
//		if(diem > 8) {
//			tb = "giỏi";
//		}else {
//			if(diem > 6.5) {
//				tb ="khá";
//				
//			}
//			else if(diem > 5) {
//				tb = "tb";
//			}
//			else {
//				tb = "yếu";
//			}
//		}
//		System.out.println("xếp loại "+ tb);
		
//		b3
		System.out.println("nhập vào một số");
		float so = sc.nextFloat();
		if(so>0) {
			System.out.println("Positive");
		}else if(so<0) {
			System.out.println("Negative");
		}else {
			System.out.println(0);
		}
		
	}
}
