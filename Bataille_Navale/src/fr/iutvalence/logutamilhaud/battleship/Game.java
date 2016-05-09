package fr.iutvalence.logutamilhaud.battleship;

import fr.iutvalence.logutamilhaud.battleship.boats.Boat;
import fr.iutvalence.logutamilhaud.battleship.boats.Cruiser;
import fr.iutvalence.logutamilhaud.battleship.boats.Destroyer;
import fr.iutvalence.logutamilhaud.battleship.boats.Submarine;

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
    }

    /** Start the game. */
    public void run() {
        Boat[] boats1 = {new Cruiser(), new Cruiser(), new Submarine(), new Submarine(), new Destroyer()};
        Boat[] boats2 = {new Cruiser(), new Cruiser(), new Submarine(), new Submarine(), new Destroyer()};

        
        // ---------- Joueur 1 pose ses bateaux ----------
        player1.playerPutABoat(boats1, boatPositionPlayer1);
        // ---------- Joueur 2 pose ses bateaux ----------
        player2.playerPutABoat(boats2, boatPositionPlayer2);

        
        System.out.println(" ");
        System.out.println("The battle is about to start");
        System.out.println(" ");
        
        String actualPlayer;
        while (true) {
        	actualPlayer=player1.playATurn(boatPositionPlayer2, playedPositionPlayer1);
        	if(boatPositionPlayer2.checkVictory()==true){
        		break;
        	}
        	actualPlayer=player2.playATurn(boatPositionPlayer1, playedPositionPlayer2);
        	if(boatPositionPlayer1.checkVictory()==true){
        		break;
        	}
            
        }
        System.out.printf("Victory " + actualPlayer);
    }
}
