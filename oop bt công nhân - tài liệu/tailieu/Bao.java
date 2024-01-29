package tailieu;

public class Bao extends TaiLieu {
	private int ngayPhatHanh;

	public Bao(String maTaiLieu, String tenNSB, int soPhatHanh, int ngayPhatHanh) {
		super(maTaiLieu, tenNSB, soPhatHanh);
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public Bao(String maTaiLieu, String tenNSB, int soPhatHanh) {
		super(maTaiLieu, tenNSB, soPhatHanh);
	}

	public int getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(int ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

	@Override
	public String toString() {
		return "Bao [ngayPhatHanh=" + ngayPhatHanh + ", toString()=" + super.toString() + "]";
	}

}
