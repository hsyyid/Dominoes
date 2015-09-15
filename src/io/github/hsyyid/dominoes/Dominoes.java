package io.github.hsyyid.dominoes;

public class Dominoes {
	static Stack stack = new Stack();
	static Domino D;

	public static void main(String args[]) {
		System.out.println("Welcome to Dominoes!");
		while (stack.getTotalDominoes() != 21) {
			D = stack.drawFromStack();
			System.out.println("Your Domino is "D.toString());
		}
		
	}
}
