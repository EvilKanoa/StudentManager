package ca.kanoa.manager.window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;

import ca.kanoa.manager.window.custom.LinkLabel;
import net.miginfocom.swing.MigLayout;

public class WelcomeWindow extends JInternalFrame implements MouseListener {

	private static final long serialVersionUID = 876234987123987L;
	private static WelcomeWindow instance;
	private LinkLabel connectionLabel;
	private LinkLabel contactLabel;
	private LinkLabel browseLabel;
	
	private WelcomeWindow() {
		setTitle("Welcome");
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setVisible(false);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new MigLayout(
				"wrap 1",
				"[al center]15",
				"15[]15"));
		
		connectionLabel = new LinkLabel("Open connection window");
		connectionLabel.addMouseListener(this);
		add(connectionLabel);
		
		contactLabel = new LinkLabel("Contact me");
		contactLabel.addMouseListener(this);
		add(contactLabel);
		
		browseLabel = new LinkLabel("Browse students");
		browseLabel.addMouseListener(this);
		add(browseLabel);
		
		// resize and reposition
		pack();
		setLocation(350, 200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == connectionLabel) {
			MainWindow.openWindow(ConnectionWindow.getWindow());
		} else if (e.getSource() == contactLabel) {
			MainWindow.mailTo("kanoa@kanoa.ca", "Support");
		} else if (e.getSource() == browseLabel) {
			MainWindow.openWindow(BrowseWindow.getWindow());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	public static WelcomeWindow getWindow() {
		if (instance == null) {
			instance = new WelcomeWindow();
		}
		return instance;
	}

}
