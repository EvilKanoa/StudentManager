package ca.kanoa.manager.window;

import javax.swing.JInternalFrame;

import net.miginfocom.swing.MigLayout;

public class BrowseWindow extends JInternalFrame {

	private static final long serialVersionUID = 3979123658531738349L;
	private static BrowseWindow instance;
	
	private BrowseWindow() {
		setTitle("Brosw Students");
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setVisible(false);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new MigLayout(
				"wrap 1",
				"[al center]15",
				"15[]15"));
		
		// resize and reposition
		pack();
		setLocation(100, 100);
	}
	
	public static BrowseWindow getWindow() {
		if (instance == null) {
			instance = new BrowseWindow();
		}
		return instance;
	}
}
