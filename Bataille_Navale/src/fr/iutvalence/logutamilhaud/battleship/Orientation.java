package fr.iutvalence.logutamilhaud.battleship;

public enum Orientation
{
	RIGHT(1,0),
	LEFT(-1,0),
	TOP(0,-1),
	BOTTOM(0,1),
	NOTHING(0,0);
	
	private final int deltaX;
	private final int deltaY;
	
	Orientation(int deltaX, int deltaY) 
	{
		this.deltaX = deltaX;
		this.deltaY = deltaY; 
	}
	
	public int dX() 
	{
		return deltaX;
	}
	
	public int dY() 
	{
		return deltaY;
	}
	
}