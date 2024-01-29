package tailieu;

import java.util.Scanner;

public class QuanLySach {
	public Scanner sc;
	public int n;
	public int index = 0;
	private TaiLieu[] taiLieu;

	public QuanLySach(Scanner sc) {
//		super();
		this.sc = sc;
		this.n = 0;

	}

	private void addTaiLieu(TaiLieu dtoTaiLieu) {

		n = index + 1;
		if (n == 1) {
//			System.out.println(dtoTaiLieu.toString());
			taiLieu = new TaiLieu[n];
			taiLieu[index] = dtoTaiLieu;
			this.index++;
		} else {
			TaiLieu[] taiLieuS = new TaiLieu[n];
			System.arraycopy(taiLieu, 0, taiLieuS, 0, taiLieu.length);
			taiLieu = taiLieuS;
			taiLieu[index] = dtoTaiLieu;
			this.index++;
		}

	}

	public void createTaiLieu() {
		System.out.println("chọn loại tài liệu muốn thêm 1: sach , 2: tap chi , 3: bao");
		int loai = Integer.parseInt(sc.nextLine());
//		System.err.println("nhập mã tài liệu ");
		String maTaiLieu = Integer.toString(loai);
		System.out.println("nhập tên nhà xuất bản ");
		String tenNXB = sc.nextLine();
		System.out.println("nhập số bản phát hành");
		int soBanPhatHanh = Integer.parseInt(sc.nextLine());
		switch (loai) {
		case 1: {
			System.out.println("nhập tên tác giả ");
			String tenTacGia = sc.nextLine();
			System.out.println("nhập số trang ");
			int soTrang = Integer.parseInt(sc.nextLine());
			TaiLieu sach = new Sach(maTaiLieu, tenNXB, soBanPhatHanh, tenTacGia, soBanPhatHanh);
			addTaiLieu(sach);
			break;
		}
		case 2: {
			System.out.println("nhap so phat hanh ");
			int soPhatHanh = Integer.parseInt(sc.nextLine());
			System.out.println("nhập tháng phát hành ");
			int thangPhatHanh = Integer.parseInt(sc.nextLine());
			TaiLieu tapChi = new TapChi(maTaiLieu, tenNXB, soBanPhatHanh, soPhatHanh, thangPhatHanh);
			addTaiLieu(tapChi);
			break;

		}
		case 3: {
			System.out.println("nhập ngày phát hành ");
			int ngayPhatHanh = Integer.parseInt(sc.nextLine());
			TaiLieu bao = new Bao(maTaiLieu, tenNXB, soBanPhatHanh, ngayPhatHanh);
			addTaiLieu(bao);
			break;
		}
		}

	}

	public void dieuKhien() {

		boolean thoat = false;
		do {
			System.out.println(
					"chọn chức năng 1: tạo sanh sách tài liệu, 2: xóa tài liệu theo mã , 3: hiển thị , 4: tìm kiếm, 5: thoát");
			int crt = Integer.parseInt(sc.nextLine());
			switch (crt) {
			case 1: {
				createTaiLieu();
				break;
			}
			case 2: {
				xoa();
				break;
			}
			case 3: {
				hienThi();
				break;
			}
			case 4: {
				timkiem();
				break;
			}
			case 5: {
				thoat = !thoat;

				return;
			}

			}
		} while (!thoat);
	}

	public void hienThi() {

		System.out.println("__danh sách tài liệu__");
		for (TaiLieu item : taiLieu) {
			if (item == null) {
				continue;
			} else {
				System.out.println(item.toString());
			}
		}
	}

	public void timkiem() {
		System.out.println("chọn loại tài liệu muốn lọc 1: sách , 2: tài liệu , 3: báo");
		int loc = Integer.parseInt(sc.nextLine());
		for (TaiLieu item : taiLieu) {
			if (item == null) {
				continue;
			} else {

				switch (loc) {
				case 1: {
					System.out.println("sach");
					if (item instanceof Sach) {
						System.out.println(item.toString());
					}
					break;

				}
				case 2: {
					System.out.println("tap chi");
					if (item instanceof TapChi) {
						System.out.println(item.toString());
					}
					break;
				}
				case 3: {
					System.out.println("bao");
					if (item instanceof Bao) {
						System.out.println(item.toString());
					}
					break;
				}

				}
			}
		}
	}

	public void xoa() {
		System.out.println(" nhap ma tai lieu muon xóa");
		String maTaiLieu = sc.nextLine();
		for (int i = 0; i < this.taiLieu.length; i++) {

			if (this.taiLieu[i] == null) {
				continue;
			} else {
				if (taiLieu[i].getMaTaiLieu().equals(maTaiLieu)) {
//					System.out.println("ay");
					this.taiLieu[i] = null;
				}
			}
		}
	}

}
