package Model;

import java.util.ArrayList;
import java.util.List;

public class ManagerStudent {
	private ArrayList<Student> ListStudent = new ArrayList<Student>();
	ArrayList<Subject> listSubA = new ArrayList<Subject>();
	ArrayList<Subject> listSubB = new ArrayList<Subject>();
	ArrayList<Subject> listSubC = new ArrayList<Subject>();
	ArrayList<Subject> listSubD = new ArrayList<Subject>();
	ArrayList<Subject> listSubE = new ArrayList<Subject>();
	public ManagerStudent() {
		this.mai1n();
	}


	public String searchByIdToText(int id) {
		String result = "";
		for (Student student : ListStudent) {
			if (student.getId() == id) {
				result = student.getName();
			}
		}
		return result;
	}


	
	public String searchByIdToArea(int id) {
		String result = "";
		int count = 1;
		
		for (Student student : ListStudent) {
			if (student.getId() == id) {
				
				for (Subject subject : student.getListSubject()) {
					result += fomatData("  "+count, subject.getNameSub(), String.valueOf(subject.getPoint())) ;
					count++;
				}
			}
		}
		return result;
	}

	public void mai1n() {
		// Danh sach mon hoc cua sinh vien A
		Subject toanA = new Subject(12312, "Toán Cao Cấp", 8.5);
		Subject LTNCA = new Subject(18282, "Lập Trình Nâng Cao", 8.0);
		Subject CTMTA = new Subject(20312, "Cấu Trúc Máy Tính", 10.0);
		Subject HDHA = new Subject(41112, "Hệ Điều Hành", 10.0);
		listSubA.add(toanA);
		listSubA.add(LTNCA);
		listSubA.add(CTMTA);
		listSubA.add(HDHA);
		Student nam = new Student(1, "Phạm Văn Nam", listSubA);
		this.ListStudent.add(nam);
		// Danh sach mon hoc cua sinh vien B
		Subject toanB = new Subject(12312, "Toán Cao Cấp", 5.5);
		Subject LTNCB = new Subject(18282, "Lập Trình Nâng Cao", 7.0);
		Subject CTMTB = new Subject(20312, "Cấu Trúc Máy Tính", 3.0);
		Subject HDHB = new Subject(41112, "Hệ Điều Hành", 4.0);
		listSubB.add(toanB);
		listSubB.add(LTNCB);
		listSubB.add(CTMTB);
		listSubB.add(HDHB);
		Student ha = new Student(2, "Lê Thị Hà", listSubB);
		this.ListStudent.add(ha);
		// Danh sach mon hoc cua sinh vien C
		Subject toanC = new Subject(12312, "Toán Cao Cấp", 7.5);
		Subject LTNCC = new Subject(18282, "Lập Trình Nâng Cao", 8.0);
		Subject CTMTC = new Subject(20312, "Cấu Trúc Máy Tính", 8.0);
		Subject HDHC = new Subject(41112, "Hệ Điều Hành", 2.0);
		listSubC.add(toanC);
		listSubC.add(LTNCC);
		listSubC.add(CTMTC);
		listSubC.add(HDHC);
		Student anh = new Student(3, "Nguyễn Hồng Anh", listSubC);
		this.ListStudent.add(anh);
		// Danh sach mon hoc cua sinh vien B
		Subject toanD = new Subject(12312, "Toán Cao Cấp", 1.5);
		Subject LTNCD = new Subject(18282, "Lập Trình Nâng Cao", 2.0);
		Subject CTMTD = new Subject(20312, "Cấu Trúc Máy Tính", 2.0);
		Subject HDHD = new Subject(41112, "Hệ Điều Hành", 4.0);
		listSubD.add(toanD);
		listSubD.add(LTNCD);
		listSubD.add(CTMTD);
		listSubD.add(HDHD);
		Student Minh = new Student(4, "Nguyễn Tấn Minh", listSubD);
		this.ListStudent.add(Minh);
		// Danh sach mon hoc cua sinh vien B
		Subject toanE = new Subject(12312, "Toán Cao Cấp", 5.5);
		Subject LTNCE = new Subject(18282, "Lập Trình Nâng Cao", 7.0);
		Subject CTMTE = new Subject(20312, "Cấu Trúc Máy Tính", 3.0);
		Subject HDHE = new Subject(41112, "Hệ Điều Hành", 4.0);
		listSubE.add(toanE);
		listSubE.add(LTNCE);
		listSubE.add(CTMTE);
		listSubE.add(HDHE);
		Student vy = new Student(5, "Lê Tường Vy", listSubE);
		this.ListStudent.add(vy);

	}

	public ArrayList<Student> getListStudent() {
		return ListStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		ListStudent = listStudent;
	}

	// them mon hoc
	public void addSubject(int idstudent, Subject sub)  {
		for (Student student : ListStudent) {
			if (idstudent == student.getId()) {
				
				student.addsub(sub);
			}
		}

	}

	// comboBox for ScorePanel
	public String[] comboBox_Subject(int idstudent) {
		int size = 0;
		for (Student student : ListStudent) {
			if (idstudent == student.getId()) {
				size = student.getListSubject().size();
			}
		}
		String[] result = new String[size];
		for (Student student : ListStudent) {
			if (idstudent == student.getId()) {
				for (int i = 0; i < student.getListSubject().size(); i++) {
					result[i] = student.getListSubject().get(i).getId()+"  "+student.getListSubject().get(i).getNameSub();

				}
			}
		}
		return result;
	}

	// ten mon hoc
	public void addPoint(double point, String nameSubject, int idStudent) {
		for (Student student : ListStudent) {
			if (student.getId() == idStudent) {
				for (Subject subject : student.getListSubject()) {
					if (nameSubject.equals(subject.getNameSub())) {
						subject.setPoint(point);
					}
				}
			}
		}
	}
	public static String fomatData(String stt, String ten, String diem) {
		while (stt.length() < 5  &&  ten.length() < 80  &&  diem.length() < 5) {
			if (stt.length() < 5) {
				stt += " ";
			}
			if (ten.length() < 80) {
				ten += " ";
			}
			if (diem.length() < 5) {
				diem += " ";
			}
		}
		return stt + "\t" + ten + "\t" + diem + "\n";
	}
	public Student findStudent(int idstudent)  {
		Student result = null;
		for (Student student : ListStudent) {
			if (idstudent == student.getId()) {
				result=student;
			}
		}
		return result;
	}	
	public Subject findSubject(int idsubject,int idStudent,String nameSub)  {
		Subject result = null;
		Student student = findStudent(idStudent);
		for (Subject subject : student.getListSubject()) {
			if(subject.getId()==idsubject &&subject.getNameSub().equals(nameSub)) {
				result = subject;
			}
		}
		return result;
	}		
			

	public static void main(String[] args)  {
		ManagerStudent m = new ManagerStudent();
		m.addSubject(2, new Subject(1, "aaaa", 0));
		
		for (String string : m.comboBox_Subject(2)) {
			System.out.println(string);
		}
	}

}
