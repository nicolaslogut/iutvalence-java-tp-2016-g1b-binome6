package fr.iutvalence.logutamilhaud.battleship;

/**
 * Board of the game.
 * 
 * @author logut
 * @version 25/03
 */
public class Board extends Exception
{
    /** Board who represent the grid of the game. */
    public char[][] grid;
    /** Number of line of the board. */
    private final static int NB_LINE=10;
    /** Number of column of the board. */
    private final static int NB_COLUMN=10;
    /** Symbol of an empty case. */
    private final static char EMPTY_SLOT='*';
    /** Symbol for a boat who was shot. */
    private final static char BOAT_SHOT='X';
    /** Symbol for a shot miss. */
    private final static char MISS='O';
    
    
    /** Initialize of the grid for the game. */
    public Board() 
    {
        grid = new char[NB_LINE][NB_COLUMN];
    	for (int i = 0; i < NB_LINE; i++) 
        {
            for (int j = 0; j < NB_COLUMN; j++) 
            {
                grid[i][j] = EMPTY_SLOT;
            }
        }
    }
    
    /**
     * Return if the point is in the board or not.
     * @param X the position in X
     * @param Y the position in
     * @return true is the point is in the board false if not.
     */
    public boolean isInBoard(int X,int Y)
    {
    	if((X>=0 && X<NB_LINE) && (Y>=0 && Y<NB_LINE))
    	{
    		return true;
    	}
    	return false;
    }
    
    /**
     * Place a boat on the board.
     *
     * @param ship the boat that we want to place. 
     * @param oX position on x of the boat.
     * @param oY position on y of the boat.
     * @param orientation orientation of the boat.
     *
     * @return boolean true if the boat is on the board false if it's not possible.
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
            throw new InvalidPositionException("Position d�ja occup�e");
        }
        
        if(isInBoard(ship.size*dX + oX,ship.size*dY + oY)==false) {
        	throw new OutOfRangeException("Le bateau d�passe de la grille");
        }
        
        
        for (int i = 0; i < ship.size; i++) {
        	if (grid[oX + dX*i][oY + dY*i] != EMPTY_SLOT) {
        		throw new OutOfRangeException("Le bateau passe sur un autre bateau");
        	}
        }
        
        for (int j = 0; j < ship.size; j++) {
		      grid[oX + dX*j][oY + dY*j] = ship.id;
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

    /**
     * Shot a fire in the boats board.*
     * 
     * @param X x position
     * @param Y y position
     * @param boardShot board who was shot
     * @param displayBoard board where the shot is display
     * @return boolean true if there's a boat, false if not
     */
    public boolean takeAShot(int X, int Y, Board displayBoard)
    {
    	if(grid[X][Y]!=EMPTY_SLOT)
    	{
    		grid[X][Y]=BOAT_SHOT;
    		displayBoard.grid[X][Y]=BOAT_SHOT;
    		return true;
    	}
    	else
    	{
    		displayBoard.grid[X][Y]=MISS;
    	}
    	return false;
    }

    /**
     * Check if a player win.
     * @return true if someone win, false if not.
     */
    public boolean checkVitctory()
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
