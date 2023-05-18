package Controller;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuListener;

import Model.ManagerStudent;
import Model.Student;
import Model.Subject;
import View.MainPanel;
import View.ScorePanel;
import View.SubjectPanel;

public class StudentController {
	private MainPanel main;
	private ScorePanel score;
	private SubjectPanel subject;
	private ManagerStudent managetStudent = new ManagerStudent();
	private ActionListener menulistener, searchStudentListenerS, searchStudentListenerP, addstudentListener,
			addPointListener;

	public StudentController(MainPanel main) {
		this.main = main;
		// xu kien menu
		menulistener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				main.change(e.getActionCommand());
				if (e.getActionCommand().equals("Exit")) {
					System.exit(0);
				}
			}
		};
	}

	// event SubjectPanel
	public StudentController(SubjectPanel subjectPanel) {
		this.subject = subjectPanel;
		// xu kien search student
		searchStudentListenerS = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				String mssvText = subject.getMssvT().getText().trim();
				if (!mssvText.equals("")) {
					Student student = managetStudent.findStudent(Integer.parseInt(mssvText));
					if (student != null) {
						subjectPanel.searchStudent();
					} else {
						JOptionPane.showMessageDialog(null, "Mã số sinh viên không tồn tại: " + mssvText, "Error..",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập MSSV", mssvText, JOptionPane.CANCEL_OPTION);
				}

			}
		};

		// xu li su kien add student

		this.setAddstudentListener ( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				String mssvText = subject.getMssvT().getText().trim();
				if (!mssvText.equals("")) {
					Student student = managetStudent.findStudent(Integer.parseInt(mssvText));
					if (student != null) {
						String idSubject = subject.getMaMonHocT().getText().trim();
						if (idSubject.length() == 5) {
							String tenMonHoc = subject.getTenMonHocT().getText();
							Subject sub = managetStudent.findSubject(Integer.parseInt(idSubject),
									Integer.parseInt(mssvText), tenMonHoc);
							if (sub == null) {
								subject.addSubject();
							} else {
								JOptionPane.showMessageDialog(null, "Mã môn học hoặc tên môn học đã tồn tại", "Errro",
										JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập mã môn học đủ 5 số", "Errro",
									JOptionPane.WARNING_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Mã số sinh viên không tồn tại: " + mssvText, "Error..",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập MSSV", mssvText, JOptionPane.CANCEL_OPTION);
				}

			}
		});

	}

	// event ScoretPanel
	public StudentController(ScorePanel scorePanel) {
		this.score = scorePanel;
		SubjectPanel sub = new SubjectPanel();
		// xu kien search student
		searchStudentListenerP = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				String idStudent = score.getMssvT().getText().trim();
				if (!idStudent.equals("")) {
					Student student = managetStudent.findStudent(Integer.parseInt(idStudent));
					if (student != null) {
						score.searchStudent();
					} else {
						JOptionPane.showMessageDialog(null, "Mã số sinh viên không tồn tại: " + idStudent, "Eror..",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập MSSV", idStudent, JOptionPane.CANCEL_OPTION);
				}

			}
		};
		// xu li add point
		addPointListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String idStudent = score.getMssvT().getText().trim();
				System.out.println(e.getActionCommand());
				if (!idStudent.equals("")) {
					Student student = managetStudent.findStudent(Integer.parseInt(idStudent));
					if (student != null) {
						Double point = Double.valueOf(score.getDiemMonHocT().getText());
						if (point <= 10.0 && point >= 0) {
							score.addPoint();
						} else {
							JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số điểm từ 0 --> 10", "Error..",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Mã số sinh viên không tồn tại: " + idStudent, "Eror..",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập MSSV", idStudent, JOptionPane.CANCEL_OPTION);
				}
			}

		};

	}

	public ActionListener getMenulistener() {
		return menulistener;
	}

	public void setmenulistener(ActionListener menulistener) {
		this.menulistener = menulistener;
	}

	public ActionListener getSearchStudentListenerS() {
		return searchStudentListenerS;
	}

	public void setSearchStudentListenerS(ActionListener searchStudentListenerS) {
		this.searchStudentListenerS = searchStudentListenerS;
	}

	public ActionListener getSearchStudentListenerP() {
		return searchStudentListenerP;
	}

	public void setSearchStudentListenerP(ActionListener searchStudentListenerP) {
		this.searchStudentListenerP = searchStudentListenerP;
	}

	public ActionListener getAddstudentListener() {
		return addstudentListener;
	}

	public void setAddstudentListener(ActionListener addstudentListener) {
		this.addstudentListener = addstudentListener;
	}

	public ActionListener getAddPointListener() {
		return addPointListener;
	}

	public void setAddPointListener(ActionListener addPointListener) {
		this.addPointListener = addPointListener;
	}

}
