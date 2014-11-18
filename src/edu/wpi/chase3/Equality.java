package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

// TODO: implement somehow?
public class Equality implements Formula
{
	private final Function eval;
	
	private final String symbol; // hmm
	
	public Equality(Function e, String s)
	{
		eval = e;
		symbol = s;
	}

	@Override
    public boolean realize(Model model, Environment<String, Symbol> e)
    {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public String toString(boolean verbose)
    {
	    // TODO Auto-generated method stub
	    return null;
    }
}
