package ca.kanoa.manager.window;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;

public class WelcomeWindow extends JInternalFrame {

	private static final long serialVersionUID = 876234987123987L;

	public WelcomeWindow(int x, int y) {
		setTitle("Welcome");
		setBounds(x - 230 / 2, y - 300 / 2, 230, 300);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new MigLayout(
				"wrap 2",
				"[]15[]",
				"[][][][][]10%[][]"));
	}

}
