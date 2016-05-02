package fr.iutvalence.logutamilhaud.battleship;

/**
 * TODO.
 *
 * @author TODO
 * @version TODO
 */
public enum Orientation
{
	/** TODO. */
	RIGHT(1,0),
	/** TODO. */
	LEFT(-1,0),
	/** TODO. */
	TOP(0,-1),
	/** TODO. */
	BOTTOM(0,1),
	/** TODO. */
	NOTHING(0,0);

	/** TODO. */
	private final int deltaX;
	/** TODO. */
	private final int deltaY;

	/** TODO.
	 *
	 * @param deltaX TODO
	 * @param deltaY TODO
     */
	Orientation(int deltaX, int deltaY)
	{
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

    /** TODO. */
	public int dX()
	{
		return deltaX;
	}

    /** TODO. */
	public int dY()
	{
		return deltaY;
	}

}
