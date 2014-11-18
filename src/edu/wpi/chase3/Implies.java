package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

public class Implies implements Formula
{
	private final Formula left, right;
	
	public Implies(Formula l, Formula r)
	{
		left = l;
		right = r;
	}

	@Override
    public boolean realize(Model model, Environment<String, Symbol> e)
    {
	    if (left.isRealized(model, e))
	    {
	    	return right.realize(model, e);
	    }
	    return false;
    }

	@Override
    public String toString()
    {
	    return left + " => " + right;
    }

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {
		if (left.isRealized(model, e))
	    {
	    	return right.isRealized(model, e);
	    }
	    return true;
    }

	@Override
    public String toString(boolean verbose)
    {
		return left.toString(verbose) + " => " + right.toString(verbose);
    }

}
