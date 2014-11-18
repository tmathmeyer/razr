package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

public class Function implements Formula {

	private final String[] params;
	private final String name;
	
	public Function(String n, String ... p)
	{
		name = n;
		params = p;
	}

	@Override
	public boolean realize(Model model, Environment<String, Symbol> e)
	{
		Fact f = model.getFact(name);
		
		if (f == null)
		{
			f = new Fact(name, params);
			model.addFact(f);
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
