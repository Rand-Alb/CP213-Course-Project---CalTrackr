
/**
 * @author David Brown
 * @version 2025-11-22
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodParser
{

	public static List<Food> parseFoods(String csvFile) throws IOException
	{
		List<Food> foods = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
		{
			String header = br.readLine(); // skip header

			String line;
			while ((line = br.readLine()) != null)
			{
				if (line.trim().isEmpty())
				{
					continue;
				} // skip blank lines
				String[] parts = line.split(",", -1);
				String name = parts[0].trim();
				String category = parts[1].trim().toLowerCase();

				int calories = !parts[2].trim().isEmpty() ? Integer.parseInt(parts[2].trim()) : 0;

				switch (category)
				{
				case "fruit":
				case "vegetable":
				{
					int natSugar = !parts[3].trim().isEmpty() ? Integer.parseInt(parts[3].trim()) : 0;
					boolean vitaminRich = !parts[4].trim().isEmpty() && Boolean.parseBoolean(parts[4].trim());
					String[] vitamins = parts[5].trim().isEmpty() ? new String[0] : parts[5].split("\\|");
					int carbs = !parts[6].trim().isEmpty() ? Integer.parseInt(parts[6].trim()) : 0;

					FruitsAndVegetables fruitsAndVegetables = new FruitsAndVegetables(name, calories, natSugar,
							vitaminRich, vitamins, carbs);
					foods.add(fruitsAndVegetables);
					break;
				}
				case "meat":
				{
					boolean redMeat = !parts[7].trim().isEmpty() && Boolean.parseBoolean(parts[7].trim());
					int protein = !parts[8].trim().isEmpty() ? Integer.parseInt(parts[8].trim()) : 0;
					int natFat = !parts[9].trim().isEmpty() ? Integer.parseInt(parts[9].trim()) : 0;

					Meat meat = new Meat(name, calories, redMeat, protein, natFat);
					foods.add(meat);
					break;
				}
				case "otherfood":
				{
					int carbs = !parts[7].trim().isEmpty() ? Integer.parseInt(parts[7].trim()) : 0;
					int fat = !parts[10].trim().isEmpty() ? Integer.parseInt(parts[10].trim()) : 0;
					int sugar = !parts[11].trim().isEmpty() ? Integer.parseInt(parts[11].trim()) : 0;

					OtherFood otherFood = new OtherFood(name, calories, carbs, fat, sugar);
					foods.add(otherFood);
					break;
				}
				default:
					System.out.println("Skipping unknown category: " + category);
				}
			}
		}

		return foods;
	}

	public static void main(String[] args) throws IOException
	{
		List<Food> foods = parseFoods("foods_sample.csv");
		for (Food food : foods)
		{
			System.out.println(food);
		}
	}
}
