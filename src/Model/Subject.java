package Model;

public class Subject {
	private int id;
	private String nameSub;
	private double point;

	public Subject(int id, String nameSub, double point) {
		this.id = id;
		this.nameSub = nameSub;
		this.point = point;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameSub() {
		return nameSub;
	}

	public void setNameSub(String nameSub) {
		this.nameSub = nameSub;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public void addPoint(double point, String nameSub) {
		if (this.getNameSub().equals(nameSub)) {
			this.point=point;
		}
	}
	
	
	

}
