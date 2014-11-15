package edu.wpi.chase2;

import java.util.Arrays;
import java.util.Set;

public class ModelFunction
{
	private final String name;
	private final Symbol[] args;
	
	public ModelFunction(String n, Symbol[] addNewSymbol)
	{
		name = n;
		args = addNewSymbol;
	}

	@Override
	public String toString()
	{
		return name+"("+String.join(",", asStrings())+")";
	}
	
	private String[] asStrings()
	{
		String[] result = new String[args.length];
		int i = 0;
		for(Symbol s : args)
		{
			result[i++] = s.stringTwo();
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(args);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelFunction other = (ModelFunction) obj;
		if (!Arrays.equals(args, other.args))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public boolean matchesAny(Set<Symbol[]> args2)
	{
		for(Symbol[] val : args2)
		{
			if (val.equals(args))
			{
				return true;
			}
		}
		return false;
	}
}
