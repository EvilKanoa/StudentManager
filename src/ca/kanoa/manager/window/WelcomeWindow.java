package ca.kanoa.manager.window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;
import ca.kanoa.manager.window.custom.LinkLabel;
import net.miginfocom.swing.MigLayout;

public class WelcomeWindow extends JInternalFrame implements MouseListener {

	private static final long serialVersionUID = 876234987123987L;
	private LinkLabel connectionLabel;
	private LinkLabel contactLabel;
	
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
		
		connectionLabel = new LinkLabel("Open connection window");
		add(connectionLabel);
		
		contactLabel = new LinkLabel("Contact me");
		add(contactLabel);
		
		// resize and reposition
		pack();
		setLocation(x - getBounds().width / 2, y - getBounds().height / 2 - 100);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == connectionLabel) {
			
		} else if (e.getSource() == contactLabel) {
			
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

}
