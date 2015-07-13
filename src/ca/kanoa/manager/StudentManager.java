package ca.kanoa.manager;

import java.awt.EventQueue;

import window.MainWindow;

public class StudentManager {

	private static MainWindow main;
	
	public static void main(String[] args) {
		main = new MainWindow();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				main.setVisible(true);
			}
		});
	}

}
