package edu.wpi.chase3;

public class Symbol
{
	private static int counter = 0;
	
	private final int my;
	
	private Symbol(int val)
	{
		my = val;
	}
	
	public static Symbol gensym()
	{
		return new Symbol(counter++);
	}

	@Override
	public String toString()
	{
		return "Symbol [id=" + my + "]";
	}
	
	public String stringTwo()
	{
		return ""+my;
	}
	
}