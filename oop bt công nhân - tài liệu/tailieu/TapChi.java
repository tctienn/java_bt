package tailieu;

public class TapChi extends TaiLieu {
	private int soPhatHanh;
	private int thangPhatHanh;

	public TapChi(String maTaiLieu, String tenNSB, int soPhatHanh, int soPhatHanh2, int thangPhatHanh) {
		super(maTaiLieu, tenNSB, soPhatHanh);
		soPhatHanh = soPhatHanh2;
		this.thangPhatHanh = thangPhatHanh;
	}

	public TapChi(String maTaiLieu, String tenNSB, int soPhatHanh) {
		super(maTaiLieu, tenNSB, soPhatHanh);
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public int getThangPhatHanh() {
		return thangPhatHanh;
	}

	public void setThangPhatHanh(int thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}

	@Override
	public String toString() {
		return "TapChi [soPhatHanh=" + soPhatHanh + ", thangPhatHanh=" + thangPhatHanh + ", toString()="
				+ super.toString() + "]";
	}

}
