package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

public class Existential implements Formula
{
	private final Formula wrapped;
	private final String name;
	
	public Existential(String n, Formula w)
	{
		wrapped = w;
		name = n;
	}
	
	@Override
    public boolean realize(Model model, Environment<String, Symbol> e)
    {
	    return wrapped.realize(model, e.with(name).as(model.addNewSymbol()));
    }

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {
		boolean realize = false;
		for(Symbol s : model.symbols())
	    {
	    	realize |= wrapped.isRealized(model, e.with(name).as(s));
	    }
		return realize;
    }

	@Override
    public String toString()
    {
		return "∃"+name+"."+wrapped;
    }

	@Override
    public String toString(boolean verbose)
    {
		return "∃"+name+"."+wrapped.toString(verbose);
    }
	
	

}
