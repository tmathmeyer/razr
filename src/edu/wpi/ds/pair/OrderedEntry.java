package edu.wpi.ds.pair;

public class OrderedEntry<A extends Comparable<A>, B> implements Comparable<OrderedEntry<A, B>>
{
	private final A a;
	private final B b;
	
	public OrderedEntry(A a, B b)
	{
		this.a = a;
		this.b = b;
	}
	
	public A getA()
	{
		return a;
	}
	
	public B getB()
	{
		return b;
	}
	
	@Override
	public int hashCode()
	{
		return a.hashCode();
	}

	@Override
    public int compareTo(OrderedEntry<A, B> arg0)
    {
	    if (arg0 == null)
	    {
	    	return 1;
	    }
	    if (arg0 == this)
	    {
	    	return 0;
	    }
	    
	    return getA().compareTo(arg0.getA());
    }
	
	@SuppressWarnings("unchecked")
    @Override
	public boolean equals(Object other)
	{
		if (other == null)
	    {
	    	return false;
	    }
	    if (other == this)
	    {
	    	return true;
	    }
	    
	    if (other instanceof OrderedEntry)
	    {
	    	return getA().equals(((OrderedEntry<A, B>) other).getA());
	    }
	    
	    return false;
	}
}
