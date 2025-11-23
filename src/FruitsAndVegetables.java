
/**
 * Food type for fruits and vegetables.
 * Adds natural sugar, vitamin info, and carbs on top of the basic Food fields.
 * @author Rand Albaroudi
 * @version 2025-11-19
 */
import java.util.Arrays;

public class FruitsAndVegetables extends Food
{
	// natural sugar amount
	private int natSugar;
	// true if this food is considered vitamin rich
	private boolean vitaminRich;
	// list of vitamins this food has
	private String[] vitamin;
	// carbs for this food
	private int carbs;

	// constructor that fills in both Food and FruitsAndVegetables fields
	public FruitsAndVegetables(String name, int calories, int natSugar, boolean vitaminRich, String[] vitamin,
			int carbs) {
		super(name, calories);
		this.natSugar = natSugar;
		this.vitaminRich = vitaminRich;
		this.vitamin = vitamin;
		this.carbs = carbs;
	}

	// get natural sugar
	public int getNatSugar()
	{
		return natSugar;
	}

	// check if it's vitamin rich
	public boolean isVitaminRich()
	{
		return vitaminRich;
	}

	// get array of vitamins
	public String[] getVitamin()
	{
		return vitamin;
	}

	// get carb amount
	public int getCarbs()
	{
		return carbs;
	}

	// change natural sugar value
	public void setNatSugar(int natSugar)
	{
		this.natSugar = natSugar;
	}

	// change vitamin rich flag
	public void setVitaminRich(boolean vitaminRich)
	{
		this.vitaminRich = vitaminRich;
	}

	// change vitamin list
	public void setVitamin(String[] vitamin)
	{
		this.vitamin = vitamin;
	}

	// change carb amount
	public void setCarbs(int carbs)
	{
		this.carbs = carbs;
	}

	// print a string version of this object
	@Override
	public String toString()
	{
		return "FruitsAndVegetables [name=" + getName() + ", calories=" + getCalories() + ", natSugar=" + natSugar
				+ ", vitaminRich=" + vitaminRich + ", vitamin=" + Arrays.toString(vitamin) + ", carbs=" + carbs + "]";
	}
}
