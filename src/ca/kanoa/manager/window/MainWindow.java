package ca.kanoa.manager.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import ca.kanoa.manager.StudentManager;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class MainWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = -3475707702556552739L;
	private JDesktopPane desktop;
	private Set<Runnable> quitListeners;

	public MainWindow() {
		setTitle("Student Manager");
		initialize();
		quitListeners = new HashSet<Runnable>();
	}

	private void initialize() {
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(createMenuBar());

		JLabel background = new JLabel();
		try {
			BufferedImage img = ImageIO.read(StudentManager.class.getResource("/img/background.jpg"));
			background.setIcon(new ImageIcon(img));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to load background image");
		}
		background.setLayout(new BorderLayout());
		setContentPane(background);

		desktop = new JDesktopPane();
		desktop.setOpaque(false);
		
		desktop.add(WelcomeWindow.getWindow());
		desktop.add(ConnectionWindow.getWindow());
		desktop.add(BrowseWindow.getWindow());
		
		getContentPane().add(desktop);
		
		openWindow(WelcomeWindow.getWindow());
	}

	private JMenuBar createMenuBar() {
		JMenuBar menu = new JMenuBar();
		menu.setBackground(Color.green);

		JMenu actionMenu = new JMenu("Action");
		actionMenu.setMnemonic('A');
		actionMenu.setBackground(Color.green);
		menu.add(actionMenu);

		JMenuItem connectItem = new JMenuItem(
				"Connect to Database", 
				KeyEvent.VK_D);
		connectItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		connectItem.setActionCommand("connect");
		connectItem.addActionListener(this);
		actionMenu.add(connectItem);

		JMenuItem browseItem = new JMenuItem(
				"Browse Students", 
				KeyEvent.VK_B);
		browseItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		browseItem.setActionCommand("browse");
		browseItem.addActionListener(this);
		actionMenu.add(browseItem);

		JMenuItem quitItem = new JMenuItem(
				"Quit", 
				KeyEvent.VK_Q);
		quitItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		quitItem.setActionCommand("quit");
		quitItem.addActionListener(this);
		actionMenu.add(quitItem);

		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		helpMenu.setBackground(Color.green);
		menu.add(helpMenu);

		JMenuItem welcomeItem = new JMenuItem(
				"Welcome Screen", 
				KeyEvent.VK_W);
		welcomeItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		welcomeItem.setActionCommand("welcome");
		welcomeItem.addActionListener(this);
		helpMenu.add(welcomeItem);

		JMenuItem contactMeItem = new JMenuItem("Contact Me");
		contactMeItem.setActionCommand("contact");
		contactMeItem.addActionListener(this);
		helpMenu.add(contactMeItem);

		return menu;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("connect")) {
			openWindow(ConnectionWindow.getWindow());
		} else if (event.getActionCommand().equals("quit")) {
			quit();
		} else if (event.getActionCommand().equals("contact")) {
			mailTo("kanoa@kanoa.ca", "Support");
		} else if (event.getActionCommand().equals("welcome")) {
			openWindow(WelcomeWindow.getWindow());
		} else if (event.getActionCommand().equals("browse")) {
			openWindow(BrowseWindow.getWindow());
		}
	}
	
	public static void openWindow(JInternalFrame window) {
		window.setVisible(true);
		selectWindow(window);
	}

	public static void selectWindow(JInternalFrame window) {
		try {
			window.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	private void quit() {
		for (Runnable listener : quitListeners) {
			listener.run();
		}
		System.exit(0);
	}

	public void addQuitListener(Runnable listener) {
		quitListeners.add(listener);
	}

	public static void mailTo(String to, String subject) {
		try {
			String mailTo = String.format(
					"mailto:%s?subject=%s", 
					URLEncoder.encode(to, "UTF-8"), 
					URLEncoder.encode(subject, "UTF-8"));
			Desktop.getDesktop().browse(new URI(mailTo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
