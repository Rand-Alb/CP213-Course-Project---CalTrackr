/**
 * Food parent class, stores a name and calorie count.
 * 
 * @author Rand Albaroudi
 * @version 2025-11-19
 */
public class Food
{
	// name of the food
	private String name;
	// calories in the food
	private int calories;

	// basic constructor to set name and calories
	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}

	// return the food name
	public String getName()
	{
		return name;
	}

	// return how many calories it has
	public int getCalories()
	{
		return calories;
	}

	// update the name if needed
	public void setName(String name)
	{
		this.name = name;
	}

	// update the calorie value
	public void setCalories(int calories)
	{
		this.calories = calories;
	}
}
