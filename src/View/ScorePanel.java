package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.Border;

import Controller.StudentController;
import Model.ManagerStudent;

public class ScorePanel extends JPanel {

	private JLabel mssvL, hoVaTenL, diemMonHocL, tenMonHocL;
	private JTextField mssvT, hoVaTenT, diemMonHocT;
	private JTextArea area;
	private ManagerStudent managerStu;
	DefaultComboBoxModel<String> tenMonHoc_ComboBox;

	public ScorePanel() {
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
		setHoVaTenT(new JTextField());
		getHoVaTenT().setEditable(false);
		getHoVaTenT().setPreferredSize(new Dimension(200, 30));
		hoVaTen_panel.add(hoVaTenL);
		hoVaTen_panel.add(getHoVaTenT());
		topPanel.add(hoVaTen_panel);

		// ten mon hoc
		JPanel tenMonHoc_panel = new JPanel();
		tenMonHoc_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		tenMonHocL = new JLabel("Môn Học");
		tenMonHoc_panel.add(tenMonHocL);
//		String[] tenMonHoc_ComboBox = {"Tên Môn Học"};
		tenMonHoc_ComboBox = new DefaultComboBoxModel<String>();
		tenMonHoc_ComboBox.addElement("Tên Môn Học");
		JComboBox<String> sub = new JComboBox<>(tenMonHoc_ComboBox);
		sub.setPreferredSize(new Dimension(200, 30));

		tenMonHoc_panel.add(sub);
		topPanel.add(tenMonHoc_panel);

		// ma mon hoc
		JPanel diemMonHoc_panel = new JPanel();
		diemMonHoc_panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		diemMonHocL = new JLabel("Điểm");
		setDiemMonHocT(new JTextField());
		getDiemMonHocT().setPreferredSize(new Dimension(200, 30));
		diemMonHoc_panel.add(diemMonHocL);
		diemMonHoc_panel.add(getDiemMonHocT());
		topPanel.add(diemMonHoc_panel);

		this.add(topPanel, BorderLayout.NORTH);
	}

	private void centerPanel() {
		StudentController sc = new StudentController(this);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());

		Border centerBorder = BorderFactory.createLineBorder(Color.gray);
		centerPanel.setBorder(BorderFactory.createTitledBorder(centerBorder, "Thao Tác"));
		// button
		JButton themMonHoc_Button = new JButton("Thêm Điểm");
		themMonHoc_Button.addActionListener(sc.getAddPointListener());
		centerPanel.add(themMonHoc_Button);
		JButton timSinhVien_Button = new JButton("Tìm Sinh Viên");
		timSinhVien_Button.addActionListener(sc.getSearchStudentListenerP());
		timSinhVien_Button.setActionCommand("Tìm Sinh Viên Score");
		centerPanel.add(timSinhVien_Button);

		this.add(centerPanel, BorderLayout.CENTER);
	}

	private void bottomrPanel() {
		area = new JTextArea(9,200);
		area.append(ManagerStudent.fomatData("Stt", "Tên Môn Học", "Điểm").toUpperCase());
		area.setEditable(false);
		JScrollPane jscrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(jscrollPane, BorderLayout.SOUTH);
	}

	public void searchStudent() {
		int id = Integer.parseInt(this.getMssvT().getText().trim());
		this.getHoVaTenT().setText(managerStu.searchByIdToText(id));
		this.area.setText(ManagerStudent.fomatData(" Stt", "Tên Môn Học", "Điểm").toUpperCase()
				+ this.managerStu.searchByIdToArea(id));
		String[] comboSub = managerStu.comboBox_Subject(id);
		tenMonHoc_ComboBox.removeAllElements();
		for (int i = 0; i < comboSub.length; i++) {
			tenMonHoc_ComboBox.addElement(comboSub[i]);

		}

	}
//	public void addSubject() {
//		String tenmonhoc = subPane.getTenMonHocT().getText();
//		String idstudent = subPane.getMssvT().getText();
//		String idsubject = subPane.getMaMonHocT().getText();
//		Subject subject = new Subject(Integer.parseInt(idsubject),tenmonhoc,0);
//		managerStu.addSubject(Integer.parseInt(idstudent),subject);
//	}

	public void addPoint() {
		int id = Integer.parseInt(this.getMssvT().getText());
		String namesub = (String) tenMonHoc_ComboBox.getSelectedItem();
		namesub=namesub.substring(7,namesub.length());
		System.out.println(namesub);
		double point = Double.valueOf(getDiemMonHocT().getText().trim());
		managerStu.addPoint(point,namesub, id);
		this.getHoVaTenT().setText(managerStu.searchByIdToText(id));
		this.area.setText(ManagerStudent.fomatData(" Stt", "Tên Môn Học", "Điểm").toUpperCase()
				+ this.managerStu.searchByIdToArea(id));
	}

	public JTextField getHoVaTenT() {
		return hoVaTenT;
	}

	public void setHoVaTenT(JTextField hoVaTenT) {
		this.hoVaTenT = hoVaTenT;
	}

	public JTextField getMssvT() {
		return mssvT;
	}

	public void setMssvT(JTextField mssvT) {
		this.mssvT = mssvT;
	}

	public JTextField getDiemMonHocT() {
		return diemMonHocT;
	}

	public void setDiemMonHocT(JTextField diemMonHocT) {
		this.diemMonHocT = diemMonHocT;
	}

}
