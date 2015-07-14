package ca.kanoa.manager.window.custom;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;

public class LinkLabel extends JLabel {

	private static final long serialVersionUID = -86304114740844966L;
	private static Font font = null;
	
	public LinkLabel(String text) {
		super(text);
		if (font == null) {
			font = new JLabel().getFont();
			try {
				@SuppressWarnings("unchecked")
				Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				font = font.deriveFont(attributes);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		setForeground(Color.blue);
		setFont(font);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

}
