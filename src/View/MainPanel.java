package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private CardLayout cardLayout;

	public MainPanel(ScorePanel score, SubjectPanel subject) {
		this.setLayout(new BorderLayout());
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		score = new ScorePanel(	);
		subject = new SubjectPanel();
		this.add("Subject", subject);
		this.add("Score", score);
	}

	public void change(String actionCommand) {
		cardLayout.show(this, actionCommand);
	}
	

}
