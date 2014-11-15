package edu.wpi.chase;

import edu.wpi.chase.model.Formula;

public class Function implements Formula
{
	private final String name;
	private final String[] args;
	
	public int getParamCount()
	{
		return args.length;
	}
	
	public Function(String n, String ... args)
	{
		name = n;
		this.args = args;
	}

	@Override
	public String toString()
	{
		return name+"("+String.join(",", args)+")";
	}

	@Override
	public int hashCode()
	{
		return 31 + ((name == null) ? 0 : name.hashCode());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Function other = (Function) obj;
		if (name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		}
		else if (!name.equals(other.name))
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean forceSatisfaction(Model m, Symbol ... over)
	{
		boolean satisfied = true;
		
		for(Symbol s : over)
		{
			satisfied &= s.isTrueFor(this);
			s.setTrueFor(this);
		}
		
		return satisfied;
	}

	@Override
	public boolean doesSatisfy(Model m, Symbol... over)
	{
		boolean satisfied = true;
		
		for(Symbol s : over)
		{
			satisfied &= s.isTrueFor(this);
		}
		
		return satisfied;
	}
	
}
