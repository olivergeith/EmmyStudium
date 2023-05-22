package bermudaspiel;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;

public class HighDialog extends JDialog {
	JDialog highscore = new JDialog();

	public HighDialog(JPanel panel) {
		JTable table = new JTable(new HighscoreModel());
	}
}
