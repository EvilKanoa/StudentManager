package ca.kanoa.manager;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ca.kanoa.manager.window.MainWindow;

public class StudentManager {

	private static MainWindow main;
	
	public static void main(String[] args) {
		
		// load the theme
		try {
			System.out.println("Loading theme...");
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    System.out.println("System theme loaded");
		} catch (UnsupportedLookAndFeelException ex) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				System.out.println("Crossplatform theme loaded");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-2);
		}
		
		// start the ui
		System.out.println("Starting the user interface...");
		main = new MainWindow();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				main.setVisible(true);
			}
		});

	}

	public static MainWindow getWindow() {
		return main;
	}
	
}
