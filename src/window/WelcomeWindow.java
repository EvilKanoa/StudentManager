package window;

import javax.swing.JFrame;

public class WelcomeWindow extends JFrame {

	private static final long serialVersionUID = 876234987123987L;

	public WelcomeWindow() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
