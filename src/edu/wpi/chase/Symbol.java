package edu.wpi.chase;

public class Symbol implements Comparable<Symbol>
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

	@Override
    public int compareTo(Symbol arg0)
    {
	    return my - arg0.my;
    }
	
}