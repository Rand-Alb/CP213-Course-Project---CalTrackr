/**
 * @author David Brown
 * @version 2025-11-19
 */

/**
 * 
 */
public class Meat extends Food
{
	private boolean redMeat;
	private int protein;
	private int natFat;

	public Meat(String name, int calories, boolean redMeat, int protein, int natFat) {
		super(name, calories);
		this.redMeat = redMeat;
		this.protein = protein;
		this.natFat = natFat;
	}

	/**
	 * @return the redMeat
	 */
	public boolean isRedMeat()
	{
		return redMeat;
	}

	/**
	 * @param redMeat the redMeat to set
	 */
	public void setRedMeat(boolean redMeat)
	{
		this.redMeat = redMeat;
	}

	/**
	 * @return the protein
	 */
	public int getProtein()
	{
		return protein;
	}

	/**
	 * @param protein the protein to set
	 */
	public void setProtein(int protein)
	{
		this.protein = protein;
	}

	/**
	 * @return the natFat
	 */
	public int getNatFat()
	{
		return natFat;
	}

	/**
	 * @param natFat the natFat to set
	 */
	public void setNatFat(int natFat)
	{
		this.natFat = natFat;
	}

	@Override
	public String toString()
	{
		return "Meat [name=" + getName() + ", calories=" + getCalories() + ", redMeat=" + redMeat + ", protein="
				+ protein + ", natFat=" + natFat + "]";
	}

}
