package main;

public class Minesweepers {
	
	/*
	 * Minesweeper Game 8x8 Board Version
	 * 2017-12-05 ICS 4U1 Array Game
	 */
	
	public static void main(String[] args) {
		System.out.println("Welcome to MINESWEEPER!!!, created by Si Yuen Lam");
		System.out.println("---------------------------------------------");
		System.out.println("How to play: ");
		System.out.println("You can uncover a square by picking Rows and Columns. If you uncover a mine, you lose the game. ");
		System.out.println("If a number appears on a square, it indicates how many mines are in the eight squares that surround the numbered one.");
		System.out.println("The game ends when the player reveals a bomb tile, has revealed all the non-bomb squares or has marked all the bombs.");
		System.out.println("-----------------------------------------------------------------------------------------------");
		new Game();

    }

}
