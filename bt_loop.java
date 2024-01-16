package ay;

import java.util.Random;
import java.util.Scanner;

public class bt_loop {
public static void main(String[] args) {
//	b1
//	Scanner sc = new Scanner(System.in);
	
//	System.out.println("nhập số giai thừa");
//	int a = sc.nextInt();
//	int b =1;
//	
//	 for(int i =1; i <=a; i++) {
//		b *=i;
//		
//	 }
//	 
//	 System.out.println("!"+a+"="+b);
	 
//	 b2
//	 int a=1;
//	 int b=2;
//	 boolean check = false;
//	 while(a<=20) {
//		 
//		for(int i =2; i<b; i++ ) {
//			if(b%i==0) {
//				check = true;
//				break;
//			}
//		}
//		if(check == false) {
//			
//			System.out.print(b +",");
//			a++;
//			
//		}
//		check = false;
//		b++;
//		 
//	 }
	
//	b3
//	int a=1;
//	int b=0;
//	int c=0;
//	for(int i = 1; i<=20;i++) {
//		c=a;
//		a +=b;
//		b=c;
//		
//		System.out.print(a + ",");
//		
//	}
	
//	b4
//	Scanner sc = new Scanner(System.in);
//	System.out.println("nhập số tiền, lãi xuất (%) , tháng gửi");
//	double saveMoney=sc.nextDouble(),ls=sc.nextDouble(), sumMoney = saveMoney ;
//	int month= sc.nextInt();
//	
//	
//	for(int i=1; i<=month;i++) {
//		sumMoney += (sumMoney*(ls/100));
//		
//	}
//	
//	System.out.println(sumMoney);
	
//	b5
//	for(int i=1; i<=100; i++)
//	{
//		if(i%3==0 && i%5==0) {
//			System.out.print("hello word ,");
//		}else {
//			if(i%3==0) {
//				System.out.print("hello ,");
//			}else if(i%5==0)
//			{
//				System.out.print("word ,");
//			}else {
//				System.out.print(i + ",");
//			}
//				
//			
//		}
//	}
	
//	b6
	
	Scanner sc = new Scanner(System.in);
	Random generator = new Random();
	System.out.print("nhập khoảng random min , max");
	int min = sc.nextInt(), max = sc.nextInt();
	int random = generator.nextInt((max - min) + 1) + min;
	System.out.println("_______bây giờ bạn có 3 lần đoán_______ kq:"+ random);
	int d;
	for(int i=0; i<3; i++) {
		System.out.print("đoán lần "+i+" : ");
		d=sc.nextInt();
		if(d> random) {
			System.out.println("giảm xuống");
		}else if(d< random) {
			System.out.println("tăng lên");
		}else {
			System.out.println("bạn đã thắng");
			return;
		}
	}
	System.out.println("bạn đã thua")
	
	
	
}
}
