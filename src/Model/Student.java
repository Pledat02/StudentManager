package Model;

import java.util.ArrayList;

public class Student {
	private int id;
	private String name;
	private ArrayList<Subject> listSubject;

	public Student(int id, String name, ArrayList<Subject> subject) {
		this.id = id;
		this.name = name;
		this.listSubject = subject;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	
	public ArrayList<Subject> getListSubject() {
		return listSubject;
	}
	public void setListSubject(ArrayList<Subject> listSubject) {
		this.listSubject = listSubject;
	}
	
	public void addsub(Subject sub) {
		listSubject.add(sub);
	}
	
	

}
