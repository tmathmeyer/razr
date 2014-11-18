package edu.wpi.chase3;

import java.util.Map;
import java.util.Set;

import edu.wpi.ds.env.Environment;
import edu.wpi.ds.trie.Trie;
import edu.wpi.ds.trie.TrieNode;

public class Fact implements Formula
{
	// this data structure is stupid, and needs to be replaced
	private final Trie<Symbol> trie = new TrieNode<>();
	
	private final int paramsLength;
	private final String name;
	
	private String[] params;
	
	public void setParams(String[] params)
	{
		if (params.length != paramsLength)
		{
			throw new RuntimeException("HEY!!! YOU CANT DO THAT\n"+String.join(",", params));
		}
		this.params = params;
	}
	
	public Fact(String n, String ... p)
	{
		name = n;
		paramsLength = p.length;
	}

	@Override
	public boolean realize(Model model, Environment<String, Symbol> e)
	{	
		if (isRealized(model, e))
		{
			return false;
		}
		
		Symbol[] syms = new Symbol[paramsLength];
		Map<String, Symbol> map = e.asMap();
	    
	    for(int i = 0; i < syms.length; i++)
	    {
	    	syms[i] = map.get(params[i]);
	    	if (syms[i] == null)
	    	{
	    		throw new RuntimeException("fuck");
	    	}
	    }
	    
	    return trie.index(syms);
	}

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {	
		Symbol[] syms = new Symbol[paramsLength];
		Map<String, Symbol> map = e.asMap();
	    
	    for(int i = 0; i < syms.length; i++)
	    {
	    	syms[i] = map.get(params[i]);
	    	if (syms[i] == null)
	    	{
	    		throw new RuntimeException(name + "   " + String.join(",", params)+"   "+e.asMap());
	    	}
	    }
	    
	    return trie.matches(syms);
    }

	public String getName()
	{
		return name;
	}

	@Override
    public String toString()
    {
		Set<Symbol[]> syms = trie.getAll();
		String[] jj = new String[syms.size()];
		
		int i = 0;
		for(Symbol[] sa : syms)
		{
			jj[i++] = name+"("+String.join(",", asString(sa))+")";
		}
		
	    return "["+String.join(" :: ", jj)+"]";
    }

	private String[] asString(Symbol[] sa)
    {
		String[] result = new String[sa.length];
		int i = 0;
		for(Symbol s : sa)
		{
			result[i++] = s.stringTwo();
		}
		return result; 
    }

	@Override
    public String toString(boolean verbose)
    {
	    return toString();
    }
}
