package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.Border;

import Controller.StudentController;
import Model.ManagerStudent;
import Model.Subject;

public class SubjectPanel extends JPanel {
	private JLabel mssvL, hoVaTenL, maMonHocL, tenMonHocL;
	JTextField mssvT, hoVaTenT, maMonHocT, tenMonHocT;
	public JTextArea area;
	private ManagerStudent managerStu;
	JButton themMonHoc_Button, timSinhVien_Button;

	public SubjectPanel() {
		this.topPanel();
		this.centerPanel();
		this.bottomrPanel();
		managerStu = new ManagerStudent();

	}

	private void topPanel() {
		this.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		Border topBorder = BorderFactory.createLineBorder(Color.gray);
		topPanel.setBorder(BorderFactory.createTitledBorder(topBorder, "Thêm Môn Học"));
		// mssv
		JPanel mssv_panel = new JPanel();
		mssv_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mssvL = new JLabel("MSSV");
		setMssvT(new JTextField());
		getMssvT().setPreferredSize(new Dimension(200, 30));
		mssv_panel.add(mssvL);
		mssv_panel.add(getMssvT());
		topPanel.add(mssv_panel);

		// ho va ten
		JPanel hoVaTen_panel = new JPanel();
		hoVaTen_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		hoVaTenL = new JLabel("Họ Và Tên");
		hoVaTenT = new JTextField();
		hoVaTenT.setEditable(false);
		hoVaTenT.setPreferredSize(new Dimension(200, 30));
		hoVaTen_panel.add(hoVaTenL);
		hoVaTen_panel.add(hoVaTenT);
		topPanel.add(hoVaTen_panel);

		// ma mon hoc
		JPanel maMonHoc_panel = new JPanel();
		maMonHoc_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		maMonHocL = new JLabel("Mã Môn Học");
		maMonHocT = new JTextField();
		maMonHocT.setPreferredSize(new Dimension(200, 30));
		maMonHoc_panel.add(maMonHocL);
		maMonHoc_panel.add(maMonHocT);
		topPanel.add(maMonHoc_panel);

		// ten mon hoc
		JPanel tenMonHoc_panel = new JPanel();
		tenMonHoc_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		tenMonHocL = new JLabel("Tên Môn Học");
		setTenMonHocT(new JTextField());
		getTenMonHocT().setPreferredSize(new Dimension(200, 30));
		tenMonHoc_panel.add(tenMonHocL);
		tenMonHoc_panel.add(getTenMonHocT());
		topPanel.add(tenMonHoc_panel);

		this.add(topPanel, BorderLayout.NORTH);
	}

	private void centerPanel() {

		StudentController sc = new StudentController(this);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());

		Border centerBorder = BorderFactory.createLineBorder(Color.gray);
		centerPanel.setBorder(BorderFactory.createTitledBorder(centerBorder, "Thao Tác"));
		// button
		themMonHoc_Button = new JButton("Thêm Môn Học");
		themMonHoc_Button.addActionListener(sc.getAddstudentListener());
		centerPanel.add(themMonHoc_Button);
		timSinhVien_Button = new JButton("Tìm Sinh Viên");
		timSinhVien_Button.addActionListener(sc.getSearchStudentListenerS());;
		timSinhVien_Button.setActionCommand("Tìm Sinh Viên Subject");
		centerPanel.add(timSinhVien_Button);

		this.add(centerPanel, BorderLayout.CENTER);
	}

	private void bottomrPanel() {
		area = new JTextArea(10, 200);
		area.append(ManagerStudent.fomatData(" Stt", "Tên Môn Học", "Điểm").toUpperCase());
		JScrollPane jscrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(jscrollPane, BorderLayout.SOUTH);

	}

	// xu li su kien
	public void searchStudent() {

		int id = Integer.parseInt(this.getMssvT().getText().trim());
		this.area.setText(ManagerStudent.fomatData("Stt", "Tên Môn Học", "Điểm").toUpperCase() 
				+ managerStu.searchByIdToArea(id));
		this.hoVaTenT.setText(managerStu.searchByIdToText(id));
	}

	public void addSubject()  {
		
			int idStudent = Integer.parseInt(this.getMssvT().getText().trim());
			int idSubject = Integer.parseInt(this.maMonHocT.getText().trim());
			String tenMonHoc = this.getTenMonHocT().getText();
			Subject subject = new Subject(idSubject, tenMonHoc, 0);
			getManagerStu().addSubject(idStudent, subject);
			this.searchStudent();
		
		

	}

	public JTextField getMaMonHocT() {
		return maMonHocT;
	}

	public void setMaMonHocT(JTextField maMonHocT) {
		this.maMonHocT = maMonHocT;
	}

	public JTextField getMssvT() {
		return mssvT;
	}

	public void setMssvT(JTextField mssvT) {
		this.mssvT = mssvT;
	}

	public JTextField getTenMonHocT() {
		return tenMonHocT;
	}

	public void setTenMonHocT(JTextField tenMonHocT) {
		this.tenMonHocT = tenMonHocT;
	}

	public ManagerStudent getManagerStu() {
		return managerStu;
	}

	public void setManagerStu(ManagerStudent managerStu) {
		this.managerStu = managerStu;
	}

}
