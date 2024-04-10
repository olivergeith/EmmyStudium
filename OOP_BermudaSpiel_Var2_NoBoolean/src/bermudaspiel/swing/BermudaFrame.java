package bermudaspiel.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BermudaFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private BermudaPanel bermudapanel;
	private TimerLabel timerLabel;

	public BermudaFrame(BermudaPanel bermudapanel) {
		this.bermudapanel = bermudapanel;
		TimerLabel timerLabel = TimerLabel.getInstance();
		JButton button = new JButton("Neues Spiel");
		button.addActionListener(bermudapanel);
		this.setSize(400, 300);
		this.setLayout(new BorderLayout());
		this.add(timerLabel, BorderLayout.NORTH);
		this.add(button, BorderLayout.SOUTH);
		this.add(bermudapanel, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
