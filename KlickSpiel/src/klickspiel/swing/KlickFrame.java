package klickspiel.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KlickFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private KlickPanel panel;
	private JLabel scoreLabel;
	private JButton newGame;

	public KlickFrame(KlickPanel panel) {
		this.panel = panel;
		this.setSize(1080, 1080);

		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		scoreLabel = new JLabel("Punkte: 0");
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		this.add(BorderLayout.NORTH, scoreLabel);
		newGame = new JButton("Neues Spiel");
		newGame.setFont(new Font("Arial", Font.PLAIN, 16));
		newGame.addActionListener(this);
		this.add(BorderLayout.SOUTH, newGame);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setScore(int anzahlTreffer) {
		scoreLabel.setText("Punkte: " + anzahlTreffer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.restart();
	}

}
