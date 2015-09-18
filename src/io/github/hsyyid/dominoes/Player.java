package io.github.hsyyid.dominoes;

import java.util.ArrayList;

public class Player
{
	private int id;
	private ArrayList<Domino> stack = new ArrayList<Domino>();

	public Player(int id)
	{
		this.id = id;
	}

	public void addDominoToStack(Domino domino)
	{
		this.stack.add(domino);
	}

	public int getID()
	{
		return this.id;
	}

	public ArrayList<Domino> getStack()
	{
		return this.stack;
	}

	public int getStackSize()
	{
		return this.stack.size();
	}
}
