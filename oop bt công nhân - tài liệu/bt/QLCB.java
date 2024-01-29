package bt;

public class QLCB {
	public CanBo [] cb;
	public int index =-1;
	public int n;
	
	public void addCano(CanBo cbs) {
		index++;
		this.cb[index] = cbs;
	}
	
	public String timkiem(String tenCanBo) {
		
		for(CanBo canBo :cb) {
			if(canBo.getHoTen().equals(tenCanBo)) {
				return canBo.toString();
			}
		}
		
		return "khong tim thay";
	}

	public QLCB( int n) {
		super();
		this.n = n;
		this.cb = new CanBo[n];
//		this.index = index;
	}
	
	void hienThi() {
		for(int i=0; i<cb.length; i++) {
			System.out.println(cb[i].toString());
		}
		
	
	}
	
	
	
	
}
