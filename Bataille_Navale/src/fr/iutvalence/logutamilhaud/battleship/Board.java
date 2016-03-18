package fr.iutvalence.logutamilhaud.battleship;

/**
 * Board of the game.
 * 
 * @author logut
 * @version 18/03
 */
public class Board {
    /** Board who represent the grid of the game. */
    public char[][] grid;
    /** Number of ligne of the board. */
    private final static int NB_LINE=10;
    /** Number of column of the board. */
    private final static int NB_COLUMN=10;
    /** Symbol of an empty case. */
    private final static char EMPTY_SLOT='V';
    
    
    /** Initialize of the grid for the game. */
    public Board() {
        for (int i = 0; i < NB_LINE; i++) {
            for (int j = 0; j < NB_COLUMN; j++) {
                grid[i][j] = EMPTY_SLOT;
            }
        }
    }

    // TODO This algorithm is buggy
    // TODO It's too early for this kind of implementation

    /**
     * Place a boat on the board.
     *
     * @param ship the boat that we want to place. 
     * @param x position on x of the boat.
     * @param y position on y of the boat.
     * @param orientation orientation of the boat.
     *
     * @return boolean true if the boat is on the board false if it's not possible.
     */
    public boolean putABoat(Boat ship, int x, int y, Orientation ori) {

        if (grid[x][y] !=EMPTY_SLOT) {
            return false;
        }
        
        switch(ori)
        {
        	case RIGHT:
        		        		
        	case LEFT:
        		
        	case TOP:
        		
        	case BOTTOM:
        		
        }
        
        
        
        
      /* old code that gonna be remove later */
        
        
        int i;
        // TODO Why don't you use switch?
        // TODO Why don't use an "enum" for orientation rather than a char?
        // TODO You can factorize these cases (I think)
        if (orientation == 'r') {
            for (i = x; i < (ship.size + x); i++) {
                if (grid[i][y] == 'v') {
                    for (i = x; i < (ship.size + x); i++) {
                        grid[i][y] = ship.id;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if (orientation == 'b') {
            for (i = y; i < (ship.size - y); i--) {
                if (grid[x][i] == 'v') {
                    for (i = y; i < (ship.size - y); i--) {
                        grid[x][i] = ship.id;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if (orientation == 'l') {
            for (i = x; i < (ship.size - x); i--) {
                if (grid[i][y] == 'v') {
                    for (i = x; i < (ship.size - x); i--) {
                        grid[i][y] = ship.id;
                    }
                }
                else {
                    return false;
                }
            }
        }
        if (orientation == 't') {
            for (i = x; i < (ship.size + x); i++) {
                if (grid[x][i] == 'v') {
                    for (i = x; i < (ship.size + x); i++) {
                        grid[x][i] = ship.id;
                    }
                }
                else {
                    return false;
                }
            }
        }

        return false;
    }
}
