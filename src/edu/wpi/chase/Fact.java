package edu.wpi.chase;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.wpi.ds.avl.AVL;
import edu.wpi.ds.avl.EmptyAVLTree;
import edu.wpi.ds.env.Environment;
import edu.wpi.ds.pair.OrderedEntry;

public class Fact implements Formula, Comparable<Fact>
{
	// this data structure is stupid, and needs to be replaced
	//private final Trie<Symbol> trie = new TrieNode<>();
	
	//private AVL<Group<Formula, AVL<Symbol>>> statements;
	private Map<AVL<Symbol>, Formula> statements = new HashMap<>();
	
	
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

	//TODO: make correct such that multiple theories can be added
	@Override
	public OrderedEntry<Boolean, Model> realize(Model model, Environment<String, Symbol> e)
	{	
		if (isRealized(model, e))
		{
			return new OrderedEntry<Boolean, Model>(false, model);
		}
		
		AVL<Symbol> syms = new EmptyAVLTree<>();
		Map<String, Symbol> map = e.asMap();
	    
	    for(int i = 0; i < paramsLength; i++)
	    {
	    	Symbol sym = map.get(params[i]);
	    	syms = syms.add(sym);
	    	if (sym == null)
	    	{
	    		throw new RuntimeException(name + "   " + String.join(",", params)+"   "+e.asMap());
	    	}
	    }
	    
	    return new OrderedEntry<Boolean, Model>(statements.put(syms, null)==null, model);
	}

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {	
		AVL<Symbol> syms = new EmptyAVLTree<>();
		Map<String, Symbol> map = e.asMap();
	    
	    for(int i = 0; i < paramsLength; i++)
	    {
	    	Symbol sym = map.get(params[i]);
	    	syms = syms.add(sym);
	    	if (sym == null)
	    	{
	    		throw new RuntimeException(name + "   " + String.join(",", params)+"   "+e.asMap());
	    	}
	    }
	    
	    return statements.containsKey(syms);
    }

	public String getName()
	{
		return name;
	}

	@Override
    public String toString()
    {
		Set<AVL<Symbol>> syms = statements.keySet();
		String[] jj = new String[syms.size()];
		
		int i = 0;
		for(AVL<Symbol> sa : syms)
		{
			jj[i++] = name+"("+String.join(",", asString(sa))+")";
		}
		
		if (jj.length == 0)
		{
			return name;
		}
		
	    return "["+String.join(" :: ", jj)+"]";
    }

	private String[] asString(AVL<Symbol> sa)
    {
		String[] result = new String[sa.size()];
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

	@Override
    public int hashCode()
    {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
	    return result;
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
	    Fact other = (Fact) obj;
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
    public int compareTo(Fact arg0)
    {
	    return getName().compareTo(arg0.getName());
    }
	
	
}
