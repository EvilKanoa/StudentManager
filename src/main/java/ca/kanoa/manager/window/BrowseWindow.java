package ca.kanoa.manager.window;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTable;

public class BrowseWindow extends JInternalFrame {

	private static final long serialVersionUID = 3979123658531738349L;
	private static BrowseWindow instance;
	private JTable table;
	
	public BrowseWindow() {
		setTitle("Browse Students");
		setResizable(true);
		setClosable(true);
		setIconifiable(false);
		setVisible(false);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
//		getContentPane().setLayout(new MigLayout(
//				"wrap 1",
//				"[al center]15",
//				"15[]15"));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(new Object[][]{{true, false, 17},{"kanoa", "haley", 16}}, new String[]{"Head 1", "head 2", "...so on"});
        table.setPreferredScrollableViewportSize(new Dimension(300, 400));
        table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
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
