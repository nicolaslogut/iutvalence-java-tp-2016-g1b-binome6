package fr.iutvalence.logutamilhaud.battleship;

import java.util.Scanner;

import static fr.iutvalence.logutamilhaud.battleship.Orientation.BOTTOM;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.LEFT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.NOTHING;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.RIGHT;
import static fr.iutvalence.logutamilhaud.battleship.Orientation.TOP;

/**
 * Game of battleship.
 *
 * @author logut
 * @version 25/03
 */
public class Game {
    // TODO final?
    /** First player. */
    private final Player player1;
    // TODO final?
    /** Second player. */
    private final Player player2;
    // TODO final?
    /** Grid of shot fired by player1. */
    private final Board  playedPositionPlayer1;
    // TODO final?
    /** Grid of ship position of player1. */
    private final Board  boatPositionPlayer1;
    // TODO final?
    /** Grid of shot fired by player2. */
    private final Board  playedPositionPlayer2;
    // TODO final?
    /** Grid of ship position of player2. */
    private final Board  boatPositionPlayer2;

    // TODO An attribute? A String?
    /** Actual player. */
    private String tempPlayer;

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

        Scanner scan = new Scanner(System.in);

        // TODO Create a new private method to factorize all the processing for a given player
        // TODO Translate everything
        // ---------- Joueur 1 pose ses bateaux ----------

        System.out.println("Joueur 1 veuillez saisir vos bateaux");

        int i = 0;
        while (i < 5) {
            System.out.printf("Bateau selectionne : %s%n", boats1[i].getNameOfBoat());
            System.out.println("Veuillez saisir une colonne :");
            int X = scan.nextInt();

            while ((X < 0) || (X > 9)) {
                System.out.println("Veuillez saisir une colonne valide:");
                X = scan.nextInt();
            }
            System.out.println("Veuillez saisir une ligne :");
            int Y = scan.nextInt();

            while ((Y < 0) || (Y > 9)) {
                System.out.println("Veuillez saisir une ligne valide:");
                Y = scan.nextInt();
            }
            scan.nextLine();
            System.out.println("Veuillez saisir une orientation (RIGHT, LEFT, TOP, BOTTOM) :");
            String orientation = scan.nextLine();

            while ((Orientation.valueOf(orientation) != RIGHT) && (Orientation.valueOf(orientation) != LEFT) &&
                   (Orientation.valueOf(orientation) != TOP) && (Orientation.valueOf(orientation) != BOTTOM) &&
                   (Orientation.valueOf(orientation) != NOTHING)) {
                System.out.println("Veuillez saisir une orientation valide (RIGHT, LEFT, TOP, BOTTOM) :");
                orientation = scan.nextLine();
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
        i = 0;
        System.out.println("Joueur 2 veuillez saisir vos bateaux");
        while (i < 5) {
            System.out.println("Bateau selectionne : " + boats2[i].getNameOfBoat());
            System.out.println("Veuillez saisir une colonne :");
            int X = scan.nextInt();
            while (X < 0 || X > 9) {
                System.out.println("Veuillez saisir une colonne valide:");
                X = scan.nextInt();
            }
            System.out.println("Veuillez saisir une ligne :");
            int Y = scan.nextInt();
            while (Y < 0 || Y > 9) {
                System.out.println("Veuillez saisir une ligne valide:");
                Y = scan.nextInt();
            }
            scan.nextLine();
            System.out.println("Veuillez saisir une orientation (RIGHT, LEFT, TOP, BOTTOM) :");
            String orientation = scan.nextLine();

            while (Orientation.valueOf(orientation) != RIGHT && Orientation.valueOf(orientation) != LEFT &&
                   Orientation.valueOf(orientation) != TOP && Orientation.valueOf(orientation) != BOTTOM &&
                   Orientation.valueOf(orientation) != NOTHING) {
                System.out.println("Veuillez saisir une orientation valide (RIGHT, LEFT, TOP, BOTTOM) :");
                orientation = scan.nextLine();
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

        while (true) {
            // TODO Create a new private method to factorize all the processing for a given player
            // ---------- Tour Joueur 1 ----------
            tempPlayer = player1.getName();

            System.out.printf("Coup joue %s%n", tempPlayer);

            System.out.println(" ");
            System.out.println(" ");
            System.out.printf("%s Veuillez saisir une colonne : %n", tempPlayer);
            int X = scan.nextInt();
            System.out.println(" ");
            System.out.printf("%s Veuillez saisir une ligne :%n", tempPlayer);
            int Y = scan.nextInt();
            System.out.println(" ");

            boatPositionPlayer2.takeAShot(X, Y, playedPositionPlayer1);
            playedPositionPlayer1.displayBoard();

            if (boatPositionPlayer2.takeAShot(X, Y, playedPositionPlayer1)) {
                System.out.println("Touche");
            }
            else {
                System.out.println("Loupe");
            }

            if (boatPositionPlayer2.victory()) {
                break;
            }

            tempPlayer = player2.getName();

            // ---------- Tour Joueur 2 ----------

            System.out.printf("Coup joue %s%n", tempPlayer);

            System.out.println(" ");
            System.out.println(" ");

            System.out.printf("%s Veuillez saisir une position X :%n", tempPlayer);
            X = scan.nextInt();
            System.out.println(" ");
            System.out.printf("%s Veuillez saisir une position Y :%n", tempPlayer);
            Y = scan.nextInt();
            System.out.println(" ");

            boatPositionPlayer1.takeAShot(X, Y, playedPositionPlayer2);
            playedPositionPlayer1.displayBoard();

            if (boatPositionPlayer2.takeAShot(X, Y, playedPositionPlayer1)) {
                System.out.println("Touche");
            }
            else {
                System.out.println("Loupe");
            }

            if (boatPositionPlayer1.victory()) {
                break;
            }
            tempPlayer = player1.getName();
        }

        System.out.printf("Victoire %s%n", tempPlayer);
        scan.close();
    }
}
