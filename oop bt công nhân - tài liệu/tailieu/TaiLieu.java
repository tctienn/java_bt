package tailieu;

public class TaiLieu {
	private String maTaiLieu;
	private String tenNSB;
	private int soBanPhatHanh;

	public TaiLieu(String maTaiLieu, String tenNSB, int soPhatHanh) {
		super();
		this.maTaiLieu = maTaiLieu;
		this.tenNSB = tenNSB;
		this.soBanPhatHanh = soPhatHanh;
	}

	public TaiLieu() {
		super();
	}

	public String getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public String getTenNSB() {
		return tenNSB;
	}

	public void setTenNSB(String tenNSB) {
		this.tenNSB = tenNSB;
	}

	public int getSoBanPhatHanh() {
		return soBanPhatHanh;
	}

	public void setSoBanPhatHanh(int soPhatHanh) {
		this.soBanPhatHanh = soPhatHanh;
	}

	@Override
	public String toString() {
		return "TaiLieu [maTaiLieu=" + maTaiLieu + ", tenNSB=" + tenNSB + ", soBanPhatHanh=" + soBanPhatHanh + "]";
	}

}
