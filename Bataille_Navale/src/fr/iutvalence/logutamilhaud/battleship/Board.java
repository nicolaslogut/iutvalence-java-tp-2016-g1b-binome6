package fr.iutvalence.logutamilhaud.battleship;
import fr.iutvalence.logutamilhaud.battleship.boats.Boat;
import fr.iutvalence.logutamilhaud.battleship.exceptions.InvalidPositionException;
import fr.iutvalence.logutamilhaud.battleship.exceptions.OccuppedPosition;
import fr.iutvalence.logutamilhaud.battleship.exceptions.OutOfRangeException;
// TODO public?
/**
 * Board of the game.
 * 
 * @author logut
 * @version 25/03
 */
final class Board
{
    /** Number of line of the board. */
    private static final int  NB_LINE    = 10;
    /** Number of column of the board. */
    private static final int  NB_COLUMN  = 10;
    /** Symbol of an empty case. */
    private static final char EMPTY_SLOT = '*';
    /** Symbol for a boat who was shot. */
    private static final char BOAT_SHOT  = 'X';
    /** Symbol for a shot miss. */
    private static final char MISS       = 'O';

    /** Board who represent the grid of the game. */
    private final char[][] grid;

    
    /** Initialize of the grid for the game. */
    public Board() 
    {
        grid = new char[NB_COLUMN][NB_LINE];
    	for (int i = 0; i < NB_COLUMN; i++) 
        {
            for (int j = 0; j < NB_LINE; j++) 
            {
                grid[i][j] = EMPTY_SLOT;
            }
        }
    }

    /**
     * Return if the point is in the board or not.
     * @param X the position in X
     * @param Y the position in Y
     * @return true is the point is in the board false if not.
     */
    private boolean isInBoard(int X,int Y)
    {
        return (((X >= 0) && (X < NB_COLUMN)) && ((Y >= 0) && (Y < NB_LINE)));
    }
    
    /**
     * Place a boat on the board.
     *
     * @param ship the boat that we want to place. 
     * @param oX position on x of the boat.
     * @param oY position on y of the boat.
     * @param ori orientation of the boat.
     *
     * @throws InvalidPositionException
     * @throws OutOfRangeException 
     */
    public void putABoat(Boat ship, int oX, int oY, Orientation ori) throws InvalidPositionException, OutOfRangeException 
    {
    	
    	/** delta of shift in x */
        int dX = ori.dX();
        /** delta of shift in y */
        int dY = ori.dY();
        
        
        if (grid[oX][oY] != EMPTY_SLOT) {
            throw new InvalidPositionException("Position already occuped");
        }     
        
        for (int i = 0; i < ship.size; i++) {
        	if (grid[oX + (dX * i)][oY + (dY * i)] != EMPTY_SLOT) {
        		throw new InvalidPositionException("Two boat can be on the same cell");
        	}
        }
        
        for (int j = 0; j < ship.size; j++) {
        	if(!isInBoard(oX + (dX * j),oY + (dY * j))){
        		throw new OutOfRangeException("The boat is over the grid");
        	}
		      grid[oX + (dX * j)][oY + (dY * j)] = ship.id;
		}
    }

    

    /**
     * Display the board on the console.
     */
    public void displayBoard()
    {
    	for (int i = 0; i < NB_LINE; i++)
    	{
    		for (int j = 0; j < NB_COLUMN; j++)
    		{
    			System.out.print(grid[j][i]);
    		}
    		System.out.print("\n"); 
    	}
    }
    
    @Override
    public String toString() {
    	StringBuilder representation = new StringBuilder(NB_LINE*(NB_COLUMN+1));
    	
    	for (int i = 0; i < NB_LINE; i++)
    	{
    		for (int j = 0; j < NB_COLUMN; j++)
    		{
    			representation.append(grid[j][i]);
    		}
    		representation.append("\n"); 
    	}
    	
    	return representation.toString();
    }
    /**
     * Shot a fire in the boats board.*
     * 
     * @param X x position
     * @param Y y position
     * @param displayBoard board where the shot is display
     * @return boolean true if there's a boat, false if not
     */
    public boolean takeAShot(int X, int Y, Board displayBoard) throws OccuppedPosition
    {
    	if(displayBoard.grid[X][Y]==MISS){
        	throw new OccuppedPosition("You already shot this cell");
        }
    	if (grid[X][Y] == EMPTY_SLOT) {
            displayBoard.grid[X][Y] = MISS;
        }
        if(grid[X][Y]!=EMPTY_SLOT) {
            grid[X][Y] = BOAT_SHOT;
            displayBoard.grid[X][Y] = BOAT_SHOT;
            return true;
        }
    	return false;
    }

    /**
     * Check if a player win.
     * @return true if someone win, false if not.
     */
    public boolean checkVictory()
    {
    	for(int i=0;i<NB_LINE;i++)
    	{
    		for(int j=0;j<NB_COLUMN;j++)
    		{
    			if(grid[i][j]!=EMPTY_SLOT)
    			{
    				if(grid[i][j]!=BOAT_SHOT)
    				{
    					return false;
    				}	
    			}
    		}
    	}
    	return true;
    }

}
