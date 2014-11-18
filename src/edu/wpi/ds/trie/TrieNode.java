package edu.wpi.ds.trie;

import java.util.HashSet;
import java.util.Set;


public class TrieNode<T> implements Trie<T> {

	//TODO: replace this with a non-shit data structure,
	//      as this one frankly is incredibly stupid
	private final Set<T[]> indexer = new HashSet<>();
	
	@Override
	public boolean index(T[] set)
	{
		boolean has = matches(set);
		
		indexer.add(set);
		
		return !has;
	}

	@Override
	public boolean matches(T[] set)
	{
		for(T[] tt : indexer)
		{
			if (eq(tt, set))
			{
				return true;
			}
		}
		return false;
	}

	private boolean eq(T[] tt, T[] set)
    {
	    if (tt.length != set.length)
	    {
	    	return false;
	    }
	    
	    for(int i = 0; i < tt.length; i++)
	    {
	    	if (!tt[i].equals(set[i]))
	    	{
	    		return false;
	    	}
	    }
	    return true;
    }

    @Override
    public Set<T[]> getAll()
    {
		return indexer;
    }
	
}
