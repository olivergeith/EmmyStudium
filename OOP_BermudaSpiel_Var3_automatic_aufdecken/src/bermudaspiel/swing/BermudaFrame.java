package bermudaspiel.swing;
import javax.swing.JFrame;

public class BermudaFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public BermudaFrame(BermudaPanel bermudaPanel) {
		this.add(bermudaPanel);
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
