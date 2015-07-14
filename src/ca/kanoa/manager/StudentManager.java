package ca.kanoa.manager;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import ca.kanoa.manager.window.MainWindow;

public class StudentManager {

	private static MainWindow main;
	
	public static void main(String[] args) {
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException ex) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-2);
		}
		main = new MainWindow();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				main.setVisible(true);
			}
		});
	}
	
	public static String getLookAndFeelClassName(String nameSnippet) {
	    LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
	    for (LookAndFeelInfo info : plafs) {
	        if (info.getName().equalsIgnoreCase(nameSnippet)) {
	            return info.getClassName();
	        }
	    }
	    return null;
	}

}
