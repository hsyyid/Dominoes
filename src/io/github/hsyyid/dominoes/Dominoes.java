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
			if(d.getFirstVal() == d.getSecondVal())
			{
				System.out.println("You have a double domino, with the value " + d.getFirstVal());
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
