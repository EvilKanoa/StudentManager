package ca.kanoa.manager.window;

import javax.swing.JInternalFrame;
import ca.kanoa.manager.window.custom.LinkLabel;
import net.miginfocom.swing.MigLayout;

public class WelcomeWindow extends JInternalFrame {

	private static final long serialVersionUID = 876234987123987L;

	public WelcomeWindow(int x, int y) {
		setTitle("Welcome");
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new MigLayout(
				"wrap 1",
				"[al center]15",
				"15[]15"));
		
		LinkLabel connectionLabel = new LinkLabel("Open connection window");
		add(connectionLabel);
		
		LinkLabel contactLabel = new LinkLabel("Contact me");
		add(contactLabel);
		
		// resize and reposition
		pack();
		setLocation(x - getBounds().width / 2, y - getBounds().height / 2 - 100);
	}

}
