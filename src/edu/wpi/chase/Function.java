package edu.wpi.chase;

import edu.wpi.ds.env.Environment;
import edu.wpi.ds.pair.OrderedEntry;

public class Function implements Formula {

	private final String[] params;
	private final String name;
	
	public Function(String n, String ... p)
	{
		name = n;
		params = p;
	}

	@Override
	public OrderedEntry<Boolean, Model> realize(Model model, Environment<String, Symbol> e)
	{
		Fact f = model.getFact(name);
		
		if (f == null)
		{
			f = new Fact(name, params);
			model = model.addFact(f);
		}
		
		f.setParams(params);
		return f.realize(model, e);
		
	}

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {
		Fact f = model.getFact(name);
		
		if (f == null)
		{
			return false;
		}
		
		f.setParams(params);
		return f.isRealized(model, e);
    }

	public String getName()
	{
		return name;
	}

	@Override
    public String toString()
    {
	    return name+"("+String.join(",", params)+")";
    }

	@Override
    public String toString(boolean verbose)
    {
	    return toString();
    }
}
