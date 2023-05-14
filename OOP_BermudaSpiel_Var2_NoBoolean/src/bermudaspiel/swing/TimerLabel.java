package bermudaspiel.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import bermudaspiel.main.BermudaSpiel;

public class TimerLabel extends JLabel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static TimerLabel instance;
	Timer timer = new Timer(1000, this);
	int secCounter;
	JLabel timerLabel;
	private BermudaSpiel bermudaSpiel;

	private TimerLabel() {
		setHorizontalAlignment(JLabel.CENTER);
		start();
		setText("Zeit: " + secCounter);
		timer.setRepeats(true);
	}

	public static TimerLabel getInstance() {
		if (instance == null) {
			instance = new TimerLabel();
		}
		return instance;
	}

	public void start() {
		timer.start();
		secCounter = 0;
	}

	public int stop() {
		timer.stop();
		return secCounter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		secCounter++;
		setText("Zeit: " + secCounter);
	}
}
