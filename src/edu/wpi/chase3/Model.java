package edu.wpi.chase3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Model
{
	private final Map<String, Fact> facts = new HashMap<>();
	private final Set<Symbol> symbols = new HashSet<>();
	
	public Symbol addNewSymbol()
	{
		Symbol gensym = Symbol.gensym();
		symbols.add(gensym);
		return gensym;
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
		
		for(Fact s : facts.values())
		{
			sb.append(s).append("\n");
		}
		
		return sb.toString();
	}
	
	public Fact getFact(String s)
	{
		return facts.get(s);
	}
	
	public void addFact(Fact f)
	{
		facts.put(f.getName(), f);
	}

	public Set<Symbol> symbols()
    {
	    Set<Symbol> syms = new HashSet<>();
	    
	    for(Symbol s : symbols)
	    {
	    	syms.add(s);
	    }
	    
	    return syms;
    }
}
