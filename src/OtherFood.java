/**
 * Food type for anything that isn't meat or fruit/veg. Keeps track of carbs,
 * fat, and sugar values.
 * 
 * @author Rand Albaroudi
 * @version 2025-11-19
 */
public class OtherFood extends Food
{
	// carb value
	private int carbs;
	// fat value
	private int fat;
	// sugar value
	private int sugar;

	// constructor that sets everything at once
	public OtherFood(String name, int calories, int carbs, int fat, int sugar) {
		super(name, calories);
		this.carbs = carbs;
		this.fat = fat;
		this.sugar = sugar;
	}

	// get carbs
	public int getCarbs()
	{
		return carbs;
	}

	// get fat
	public int getFat()
	{
		return fat;
	}

	// get sugar
	public int getSugar()
	{
		return sugar;
	}

	// change carbs
	public void setCarbs(int carbs)
	{
		this.carbs = carbs;
	}

	// change fat
	public void setFat(int fat)
	{
		this.fat = fat;
	}

	// change sugar
	public void setSugar(int sugar)
	{
		this.sugar = sugar;
	}

	// print out other food details
	@Override
	public String toString()
	{
		return "OtherFood [name=" + getName() + ", calories=" + getCalories() + ", carbs=" + carbs + ", fat=" + fat
				+ ", sugar=" + sugar + "]";
	}
}
