package klickspiel.highscore;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;

public class FischHighDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public FischHighDialog(JPanel panel, FischHighscoreList highscore) {
		JTable table = new JTable(new FischHighscoreModel(highscore));
		setTitle("Highscore");
		panel.add(table);
		this.add(panel);
		this.pack();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}
