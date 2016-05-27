package fr.iutvalence.logutamilhaud.battleship;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.iutvalence.logutamilhaud.battleship.boats.Boat;
import fr.iutvalence.logutamilhaud.battleship.boats.Cruiser;
import fr.iutvalence.logutamilhaud.battleship.boats.Destroyer;
import fr.iutvalence.logutamilhaud.battleship.boats.Submarine;
import fr.iutvalence.logutamilhaud.battleship.exceptions.InvalidPositionException;
import fr.iutvalence.logutamilhaud.battleship.exceptions.OccuppedPosition;
import fr.iutvalence.logutamilhaud.battleship.exceptions.OutOfRangeException;

/**
 * Game of battleship.
 *
 * @author logut
 * @version 25/03
 */
public class Game {
	/** First player. */
	private final Player player1;
	/** Second player. */
	private final Player player2;
	/** Grid of shot fired by player1. */
	private Board  playedPositionPlayer1;
	/** Grid of ship position of player1. */
	private Board  boatPositionPlayer1;
	/** Grid of shot fired by player2. */
	private Board  playedPositionPlayer2;
	/** Grid of ship position of player2. */
	private Board  boatPositionPlayer2;
	/** Number of turn played. */
	public int nbTurnPlayed;


	/**
	 * Create a game with 2 players, and initialize the board.
	 *
	 * @param name1 name of the first player.
	 * @param name2 name of the second player.
	 */
	public Game(String name1, String name2) {
		player1 = new Player(name1);
		player2 = new Player(name2);
		playedPositionPlayer1 = new Board();
		playedPositionPlayer2 = new Board();
		boatPositionPlayer1 = new Board();
		boatPositionPlayer2 = new Board();
		nbTurnPlayed = 0;
	}

	/** Start the game. */
	public void run() {

		List<Boat> boats1 = new ArrayList<Boat>();
		boats1.add(new Cruiser());
		boats1.add(new Cruiser());
		boats1.add(new Submarine());
		boats1.add(new Submarine());
		boats1.add(new Destroyer());

		List<Boat> boats2=new ArrayList<Boat>();
		boats2.add(new Cruiser());
		boats2.add(new Cruiser());
		boats2.add(new Submarine());
		boats2.add(new Submarine());
		boats2.add(new Destroyer());



		/** ---------- Joueur 1 pose ses bateaux ---------- */
		playerPutABoat(boats1, boatPositionPlayer1, player1);
		/** ---------- Joueur 2 pose ses bateaux ---------- */
		playerPutABoat(boats2, boatPositionPlayer2, player2);


		System.out.println(" ");
		System.out.println("The battle is about to start");
		System.out.println(" ");

		String actualPlayer;
		while (true) {
			actualPlayer=playATurn(boatPositionPlayer2, playedPositionPlayer1, player1);
			if(boatPositionPlayer2.checkVictory()==true){
				break;
			}
			actualPlayer=playATurn(boatPositionPlayer1, playedPositionPlayer2, player2);
			if(boatPositionPlayer1.checkVictory()==true){
				break;
			}

		}
		System.out.printf("Victory " + actualPlayer);
		try {
			writeHighscore(actualPlayer, nbTurnPlayed);
		} catch (IOException e) {

		}
	}

	/**
	 * Method use to ask and test an integer
	 * @return the integer type by the player
	 */
	private int askValueInt(String message){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int value=-1;

		while(value<0 || value>9){
			System.out.println(message);
			try{
				value=scan.nextInt();
			}
			catch(java.util.InputMismatchException e){
				System.err.println("Please type an integer");
				scan.nextLine();
			}
		}
		return value;
	}


	/**
	 * Method use to ask and test an orientation
	 * @return the orientation type by the player
	 */
	private String askOrientation(){
		String orientation;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		while(true){
			System.out.print("Please choose an orientation (RIGHT, LEFT, TOP, BOTTOM): ");
			System.err.print("");

			try{
				orientation=scan.nextLine();
				orientation=orientation.toUpperCase();
				Orientation.valueOf(orientation);
			}
			catch(java.lang.IllegalArgumentException e){

				System.err.print("please choose a correct orientation\n");
				continue;
			}
			if(Orientation.valueOf(orientation)==Orientation.RIGHT ||Orientation.valueOf(orientation)==Orientation.TOP ||Orientation.valueOf(orientation)==Orientation.LEFT ||Orientation.valueOf(orientation)==Orientation.BOTTOM){
				break;
			}
		}

		return orientation;
	}

	/**
	 * A method to put all his boat for the player.
	 * @param player the player who puts his boat
	 * @param boats	table of all the boat of the player
	 * @param boatPosition the board where the boats are put
	 */
	public void playerPutABoat(List<Boat> boats, Board boatPosition, Player player){
		int X = 0, Y = 0;
		String orientation;
		System.out.printf("%s please put your boat on the grid", player.getName());
		System.out.println(" ");

		for(Boat boat : boats) {
			System.out.printf("Boat select: %s. Size: %s", boat.getNameOfBoat(), +boat.getSize());
			System.out.println(" ");

			while(true){
				X=askValueInt("Please choose a column: ");
				Y=askValueInt("Please choose a line: ");
				orientation=askOrientation();

				try {
					boatPosition.putABoat(boat, X, Y, Orientation.valueOf(orientation));
					System.out.println(boatPosition);
					break;
				}
				catch(OutOfRangeException e1){
					System.err.println(e1.getMessage());
					System.out.println("Please try again");
					System.out.println(boatPosition);
					continue;
				}
				catch (InvalidPositionException e1) {
					System.err.println(e1.getMessage());
					System.out.println(boatPosition);
					continue;
				}	

			}
		}


	}

	/**
	 * A player play a turn.
	 * @param boardShot The grid who is shot.
	 * @return the player who play the turn
	 */
	public String playATurn(Board boardShot, Board playedPosition, Player player){
		String testShot;

		while(true){
			int X = 0;
			int Y = 0;
			System.out.printf(" ");
			System.out.printf("Coup joue %s", player.getName() );
			System.out.println(" ");


			X=askValueInt("Please choose a column");
			Y=askValueInt("Please choose a line");

			try {
				testShot = succeed(boardShot.takeAShot(X, Y, playedPosition));
				System.out.println(playedPosition);
				nbTurnPlayed++;
				break;
			} 
			catch (OccuppedPosition e) {
				System.err.println(e.getMessage());

			}  
		}

		System.out.println(testShot);
		return player.getName();

	}
	/**
	 * Result of the shot.
	 * @param testShot a boolean
	 * @return a string who content the result of the shoot
	 */
	public String succeed(boolean testShot){
		if (testShot) {
			return "You got it my Captain !";
		}
		else {
			return "You miss this one Captain !";
		}
	}
	/**
	 * Method use to remenber the last game the high score in a file.
	 * @throws IOException 
	 */
	public void writeHighscore(String player, int nbturn) throws IOException{
		
		PrintWriter write;
		write =  new PrintWriter(new BufferedWriter(new FileWriter("HighScore/Score.txt")));
		write.println(player + " : End his game with " +nbTurnPlayed+"\n");
		write.close();
	}

}
