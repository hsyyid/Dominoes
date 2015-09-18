package io.github.hsyyid.dominoes;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This simulates a game of Dominoes
 * @author Hassan Syyid
 * @author Joseph Oleynik
 * @Teacher Mr.Hays
 * @version 0.1
 *
 */
public class Dominoes extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	private static ArrayList<Player> players = new ArrayList<Player>();
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Dominoes";
	private BufferedImage background = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private static boolean running = false;
	private static Thread thread;
	private static JFrame game;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		Stack.createStack();

		System.out.println("How many players are playing? ");
		int amtOfPlayers = in.nextInt();

		if (amtOfPlayers > 4)
		{
			System.out.print("Error! You cannot play this game with more than 4 people.");
			in.close();
			return;
		}

		for (int i = 1; i <= amtOfPlayers; i++)
		{
			System.out.println("Player " + i + ", what would you like to be called?");
			String name = in.nextLine();
			players.add(new Player(i, name));
		}

		Player startingPlayer = pickWhoGoesFirst();
		players.add(0, startingPlayer);

		game = new JFrame("Dominoes");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setResizable(false);
		game.setLocationRelativeTo(null);
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.pack();
		game.setVisible(true);
		in.close();

		Dominoes domino = new Dominoes();
		domino.start();
	}

	private synchronized void start()
	{
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();

	}

	public BufferedImage loadImage(String path) throws IOException
	{
		BufferedImage img = null;

		try
		{
			img = ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return img;
	}

	public static void playGame()
	{
		;
	}

	/**
	 * Deals the specified amount of dominoes to the specified player
	 * @param amtOfDomino Amount of dominoes to deal.
	 * @param player Player to deal dominoes to.
	 */
	public static void dealDomino(int amtOfDomino, Player player)
	{
		for (int i = 0; i < amtOfDomino; i++)
		{
			Domino d = Stack.drawFromStack();
			player.addDominoToStack(d);
			System.out.println("You have drawn " + d.getFirstVal() + ", " + d.getSecondVal());
		}
	}

	/**
	 * This method picks which Player will start in the game.
	 * @return The player that will go first.
	 */
	public static Player pickWhoGoesFirst()
	{
		Player startingPlayer = null;
		int highestVal = 0;

		for (Player p : players)
		{
			System.out.println("Player " + p.getID() + ": ");
			dealDomino(7, p);

			for (Domino d : p.getStack())
			{
				if (d.getFirstVal() == 6 && d.getSecondVal() == 6)
				{
					startingPlayer = p;
					System.out.println("Player " + startingPlayer.getID() + " will go first, with the highest double value of 6.");
					return startingPlayer;
				}
				else if (d.getFirstVal() == d.getSecondVal())
				{
					if (highestVal < d.getFirstVal())
					{
						highestVal = d.getFirstVal();
						startingPlayer = p;
					}
				}
			}
		}

		if (startingPlayer != null)
		{
			System.out.println("Player " + startingPlayer.getID() + " will go first, with the highest double value of " + highestVal + ".");
			return startingPlayer;
		}
		else
		{
			return players.get(0);
		}
	}

	public void run()
	{
		System.out.println("Welcome to Dominoes!");

		try
		{
			background = this.loadImage("background.png");
			System.out.println("Background Loaded");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(background));

		game.add(picLabel);
		game.repaint();

		boolean stop = false;

		while (!stop)
		{
			playGame();
		}
	}
}
