import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Personal extends JPanel
{

	public Personal(CardLayout layout, JPanel parent) {
		add(new JLabel("Testing"));

		JButton back = new JButton("Back");
		add(back);

	}

}