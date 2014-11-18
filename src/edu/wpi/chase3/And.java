package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

public class And implements Formula
{
	private final Formula A, B;
	
	public And(Formula a, Formula b)
	{
		A = a;
		B = b;
	}

	@Override
    public boolean realize(Model model, Environment<String, Symbol> e)
    {
		boolean Ar = A.realize(model, e);
		boolean Br = B.realize(model, e);
	    return Ar || Br;
    }

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {
		boolean Ar = A.isRealized(model, e);
		boolean Br = B.isRealized(model, e);
	    return Ar && Br;
	}

	@Override
    public String toString()
    {
	    return "(" + A + " & " + B + ")";
    }

	@Override
    public String toString(boolean verbose)
    {
	    return "(" + A.toString(verbose) + " & " + B.toString(verbose) + ")";
    }
}
