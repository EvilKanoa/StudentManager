package ca.kanoa.manager;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.skife.jdbi.v2.DBI;

import ca.kanoa.manager.sql.StudentsDAO;
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
		
		System.out.println("connection...");
		DBI db = new DBI("jdbc:mysql://kanoaca.fatcowmysql.com:3306/kanoa_test", 
				"kanoa", "kphaley");
		System.out.println("connected");
		
		StudentsDAO dao = db.open(StudentsDAO.class);
		dao.init();
		System.out.println("running commands...");
		dao.addStudent("Kanoa's Child", "", "", "", "", "", "", 0, 0, "", "");
		System.out.println(dao.getStudentByID(0));
		dao.close();
	}

	public static MainWindow getWindow() {
		return main;
	}
	
}
