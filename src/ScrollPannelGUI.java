import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 * GUI application to display food items from CSV in a scrollable panel
 * 
 * @author Maxim Ginsberg
 * @version 2025-11-23
 */
public class ScrollPannelGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel foodPanel;
    private JScrollPane scrollPane;
    private List<Food> foods;

    public ScrollPannelGUI(String csvFile) {
	// Load foods from CSV
	try {
	    foods = FoodParser.parseFoods(csvFile);
	} catch (IOException e) {
	    JOptionPane.showMessageDialog(this, "Error loading CSV file: " + e.getMessage(), "File Error",
		    JOptionPane.ERROR_MESSAGE);
	    System.exit(1);
	}

	// Setup frame
	setTitle("Food Database Viewer");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(800, 600);
	setLocationRelativeTo(null);

	// Create main panel with vertical layout
	foodPanel = new JPanel();
	foodPanel.setLayout(new BoxLayout(foodPanel, BoxLayout.Y_AXIS));
	foodPanel.setBackground(Color.WHITE);
	foodPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

	// Populate panel with food items
	populateFoodPanel();

	// Create scroll pane
	scrollPane = new JScrollPane(foodPanel);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.getVerticalScrollBar().setUnitIncrement(16);

	// Add to frame
	add(scrollPane);

	// Add header panel
	JPanel headerPanel = createHeaderPanel();
	add(headerPanel, BorderLayout.NORTH);
    }

    private JPanel createHeaderPanel() {
	JPanel header = new JPanel();
	header.setBackground(new Color(70, 130, 180));
	header.setBorder(new EmptyBorder(15, 10, 15, 10));

	JLabel titleLabel = new JLabel("Food Database - " + foods.size() + " items");
	titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	titleLabel.setForeground(Color.WHITE);
	header.add(titleLabel);

	return header;
    }

    private void populateFoodPanel() {
	for (Food food : foods) {
	    JPanel itemPanel = createFoodItemPanel(food);
	    foodPanel.add(itemPanel);
	    foodPanel.add(Box.createRigidArea(new Dimension(0, 10)));
	}
    }

    private JPanel createFoodItemPanel(Food food) {
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout(10, 10));
	panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
		new EmptyBorder(15, 15, 15, 15)));
	panel.setBackground(Color.WHITE);
	panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

	// Food name and type
	JPanel headerSection = new JPanel(new BorderLayout());
	headerSection.setBackground(Color.WHITE);
	
    // Capitalize first letter of the food name
    String name = food.getName();
    if (name != null && !name.isEmpty()) {
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
	JLabel nameLabel = new JLabel(food.getName());
	nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
	headerSection.add(nameLabel, BorderLayout.WEST);

	JLabel typeLabel = new JLabel(getFoodType(food));
	typeLabel.setFont(new Font("Arial", Font.ITALIC, 14));
	typeLabel.setForeground(getTypeColor(food));
	headerSection.add(typeLabel, BorderLayout.EAST);

	panel.add(headerSection, BorderLayout.NORTH);

	// Food details
	JTextArea detailsArea = new JTextArea(getFoodDetails(food));
	detailsArea.setFont(new Font("Arial", Font.PLAIN, 13));
	detailsArea.setEditable(false);
	detailsArea.setBackground(Color.WHITE);
	detailsArea.setLineWrap(true);
	detailsArea.setWrapStyleWord(true);

	panel.add(detailsArea, BorderLayout.CENTER);

	return panel;
    }

    private String getFoodType(Food food) {
	if (food instanceof FruitsAndVegetables) {
	    return "FRUIT/VEGETABLE";
	} else if (food instanceof Meat) {
	    return "MEAT";
	} else if (food instanceof OtherFood) {
	    return "OTHER FOOD";
	}
	return "FOOD";
    }

    private Color getTypeColor(Food food) {
	if (food instanceof FruitsAndVegetables) {
	    return new Color(34, 139, 34); // Forest green
	} else if (food instanceof Meat) {
	    return new Color(178, 34, 34); // Firebrick red
	} else if (food instanceof OtherFood) {
	    return new Color(255, 140, 0); // Dark orange
	}
	return Color.BLACK;
    }

    private String getFoodDetails(Food food) {
	StringBuilder details = new StringBuilder();
	details.append("Calories: ").append(food.getCalories()).append(" kcal\n");

	if (food instanceof FruitsAndVegetables) {
	    FruitsAndVegetables fv = (FruitsAndVegetables) food;
	    details.append("Natural Sugar: ").append(fv.getNatSugar()).append("g\n");
	    details.append("Carbohydrates: ").append(fv.getCarbs()).append("g\n");
	    details.append("Vitamin Rich: ").append(fv.isVitaminRich() ? "Yes" : "No").append("\n");
	    if (fv.getVitamin().length > 0) {
		details.append("Vitamins: ").append(String.join(", ", fv.getVitamin()));
	    }
	} else if (food instanceof Meat) {
	    Meat meat = (Meat) food;
	    details.append("Protein: ").append(meat.getProtein()).append("g\n");
	    details.append("Natural Fat: ").append(meat.getNatFat()).append("g\n");
	    details.append("Red Meat: ").append(meat.isRedMeat() ? "Yes" : "No");
	} else if (food instanceof OtherFood) {
	    OtherFood other = (OtherFood) food;
	    details.append("Carbohydrates: ").append(other.getCarbs()).append("g\n");
	    details.append("Fat: ").append(other.getFat()).append("g\n");
	    details.append("Sugar: ").append(other.getSugar()).append("g");
	}

	return details.toString();
    }

    public static void main(String[] args) {
	SwingUtilities.invokeLater(() -> {
	    ScrollPannelGUI gui = new ScrollPannelGUI("foods_sample.csv");
	    gui.setVisible(true);
	});
    }
}
