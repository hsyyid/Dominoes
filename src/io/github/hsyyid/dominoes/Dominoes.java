package io.github.hsyyid.dominoes;

public class Dominoes
{
	public static void main(String[] args)
	{
		Stack.createStack();
		System.out.println("Welcome to Dominoes!");
		while (Stack.getTotalDominoes() != 21) {
			Domino d = Stack.drawFromStack();
			System.out.println("Your Domino is " + d.getFirstVal() + " , " + d.getSecondVal());

			int highestDouble = 0;

			if(d.getFirstVal() == d.getSecondVal() && d.getFirstVal() == 6)
			{
				System.out.println("You have a double domino, with the value " + d.getFirstVal() + ", you will go first!");
			}
			else if(d.getFirstVal() == d.getSecondVal())
			{
				if(highestDouble < d.getFirstVal())
				{
					highestDouble = d.getFirstVal();
				}
				
				System.out.println("You have a double domino, with the value " + d.getFirstVal() + " If this is the highest double, you will go first!");
			}
		}

	}

	public static void dealDomino(int amtOfDomino)
	{
		for(int i = 0; i < amtOfDomino; i++)
		{
			Domino d = Stack.drawFromStack();
			System.out.println("Domino is " + d.getFirstVal() + ", " + d.getSecondVal());
		}	
	}
}
