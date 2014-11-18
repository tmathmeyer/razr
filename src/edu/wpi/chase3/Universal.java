package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

public class Universal implements Formula
{

	private final Formula wrapped;
	private final String id;
	
	public Universal(String i, Formula w)
	{
	    wrapped = w;
	    id = i;
    }

	@Override
    public boolean realize(Model model, Environment<String, Symbol> e)
    {
	    boolean realize = false;
		for(Symbol s : model.symbols())
	    {
	    	realize |= wrapped.realize(model, e.with(id).as(s));
	    }
		return realize;
    }

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {
		boolean realize = true;
		for(Symbol s : model.symbols())
	    {
	    	realize &= wrapped.isRealized(model, e.with(id).as(s));
	    }
		return realize;
    }

	@Override
    public String toString()
    {
	    return "∀." + id + "("+wrapped.toString()+")";
    }

	@Override
    public String toString(boolean verbose)
    {
	    return wrapped.toString(verbose);
    }

}
