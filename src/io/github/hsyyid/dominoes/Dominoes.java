package io.github.hsyyid.dominoes;

import java.util.ArrayList;
import java.util.Scanner;

public class Dominoes
{
	private static ArrayList<Player> players = new ArrayList<Player>();

	public static void main(String[] args)
	{
		System.out.println("Welcome to Dominoes!");

		Scanner in = new Scanner(System.in);
		Stack.createStack();

		System.out.println("How many players are playing? ");
		int amtOfPlayers = in.nextInt();

		for(int i = 1; i <= amtOfPlayers; i++)
		{
			players.add(new Player(i));
		}

		Player startingPlayer = pickWhoGoesFirst();

		in.close();
	}

	public static void dealDomino(int amtOfDomino, Player player)
	{
		for(int i = 0; i < amtOfDomino; i++)
		{
			Domino d = Stack.drawFromStack();
			player.addDominoToStack(d);
			System.out.println("You have drawn " + d.getFirstVal() + ", " + d.getSecondVal());
		}	
	}

	public static Player pickWhoGoesFirst()
	{
		Player startingPlayer = null;
		int highestVal = 0;

		for(Player p : players)
		{
			System.out.println("Player " + p.getID() + ": ");
			dealDomino(7, p);

			for(Domino d : p.getStack())
			{
				if(d.getFirstVal() == 6 && d.getSecondVal() == 6)
				{
					startingPlayer = p;
					System.out.println("Player " + startingPlayer.getID() + " will go first, with the highest double value of 6.");
					return startingPlayer;
				}
				else if(d.getFirstVal() == d.getSecondVal())
				{
					if(highestVal < d.getFirstVal())
					{
						highestVal = d.getFirstVal();
						startingPlayer = p;
					}
				}
			}
		}

		if(startingPlayer != null)
		{
			System.out.println("Player " + startingPlayer.getID() + " will go first, with the highest double value of " + highestVal + ".");
			return startingPlayer;
		}
		else
		{
			return players.get(1);
		}
	}
}
