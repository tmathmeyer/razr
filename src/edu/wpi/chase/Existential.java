package edu.wpi.chase;

import edu.wpi.ds.env.Environment;
import edu.wpi.ds.pair.OrderedEntry;

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
    public OrderedEntry<Boolean, Model> realize(Model model, Environment<String, Symbol> e)
    {
		OrderedEntry<Symbol, Model> res = model.addNewSymbol();
		
	    return wrapped.realize(res.getB(), e.with(name).as(res.getA()));
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
