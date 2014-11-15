package edu.wpi.chase2;

public class Function implements Creative
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
	public boolean chase(Model model)
	{
		ModelFunction mf = model.getFunctionByName(name);
		if (mf == null)
		{
			return false;
		}
		return model.getFunctionByName(name).matchesAny(model.getArgs(args.length));
	}

	@Override
	public boolean chaseSpecifically(Model m, Symbol... addNewSymbol)
	{
		int difference = addNewSymbol.length - args.length;
		if(difference < 0)
		{
			Model lackingCopy = m;
			for(Symbol s : addNewSymbol)
			{
				lackingCopy = lackingCopy.makeCrappyCopyWithout(s);
			}
			
			for(Symbol add : lackingCopy.getArgs(-difference).iterator().next())
			{
				addNewSymbol = Main.append(addNewSymbol, add);
			}
			
			m.mergeVars(lackingCopy);
		}
		
		
		if (addNewSymbol.length == args.length)
		{
			m.addNewMF(name, new ModelFunction(name, addNewSymbol));
			return true;
		}
		return false;
	}

	@Override
	public boolean chaseSpecificallyCreation(Model m, Symbol[] addNewSymbol)
	{
		int difference = addNewSymbol.length - args.length;
		if(difference < 0)
		{
			Model lackingCopy = m;
			for(Symbol s : addNewSymbol)
			{
				lackingCopy = lackingCopy.makeCrappyCopyWithout(s);
			}
			
			for(Symbol add : lackingCopy.getArgs(-difference).iterator().next())
			{
				addNewSymbol = Main.append(addNewSymbol, add);
			}
			
			m.mergeVars(lackingCopy);
		}
		
		
		if (addNewSymbol.length == args.length)
		{
			return m.addNewMF(name, new ModelFunction(name, addNewSymbol));
		}
		return false;
	}
}
