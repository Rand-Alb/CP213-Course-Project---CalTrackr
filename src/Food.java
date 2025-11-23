// new comment
/**
 * @author David Brown
 * @version 2025-11-19
 */

/**
 **/
public class Food
{
	// one line comment
	private String name;
	private int calories;

	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}

	public String getName()
	{
		return name;
	}

	public int getCalories()
	{
		return calories;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setCalories(int calories)
	{
		this.calories = calories;
	}

}
