
/**
 * @author David Brown
 * @version 2025-11-19
 */

import java.util.Arrays;

/**
 * 
 */
public class FruitsAndVegetables extends Food
{
	private int natSugar;
	private boolean vitaminRich;
	private String[] vitamin;
	private int carbs;

	public FruitsAndVegetables(String name, int calories, int natSugar, boolean vitaminRich, String[] vitamin,
			int carbs) {
		super(name, calories);
		this.natSugar = natSugar;
		this.vitaminRich = vitaminRich;
		this.vitamin = vitamin;
		this.carbs = carbs;
	}

	public int getNatSugar()
	{
		return natSugar;
	}

	public boolean isVitaminRich()
	{
		return vitaminRich;
	}

	public String[] getVitamin()
	{
		return vitamin;
	}

	public int getCarbs()
	{
		return carbs;
	}

	public void setNatSugar(int natSugar)
	{
		this.natSugar = natSugar;
	}

	public void setVitaminRich(boolean vitaminRich)
	{
		this.vitaminRich = vitaminRich;
	}

	public void setVitamin(String[] vitamin)
	{
		this.vitamin = vitamin;
	}

	public void setCarbs(int carbs)
	{
		this.carbs = carbs;
	}

	@Override
	public String toString()
	{
		return "FruitsAndVegetables [name=" + getName() + ", calories=" + getCalories() + ", natSugar=" + natSugar
				+ ", vitaminRich=" + vitaminRich + ", vitamin=" + Arrays.toString(vitamin) + ", carbs=" + carbs + "]";
	}

}
