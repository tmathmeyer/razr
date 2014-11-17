package edu.wpi.chase3;

import edu.wpi.ds.trie.Trie;
import edu.wpi.ds.trie.TrieNode;

public class Fact
{
	//stores the "sets" of arguments that this fact is true for
	private Trie<Symbol> trie;
	
	
	public Fact()
	{
		trie = new TrieNode<>();
	}
	
	
}
