package bermudaspiel.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import bermudaspiel.main.BermudaSpiel;

public class BermudaFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private BermudaPanel bermudapanel;
	private TimerLabel timerLabel;

	public BermudaFrame(BermudaPanel bermudapanel) {
		this.bermudapanel = bermudapanel;
		TimerLabel timerLabel = TimerLabel.getInstance();
		JButton button = new JButton("Neues Spiel");
		button.addActionListener(this);
		this.setSize(400, 300);
		this.setLayout(new BorderLayout());
		this.add(timerLabel, BorderLayout.NORTH);
		this.add(button, BorderLayout.SOUTH);
		this.add(bermudapanel, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new BermudaSpiel(4);
		this.setVisible(false);
		TimerLabel.getInstance().start();
	}

}
