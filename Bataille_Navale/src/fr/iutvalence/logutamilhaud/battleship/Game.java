package fr.iutvalence.logutamilhaud.battleship;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.BOTTOM;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.LEFT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.NOTHING;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.RIGHT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.TOP;
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
    private int currentPlayer;
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
        
        System.out.println("Joueur 1 veuillez saisir vos bateaux");
        
        for(int i =0;i<2;i++)
        {
        	System.out.println("Bateau selectionne : "+boats1[i].getNameOfBoat());
			System.out.println("Veuillez saisir une position X :");
			int X = scan.nextInt();
			System.out.println("Veuillez saisir une position Y :");
			int Y = scan.nextInt();
			scan.nextLine();
			System.out.println("Veuillez saisir une orientation :");
			String orientation= scan.nextLine();
		

			
			try {
				boatPositionPlayer1.putABoat(boats1[i], X, Y, Orientation.valueOf(orientation));
			} catch (InvalidPositionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OutOfRangeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
        }
        
        boatPositionPlayer1.displayBoard();
        
        System.out.println("Joueur 2 veuillez saisir vos bateaux");
        for(int i =0;i<2;i++)
        {
        	System.out.println("Bateau selectionne : "+boats1[i].getNameOfBoat());
			System.out.println("Veuillez saisir une position X :");
			int X = scan.nextInt();
			System.out.println("Veuillez saisir une position Y :");
			int Y = scan.nextInt();
			scan.nextLine();
			System.out.println("Veuillez saisir une orientation :");
			String orientation= scan.nextLine();
        	
			try {
				boatPositionPlayer2.putABoat(boats1[i], X, Y, Orientation.valueOf(orientation));
			} catch (InvalidPositionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OutOfRangeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

        System.out.println(" ");
        System.out.println("La bataille va commencer");
        System.out.println(" ");

        
		currentPlayer=1;
		
		while(true)
		{
			//Tour joueur 1
			System.out.println("Coup joue Joueur"+currentPlayer);
					
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Joueur"+ currentPlayer +"Veuillez saisir une position X :");
			int X = scan.nextInt();
			System.out.println(" ");
			System.out.println("Joueur"+ currentPlayer +"Veuillez saisir une position Y :");
			int Y = scan.nextInt();
			System.out.println(" ");
			
			boatPositionPlayer2.takeAShot(X, Y, playedPositionPlayer1);
			playedPositionPlayer1.displayBoard();
			if(boatPositionPlayer2.checkVitctory()==true)
			{
				break;
			}
			else
			{
				currentPlayer=2;
			}
			
			
			//Tour joueur 2
			System.out.println("Coup joue Joueur"+currentPlayer);
					
			System.out.println(" ");
			System.out.println(" ");
			
			System.out.println("Joueur"+ currentPlayer +"Veuillez saisir une position X :");
			X = scan.nextInt();
			System.out.println(" ");
			System.out.println("Joueur"+ currentPlayer +"Veuillez saisir une position Y :");
			Y = scan.nextInt();
			System.out.println(" ");
			
			boatPositionPlayer1.takeAShot(X, Y, playedPositionPlayer2);
			playedPositionPlayer1.displayBoard();
			
			if(boatPositionPlayer1.checkVitctory()==true)
			{
				break;
			}
			else
			{
				currentPlayer=1;
			}
		}
		
		System.out.println("Victory player ");
		if(currentPlayer==1)
		{
			System.out.println(player1.getName());
		}
		else
		{
			System.out.println(player2.getName());
		}
	
    }
}
