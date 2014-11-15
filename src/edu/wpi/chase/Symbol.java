package edu.wpi.chase;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.chase.model.Formula;

public class Symbol
{
	private static int counter = 0;
	
	private final int my;
	private final Set<Function> holdsTrueFor = new HashSet<>();
	
	private Symbol(int val)
	{
		my = val;
	}
	
	public static Symbol gensym()
	{
		return new Symbol(counter++);
	}
	
	public Symbol setTrueFor(Function f)
	{
		holdsTrueFor.add(f);
		return this;
	}

	@Override
	public String toString()
	{
		return "Symbol [id=" + my + ", holdsTrueFor=" + holdsTrueFor + "]";
	}
	
	public String stringTwo()
	{
		return ""+my;
	}
	
	public boolean isTrueFor(Formula f)
	{
		return holdsTrueFor.contains(f);
	}
	
}