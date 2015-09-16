package io.github.hsyyid.dominoes;

public class Dominoes
{
	public static void main(String[] args)
	{
		Stack.createStack();
		System.out.println("Welcome to Dominoes!");
		
		while (Stack.getTotalDominoes() != 21)
		{
			Domino d = Stack.drawFromStack();
			System.out.println("Your Domino is " + d.getFirstVal() + ", " + d.getSecondVal());
		}		
	}
}
