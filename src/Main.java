
/**
 * Main menu
 * 
 * @author Dorian Le
 * @version 2025-11-22
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() ->
		{

			// ====== Instantiate components ======
			JFrame mainWindow = new JFrame("Main Window");
			JPanel div = new JPanel();
			JPanel cardPanel = new JPanel(new CardLayout());

			JLabel logo = new JLabel("CalTrackr");
			JLabel names = new JLabel("Rand Albaroudi, Dorian Le, Maxim Ginsberg (2025)");
			JButton goal = new JButton("Set Daily Goal");
			JButton tracking = new JButton("Summary/Tracking");
			JButton personal = new JButton("Personal");

			CardLayout cl = (CardLayout) cardPanel.getLayout();
			Personal account = new Personal(cl, cardPanel);

			// Set layout
			mainWindow.setLayout(new BorderLayout());

			// ====== Set GUI component properties ======
			logo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
			names.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));

			goal.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
			goal.setPreferredSize(new Dimension(300, 90));

			tracking.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
			tracking.setPreferredSize(new Dimension(300, 90));

			personal.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
			personal.setPreferredSize(new Dimension(300, 90));

			// Add GUI components to menu and panels
			mainWindow.add(logo, BorderLayout.NORTH);
			mainWindow.add(cardPanel, BorderLayout.CENTER);
			mainWindow.add(names, BorderLayout.SOUTH);

			div.add(goal);
			div.add(tracking);
			div.add(personal);

			// Screens to switch between
			cardPanel.add(div);
			cardPanel.add(account, "account");

			// ====== Button action listeners ======
			personal.addActionListener(e ->
			{
				cl.show(cardPanel, "account");
			});

			// Adjust GUI component position
			logo.setHorizontalAlignment(JLabel.CENTER);
			logo.setVerticalAlignment(JLabel.CENTER);

			names.setHorizontalAlignment(JLabel.CENTER);
			names.setVerticalAlignment(JLabel.CENTER);

			// Set window and panel properties
			div.setVisible(true);
			mainWindow.setSize(800, 650);
			mainWindow.setVisible(true);
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});

	}

}