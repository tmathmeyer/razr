package edu.wpi.chase;

import edu.wpi.ds.env.Environment;
import edu.wpi.ds.pair.OrderedEntry;

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
    public OrderedEntry<Boolean, Model> realize(Model model, Environment<String, Symbol> e)
    {
	    boolean realize = false;
	    Model latest = model;
		for(Symbol s : model.symbols())
	    {
	    	OrderedEntry<Boolean, Model> res = wrapped.realize(latest, e.with(id).as(s));
	    	realize |= res.getA();
	    	latest = res.getB();
	    }
		return new OrderedEntry<Boolean, Model>(realize, latest);
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
