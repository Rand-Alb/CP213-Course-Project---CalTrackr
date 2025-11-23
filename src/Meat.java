/**
 * Food type for meat. Stores if it's red meat and its protein and fat values.
 * 
 * @author Rand Albaroudi
 * @version 2025-11-19
 */
public class Meat extends Food
{
	// true if this is red meat
	private boolean redMeat;
	// protein amount
	private int protein;
	// natural fat amount
	private int natFat;

	// constructor with all meat details
	public Meat(String name, int calories, boolean redMeat, int protein, int natFat) {
		super(name, calories);
		this.redMeat = redMeat;
		this.protein = protein;
		this.natFat = natFat;
	}

	// check if it's red meat
	public boolean isRedMeat()
	{
		return redMeat;
	}

	// change red meat flag
	public void setRedMeat(boolean redMeat)
	{
		this.redMeat = redMeat;
	}

	// get protein amount
	public int getProtein()
	{
		return protein;
	}

	// change protein amount
	public void setProtein(int protein)
	{
		this.protein = protein;
	}

	// get natural fat
	public int getNatFat()
	{
		return natFat;
	}

	// change natural fat amount
	public void setNatFat(int natFat)
	{
		this.natFat = natFat;
	}

	// print out meat details nicely
	@Override
	public String toString()
	{
		return "Meat [name=" + getName() + ", calories=" + getCalories() + ", redMeat=" + redMeat + ", protein="
				+ protein + ", natFat=" + natFat + "]";
	}
}
