
/**
 * Utilities Class
 * 
 * @author Dorian Le
 * @version 2025-11-22
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Utilities
{

	/**
	 * 
	 * @param window
	 * @param field
	 * @return input if it is an integer, -1 otherwise
	 */
	public int assureInt(JFrame window, JTextField field)
	{
		String text = field.getText().trim();
		int input;

		try
		{
			input = Integer.parseInt(text);
			return input;
		} catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(window, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return -1;
	}
}