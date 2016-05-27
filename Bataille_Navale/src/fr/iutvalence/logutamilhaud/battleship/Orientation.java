package fr.iutvalence.logutamilhaud.battleship;

/**
 * Enumeration who manage the orientation of the boat.
 *
 * @author Amilhaud
 * @version final
 */
public enum Orientation
{
	/** Delta for right. */
	RIGHT(1,0),
	/** Delta for left. */
	LEFT(-1,0),
	/** Delta for top. */
	TOP(0,-1),
	/** Delta for bottom. */
	BOTTOM(0,1);

	/** Attribute for X. */
	private final int deltaX;
	/** Attribute for Y. */
	private final int deltaY;

	/** Constructor.
	 *
	 * @param deltaX value in X.
	 * @param deltaY value in Y.
     */
	Orientation(int deltaX, int deltaY)
	{
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

    /** Getter of dX value. */
	public int dX()
	{
		return deltaX;
	}

    /** Getter of dY value. */
	public int dY()
	{
		return deltaY;
	}

}
