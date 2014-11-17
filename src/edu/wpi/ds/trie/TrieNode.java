package edu.wpi.ds.trie;

import java.util.HashSet;
import java.util.Set;


public class TrieNode<T> implements Trie<T> {

	//TODO: replace this with a non-shit data structure,
	//      as this one frankly is incredibly stupid
	private final Set<T[]> indexer = new HashSet<>();
	
	@Override
	public Trie<T> index(T[] set)
	{
		indexer.add(set);
		
		return this;
	}

	@Override
	public boolean matches(T[] set)
	{
		return indexer.contains(set);
	}
	
}
