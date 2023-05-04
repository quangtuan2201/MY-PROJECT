package bean;

public class Student {
	private String msv;
	private String hoTen;
	private String gioiTinh;

	public Student(String msv, String hoTen, String gioiTinh) {
		this.msv = msv;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
	}
	public String getMsv() {
		return msv;
	}

	public void setMsv(String msv) {
		this.msv = msv;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
