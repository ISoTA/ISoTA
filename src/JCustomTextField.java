import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JCustomTextField extends JTextField
{
	private Font originalFont;
	private Color originalForeground;
	/** Grey by default* */
	private Color placeholderForeground = new Color(160, 160, 160);
	private boolean textWrittenIn;

	/** You can insert all constructors. I inserted only this one.* */
	public JCustomTextField(int columns)
	{
		super(columns);
	}
	
	public JCustomTextField()
	{
		super();
	}

	@Override
	public void setFont(Font f)
	{
		super.setFont(f);
		if (!isTextWrittenIn())
		{
			originalFont = f;
		}
	}

	@Override
	public void setForeground(Color fg)
	{
		super.setForeground(fg);
		if (!isTextWrittenIn())
		{
			originalForeground = fg;
		}
	}
}