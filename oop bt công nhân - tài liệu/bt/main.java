package bt;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {

//		QLCB ql = new QLCB( 2);
//		CanBo nv = new NhanVien("ten", 0, "goitinh", "diachi");
//		CanBo nv2 = new NhanVien("ten", 0, "goi tinh ", "dia chi", "cong viec");
//		ql.addCano(nv);
//		ql.addCano(nv2);
//		ql.hienThi();

		System.out.print("nhap so nhan vien :");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		QLCB ql = new QLCB(n);
		int ct, ct2;
		boolean a = true, check = false;

		do {

			System.out.println(
					(check ? ("") : ("chuc nang 1: them can bo,")) + " 2: tim kiem can bo,3: hien thi, 4 thoat");
			ct = Integer.parseInt(sc.nextLine());

			switch (ct) {
			case 1:

				for (int i = 0; i < n; i++) {
					System.out.println("loại nhân viên muốn nhập  1:cong nhan ,2: ky su ,3: nhan vien,");
					ct2 = Integer.parseInt(sc.nextLine());
					System.out.println("nhập tên , tuổi , gioi tinh , dia chi ");
					String ten = sc.nextLine();
					int tuoi = Integer.parseInt(sc.nextLine());
					String gioiTinh = sc.nextLine();
					String diaChi = sc.nextLine();
					switch (ct2) {
					case 1: {
						System.out.println("nhap bac cua cong nhan");
						int bac = Integer.parseInt(sc.nextLine());
						CanBo cb = new CongNhan(ten, tuoi, gioiTinh, diaChi, bac);
						ql.addCano(cb);
						break;
					}
					case 2: {
						System.out.println("nganh dao tao");
						String nganh = sc.nextLine();
						CanBo cb = new KySu(ten, tuoi, gioiTinh, diaChi, nganh);
						ql.addCano(cb);
						break;
					}
					case 3: {

						System.out.println(" cong viec");
						String congViec = sc.nextLine();
						CanBo cb = new NhanVien(ten, tuoi, gioiTinh, diaChi, congViec);
						ql.addCano(cb);
						break;
					}

					}
				}
				check = true;
				break;

			case 2: {
				if (ql.cb[0] == null) {
					System.out.println("chua co can bo nao trong danh sach");
				} else {
					System.out.println("nhập tên cán bộ cần tìm" + ql.cb.length);
					String tenCanbo = sc.nextLine();
					System.out.println(ql.timkiem(tenCanbo));
					break;
				}
			}
			case 3: {
				ql.hienThi();
				break;
			}
			case 4: {
				a = false;
			}
			}

//			System.out.println("nhập tên , tuổi , gioi tinh , dia chi , bac (int)");
//			CanBo cb = new NhanVien("ten", 0, "goitinh", "diachi","congviec");
//			ql.addCano(cb);
//			CanBo cb2 = new NhanVien("ten", 0, "goitinh", "diachi","congviec");
//			ql.addCano(cb2);

		} while (a);

//		System.out.println("ay");

	}
}
