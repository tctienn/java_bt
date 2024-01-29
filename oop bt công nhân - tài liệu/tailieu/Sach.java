package tailieu;

public class Sach extends TaiLieu {
	private String tenTacGia;
	private int soTrang;

	public Sach(String maTaiLieu, String tenNSB, int soPhatHanh, String tenTacGia, int soTrang) {
		super(maTaiLieu, tenNSB, soPhatHanh);
		this.tenTacGia = tenTacGia;
		this.soTrang = soTrang;
	}

	public Sach(String maTaiLieu, String tenNSB, int soPhatHanh) {
		super(maTaiLieu, tenNSB, soPhatHanh);
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	@Override
	public String toString() {
		return "Sach [tenTacGia=" + tenTacGia + ", soTrang=" + soTrang + ", toString()=" + super.toString() + "]";
	}

}
