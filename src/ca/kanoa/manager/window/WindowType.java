package ca.kanoa.manager.window;

import javax.swing.JInternalFrame;

public enum WindowType {

	CONNECTION_WINDOW(ConnectionWindow.class),
	WELCOME_WINDOW(WelcomeWindow.class),
	CONTACT_ACTION;
	
	private Class<? extends JInternalFrame> windowClass;
	
	private WindowType(Class<? extends JInternalFrame> windowClass) {
		this.windowClass = windowClass;
	}
	
	private WindowType() {
		windowClass = null;
	}
	
	public Class<? extends JInternalFrame> getWindowClass() {
		return this.windowClass;
	}
	
}
