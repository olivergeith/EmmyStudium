package bermudaspiel;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;

public class HighDialog extends JDialog {

	public HighDialog(JPanel panel, Highscore highscore) {
		JTable table = new JTable(new HighscoreModel(highscore));
		panel.add(table);
		this.add(panel);
		this.pack();
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}
