package edu.wpi.chase2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Model
{
	private final Set<Symbol> symbols = new HashSet<>();
	private final Map<String, ModelFunction> functions = new HashMap<>();
	
	public Symbol addNewSymbol()
	{
		Symbol s = Symbol.gensym();
		symbols.add(s);
		return s;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Model:\n");
		
		for(Symbol s : symbols)
		{
			sb.append(s).append("\n");
		}
		
		sb.append("\n");
		
		for(ModelFunction s : functions.values())
		{
			sb.append(s).append("\n");
		}
		
		return sb.toString();
	}

	public Set<Symbol> symbols()
	{
		return symbols;
	}
	
	public Set<Symbol[]> getArgs(int size)
	{
		while(symbols.size() < size)
		{
			symbols.add(Symbol.gensym());
		}
		Set<Symbol[]> result = new HashSet<>();
		Set<Symbol[]> lastvals = getLastVals(size-1);
		
		for(Symbol s : symbols)
		{
			for(Symbol[] sa : lastvals)
			{
				Symbol[] sa2 = new Symbol[size];
				for(int i = 0; i < size-1; i++)
				{
					sa2[i] = sa[i];
				}
				sa2[size-1] = s;
				result.add(sa2);
			}
		}
		
		
		return result;
	}

	private Set<Symbol[]> getLastVals(int i)
	{
		if (i == 0)
		{
			Set<Symbol[]> result = new HashSet<>();
			Symbol[] a = new Symbol[0];
			result.add(a);
			return result;
		}
		if (i == 1)
		{
			Set<Symbol[]> result = new HashSet<>();
			for(Symbol s : symbols)
			{
				Symbol[] a = {s};
				result.add(a);
			}
			return result;
		}
		
		return getArgs(i);
	}
	
	public String argsAsStrings(int len)
	{
		StringBuilder sb = new StringBuilder("{");
		Set<Symbol[]> syms = getArgs(len);
		for(Symbol[] ss : syms)
		{
			sb.append("[");
			String[] sss = new String[ss.length];
			for(int i=0; i<ss.length; i++)
			{
				sss[i] = ss[i].stringTwo();
			}
			sb.append(String.join(",", sss));
			sb.append("]");
		}
		sb.append("}");
		return sb.toString();
	}

	public boolean addNewMF(String name, ModelFunction modelFunction)
	{
		return functions.put(name, modelFunction) == null;
	}
	
	public Model makeCrappyCopyWithout(Symbol s)
	{
		Model m = new Model();
		for(Symbol ss : symbols)
		{
			if (!ss.equals(s))
			{
				m.addSymbol(ss);
			}
		}
		return m;
	}

	private void addSymbol(Symbol ss)
	{
		symbols.add(ss);
	}

	public void mergeVars(Model lackingCopy)
	{
		symbols.addAll(lackingCopy.symbols);
		functions.putAll(lackingCopy.functions);
	}

	public ModelFunction getFunctionByName(String name)
	{
		return functions.get(name);
	}
}
