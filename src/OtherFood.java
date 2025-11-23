/**
 * @author David Brown
 * @version 2025-11-19
 */

/**
 * 
 */
public class OtherFood extends Food
{
	private int carbs;
	private int fat;
	private int sugar;

	public OtherFood(String name, int calories, int carbs, int fat, int sugar) {
		super(name, calories);
		this.carbs = carbs;
		this.fat = fat;
		this.sugar = sugar;
	}

	public int getCarbs()
	{
		return carbs;
	}

	public int getFat()
	{
		return fat;
	}

	public int getSugar()
	{
		return sugar;
	}

	public void setCarbs(int carbs)
	{
		this.carbs = carbs;
	}

	public void setFat(int fat)
	{
		this.fat = fat;
	}

	public void setSugar(int sugar)
	{
		this.sugar = sugar;
	}

	@Override
	public String toString()
	{
		return "OtherFood [name=" + getName() + ", calories=" + getCalories() + ", carbs=" + carbs + ", fat=" + fat
				+ ", sugar=" + sugar + "]";
	}

}
