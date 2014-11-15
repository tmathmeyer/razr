package edu.wpi.chase.model;

import edu.wpi.chase.Model;
import edu.wpi.chase.Symbol;

public class Implies implements Formula
{
	private final Formula A, B;
	
	public Implies(Formula a, Formula b)
	{
		A = a;
		B = b;
	}

	@Override
	public boolean forceSatisfaction(Model m, Symbol ... over)
	{
		if (A.doesSatisfy(m, over))
		{
			return B.forceSatisfaction(m, over);
		}
		return true;
	}

	@Override
	public boolean doesSatisfy(Model m, Symbol ... over)
	{
		if (A.doesSatisfy(m, over))
		{
			return B.doesSatisfy(m, over);
		}
		return true;
	}

	@Override
	public String toString() {
		return A + " => " + B;
	}
	
	
}
