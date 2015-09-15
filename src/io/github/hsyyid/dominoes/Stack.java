package io.github.hsyyid.dominoes;

import java.util.ArrayList;
import java.util.Random;

public class Stack 
{
	private static ArrayList<Domino> stack = new ArrayList<Domino>();
	
	public static ArrayList<Domino> createStack()
	{
		int i = 0;
		int k = 0;
		stack.add(new Domino(0, 0));
		
		for(i = 1; i <= 6; i++)
		{	
			for(k = 0; k <= 6; k++)
			{
				Domino domino = null;
				
				for(Domino d : stack)
				{
					if(d.getFirstVal() == i && d.getSecondVal() == k || d.getFirstVal() == k && d.getSecondVal() == i)
					{
						domino = d;
					}
				}
				
				if(domino == null)
				{
					stack.add(new Domino(i, k));
				}
			}
		}
		
		return stack;
	}
	
	public static int getTotalDominoes()
	{
		return stack.size();
	}
	
	public Domino drawFromDeck()
	{
		Random rand = new Random();
		Domino domino = stack.get(rand.nextInt(27) + 1);
		stack.remove(domino);
		return domino;
	}
}
