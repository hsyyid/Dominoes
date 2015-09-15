package io.github.hsyyid.dominoes;

public class Domino
{
	private int firstVal;
	private int secondVal;
	
	public Domino(int firstVal, int secondVal)
	{
		this.firstVal = firstVal;
		this.secondVal = secondVal;
	}
	
	public void setFirstVal(int firstVal)
	{
		this.firstVal = firstVal;
	}
	
	public void setSecondVal(int secondVal)
	{
		this.secondVal = secondVal;
	}
	
	public int getFirstVal()
	{
		return firstVal;
	}
	
	public int getSecondVal()
	{
		return secondVal;
	}
}
