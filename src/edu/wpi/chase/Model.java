package edu.wpi.chase;

import edu.wpi.ds.avl.AVL;
import edu.wpi.ds.avl.EmptyAVLTree;
import edu.wpi.ds.pair.OrderedEntry;

//TODO: make class immutable
public class Model
{
	private final AVL<Fact> facts;
	private final AVL<Symbol> symbols;
	
	public Model(AVL<Fact> f, AVL<Symbol> s)
	{
		facts = f;
		symbols = s;
	}
	
	public OrderedEntry<Symbol, Model> addNewSymbol()
	{	
		Symbol s = Symbol.gensym();
		return new OrderedEntry<Symbol, Model>(s, new Model(facts, symbols.add(s)));
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
		
		for(Fact s : facts)
		{
			sb.append(s).append("\n");
		}
		
		return sb.toString();
	}
	
	public Fact getFact(String s)
	{
		return facts.searchAndReturn(new Fact(s));
	}
	
	public Model addFact(Fact f)
	{
		return new Model(facts.add(f), symbols);
	}

	public AVL<Symbol> symbols()
    {
	    return symbols;
    }
	
	public AVL<Fact> facts()
    {
	    return facts;
    }
	
	
	public static Model emptyModel()
	{
		return new Model(new EmptyAVLTree<Fact>(), new EmptyAVLTree<Symbol>());
	}
}
