package edu.wpi.ds.trie;

import java.util.Set;

/**
 * 
 * A data structure for storing overlapping lists of things
 * 
 */
public interface Trie<T>
{
	public boolean index(T[] set);
	
	public boolean matches(T[] set);
	
	public Set<T[]> getAll();
}
