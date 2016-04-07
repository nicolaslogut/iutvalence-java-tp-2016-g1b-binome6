package fr.iutvalence.logutamilhaud.battleship;

/**
 * Board of the game.
 * 
 * @author logut
 * @version 25/03
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
     * Place a boat on the board.
     *
     * @param ship the boat that we want to place. 
     * @param oX position on x of the boat.
     * @param oY position on y of the boat.
     * @param orientation orientation of the boat.
     *
     * @return boolean true if the boat is on the board false if it's not possible.
     */
    public boolean putABoat(Boat ship, int oX, int oY, Orientation ori) 
    {
    	/** delta of shift in x */
        int dX = ori.dX();
        /** delta of shift in y */
        int dY = ori.dY();
        /** increment of the first loop */
        int i;
        /** increment of the second loop */
        int j;
        
        
        if (grid[oX][oY] !=EMPTY_SLOT) 
        {
            return false;
        }
        
        for (i = oX; i <ship.size; i++) 
	        {
		        if (grid[oX + dX*i][oY] == EMPTY_SLOT) 
			        {
		        		for (j = oY; j<ship.size; j++) 
		        			{
		        				grid[oX + dX*i][oY + dY*j] = ship.id;
		        			}
			        }
                else 
                	{
                		return false;
                	}
            }
        
        return false;
    }
    /**
     * Display the bord on the console.
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
     * Shot a fire in the boats board.
     * @param X x position
     * @param Y y posistion
     * @return boolean true if there's a boat, false if not
     */
    public boolean takeAShot(int X, int Y)
    {
    	if(grid[X][Y]!=EMPTY_SLOT)
    	{
    		grid[X][Y]='X';
    		// Savoir quel bateau est touché ?
    	}
    }


    /**
     *  Marque on the display board where the shot are fire and if a bot is touch.
     * @param X x position
     * @param Y y posistion
     */
    public void displayAShot(int X, int Y)
    {
    	if(takeAShot(X,Y)==true)
    	{
    		grid[X][Y]='X';
    	}
    	else
    	{
    		grid[X][Y]='O';
    	}
    }










}
