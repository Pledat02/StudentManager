package View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controller.StudentController;

public class Frame extends JFrame {
	ScorePanel score;
	SubjectPanel subject;
	MainPanel main;
	public Frame() {
		subject = new SubjectPanel();
		score = new ScorePanel();
		 main = new MainPanel(score,subject);
		this.setSize(500,480);
		this.setTitle("Khoa Công Nghệ Thông Tin");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(false);
		this.setJMenuBar(createMenuBar(main));
		this.getContentPane().add(main);
		this.setVisible(true);
	}

	private JMenuBar createMenuBar(MainPanel main) {
		StudentController stC = new StudentController(main);
		JMenuBar menu = new JMenuBar();
		Font font_jmenu = new Font("Arial",Font.BOLD,17);
		Font font_menuItem = new Font("NewellsHand",Font.ITALIC,15);
		//File
		JMenu menu_File = new JMenu("File");
		menu_File.setFont(font_jmenu);
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E	);
		exit.setFont(font_menuItem );
		exit.addActionListener(stC.getMenulistener());;
		menu_File.add(exit);
		menu.add(menu_File);
		// quan li sinh vien 
		JMenu menu_qlsv = new JMenu("Quản Lí Sinh Viên");
		menu_qlsv.setFont(font_jmenu);
		JMenuItem monHoc = new JMenuItem("Quản Lí Môn Học"+ "                  " +"S");
		monHoc.setMnemonic(KeyEvent.VK_S);
		monHoc.setPreferredSize(new Dimension(250,30));
		monHoc.setFont(font_menuItem);
		menu_qlsv.add(monHoc);	
		monHoc.addActionListener(stC.getMenulistener());
		monHoc.setActionCommand("Subject");
		
		JMenuItem diem = new JMenuItem("Quản Lí Điểm " + "                       " +"P");
		diem.setPreferredSize(new Dimension(250,30));
		diem.setMnemonic(KeyEvent.VK_P);
		diem.setFont(font_menuItem);
		menu_qlsv.add(diem);
		menu.add(menu_qlsv);
		diem.addActionListener(stC.getMenulistener());
		diem.setActionCommand("Score");
		
		return menu;
	}

	public static void main(String[] args) {
		new Frame();
	}
}
