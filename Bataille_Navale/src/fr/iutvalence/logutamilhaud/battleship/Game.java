package fr.iutvalence.logutamilhaud.battleship;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.BOTTOM;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.LEFT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.RIGHT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.TOP;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.NOTHING;
import java.util.Scanner;
/**
 * game of battleship
 * @author logut
 * @version 25/03
 */
public class Game 
{

	/** First player. */
	private Player player1;
	/** Second player. */
	private Player player2;
	/** Grid of shot fired by player1  */
	private Board  playedPositionPlayer1;
	/** Grid of ship position of player1 */
	private Board  boatPositionPlayer1;
	/** Grid of shot fired by player2  */
	private Board  playedPositionPlayer2;
	/** Grid of ship position of player2 */
	private Board  boatPositionPlayer2;
	/** Actual player. */
	private String tempPlayer;
	/**
	 * Create a game with 2 players, and initialize the board.
	 *
	 * @param name1 name of the first player.
	 * @param name2 name of the second player.
	 */
	public Game(String name1, String name2) 
	{
		this.player1 = new Player(name1);
		this.player2 = new Player(name2);
		this.playedPositionPlayer1 = new Board();
		this.playedPositionPlayer2 = new Board(); 
		this.boatPositionPlayer1 = new Board();
		this.boatPositionPlayer2 = new Board();
	}

	/** Start the game. */
	public void run() 
	{
		Boat[] boats1 = new Boat[]{new Cruiser(),  new Cruiser(), new Submarine(), new Submarine(), new Destroyer()};
		Boat[] boats2 = new Boat[]{new Cruiser(),  new Cruiser(), new Submarine(), new Submarine(), new Destroyer()};

		Scanner scan = new Scanner(System.in);

		// ---------- Joueur 1 pose ses bateaux ----------

		System.out.println("Joueur 1 veuillez saisir vos bateaux");

		int i=0;
		while(i<5)
		{
			System.out.println("Bateau selectionne : "+boats1[i].getNameOfBoat());
			System.out.println("Veuillez saisir une colonne :");
			int X = scan.nextInt();

			while(X<0 || X>9){
				System.out.println("Veuillez saisir une colonne valide:");
				X = scan.nextInt();
			}
			System.out.println("Veuillez saisir une ligne :");
			int Y = scan.nextInt();

			while(Y<0 || Y>9){
				System.out.println("Veuillez saisir une ligne valide:");
				Y = scan.nextInt();
			}
			scan.nextLine();
			System.out.println("Veuillez saisir une orientation (RIGHT, LEFT, TOP, BOTTOM) :");
			String orientation= scan.nextLine();

			while(Orientation.valueOf(orientation)!=RIGHT && Orientation.valueOf(orientation)!=LEFT && Orientation.valueOf(orientation)!=TOP && Orientation.valueOf(orientation)!=BOTTOM && Orientation.valueOf(orientation)!=NOTHING){
				System.out.println("Veuillez saisir une orientation valide (RIGHT, LEFT, TOP, BOTTOM) :");
				orientation= scan.nextLine();
			}

			try {
				boatPositionPlayer1.putABoat(boats1[i], X, Y, Orientation.valueOf(orientation));
				boatPositionPlayer1.displayBoard();
				i++;
			} 
			catch (InvalidPositionException | OutOfRangeException e1) {
				System.err.println(e1.getMessage());
			} 

		}

		// ---------- Joueur 2 pose ses bateaux ----------
		i=0;
		System.out.println("Joueur 2 veuillez saisir vos bateaux");
		while(i<5)
		{
			System.out.println("Bateau selectionne : "+boats2[i].getNameOfBoat());
			System.out.println("Veuillez saisir une colonne :");
			int X = scan.nextInt();
			while(X<0 || X>9){
				System.out.println("Veuillez saisir une colonne valide:");
				X = scan.nextInt();
			}
			System.out.println("Veuillez saisir une ligne :");
			int Y = scan.nextInt();
			while(Y<0 || Y>9){
				System.out.println("Veuillez saisir une ligne valide:");
				Y = scan.nextInt();
			}
			scan.nextLine();
			System.out.println("Veuillez saisir une orientation (RIGHT, LEFT, TOP, BOTTOM) :");
			String orientation= scan.nextLine();

			while(Orientation.valueOf(orientation)!=RIGHT && Orientation.valueOf(orientation)!=LEFT && Orientation.valueOf(orientation)!=TOP && Orientation.valueOf(orientation)!=BOTTOM && Orientation.valueOf(orientation)!=NOTHING){
				System.out.println("Veuillez saisir une orientation valide (RIGHT, LEFT, TOP, BOTTOM) :");
				orientation= scan.nextLine();
			}

			try {
				boatPositionPlayer2.putABoat(boats2[i], X, Y, Orientation.valueOf(orientation));
				boatPositionPlayer2.displayBoard();
				i++;
			} 
			catch (InvalidPositionException | OutOfRangeException e1) {
				System.err.println(e1.getMessage());
			}

		}

		System.out.println(" ");
		System.out.println("La bataille va commencer");
		System.out.println(" ");


		while(true)
		{
			// ---------- Tour Joueur 1 ----------
			tempPlayer=player1.getName();

			System.out.println("Coup joue "+tempPlayer);

			System.out.println(" ");
			System.out.println(" ");
			System.out.println(tempPlayer +" Veuillez saisir une colonne : ");
			int X = scan.nextInt();
			System.out.println(" ");
			System.out.println(tempPlayer +" Veuillez saisir une ligne :");
			int Y = scan.nextInt();
			System.out.println(" ");

			boatPositionPlayer2.takeAShot(X, Y, playedPositionPlayer1);
			playedPositionPlayer1.displayBoard();

			if(boatPositionPlayer2.takeAShot(X, Y, playedPositionPlayer1)==true){
				System.out.println("Touche");
			}
			else{
				System.out.println("Loupe");
			}

			if(boatPositionPlayer2.checkVitctory()==true)
			{
				break;
			}
			else
			{
				tempPlayer=player2.getName();
			}


			// ---------- Tour Joueur 2 ----------

			System.out.println("Coup joue "+tempPlayer);

			System.out.println(" ");
			System.out.println(" ");

			System.out.println(tempPlayer +" Veuillez saisir une position X :");
			X = scan.nextInt();
			System.out.println(" ");
			System.out.println(tempPlayer +" Veuillez saisir une position Y :");
			Y = scan.nextInt();
			System.out.println(" ");

			boatPositionPlayer1.takeAShot(X, Y, playedPositionPlayer2);
			playedPositionPlayer1.displayBoard();

			if(boatPositionPlayer2.takeAShot(X, Y, playedPositionPlayer1)==true){
				System.out.println("Touche");
			}
			else{
				System.out.println("Loupe");
			}

			if(boatPositionPlayer1.checkVitctory()==true)
			{
				break;
			}
			else
			{
				tempPlayer=player1.getName();
			}
		}

		System.out.println("Victoire "+ tempPlayer);
		scan.close();
	}
}
