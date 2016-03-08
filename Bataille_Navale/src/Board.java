/**
 * The Board class
 * @author logutn
 *
 */
public class Board
{
	/**
	 * a grid of characters 
	 */
	public char[][] grid;
	
	/**
	 * 
	 */
	public Board() {
		initGrid();
	}

	public void initGrid()
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				grid[i][j]='v';
			}
		}
	}

	public boolean putABoat(Boat ship, int x, int y, char orientation)
	{
		int i;

		if(grid[x][y]!='v')
		{
			return false;
		}

		if(orientation=='r')
		{
			for(i=x;i<(ship.size+x);i++)
			{
				if(grid[i][y]!='v')
				{
					return false;
				}
				else
				{
					for(i=x;i<(ship.size+x);i++)
					{
						grid[i][y]=ship.id;
					}
				}
			}
		}
		if(orientation=='b')
		{
			for(i=y;i<(ship.size-y);i--)
			{
				if(grid[x][i]!='v')
				{
					return false;
				}
				else
				{
					for(i=y;i<(ship.size-y);i--)
					{
						grid[x][i]=ship.id;
					}
				}
			}
		}
		if(orientation=='l')
		{
			for(i=x;i<(ship.size-x);i--)
			{
				if(grid[i][y]!='v')
				{
					return false;
				}
				else
				{
					for(i=x;i<(ship.size-x);i--)
					{
						grid[i][y]=ship.id;
					}
				}
			}
		}
		if(orientation=='t')
		{
			for(i=x;i<(ship.size+x);i++)
			{
				if(grid[x][i]!='v')
				{
					return false;
				}
				else
				{
					for(i=x;i<(ship.size+x);i++)
					{
						grid[x][i]=ship.id;
					}
				}
			}
		}

		return false;


	}
}
