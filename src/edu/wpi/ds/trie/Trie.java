package edu.wpi.ds.trie;

/**
 * 
 * A data structure for storing overlapping lists of things
 * 
 */
public interface Trie<T>
{
	public Trie<T> index(T[] set);
	
	public boolean matches(T[] set);
}
