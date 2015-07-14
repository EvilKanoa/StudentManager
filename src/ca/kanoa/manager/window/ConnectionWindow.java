package ca.kanoa.manager.window;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ConnectionWindow extends JInternalFrame {

	private static final long serialVersionUID = 8505887846013928043L;
	private JTextField fHost;
	private JTextField fPort;
	private JTextField fUser;
	private JPasswordField fPass;
	private JTextField fDatabase;
	private JProgressBar progress;

	public ConnectionWindow() {
		setTitle("Connect");
		setBounds(100, 100, 230, 300);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setVisible(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new MigLayout(
				"wrap 2",
				"[]15[]",
				"[][][][][]10%[][]"));
		
		JLabel lblHost = new JLabel("Host");
		getContentPane().add(lblHost);
		fHost = new JTextField("127.0.0.1");
		getContentPane().add(fHost);
		fHost.setColumns(15);
		
		JLabel lblPort = new JLabel("Port");
		getContentPane().add(lblPort);
		fPort = new JTextField("3306");
		getContentPane().add(fPort);
		fPort.setColumns(15);
		
		JLabel lblUsername = new JLabel("Username");
		getContentPane().add(lblUsername);
		fUser = new JTextField();
		getContentPane().add(fUser);
		fUser.setColumns(15);

		JLabel lblPassword = new JLabel("Password");
		getContentPane().add(lblPassword);
		fPass = new JPasswordField();
		getContentPane().add(fPass);
		fPass.setColumns(15);
		
		JLabel lblDatabase = new JLabel("Database");
		getContentPane().add(lblDatabase);
		fDatabase = new JTextField("minecraft");
		getContentPane().add(fDatabase);
		fDatabase.setColumns(15);
		
		progress = new JProgressBar(0, 10);
		getContentPane().add(progress, "al center, span 2");
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setToolTipText("Connect to database specified "
				+ "using user supplied details.");
		btnConnect.setActionCommand("connect");
		btnConnect.setBorderPainted(true);
		getContentPane().add(btnConnect, "al center, span 2");
	}

}
