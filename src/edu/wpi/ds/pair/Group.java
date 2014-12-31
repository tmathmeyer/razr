package edu.wpi.ds.pair;

public class Group<A, B> implements Comparable<Group<A, B>>
{
	private final A a;
	private final B b;
	
	public Group(A a, B b)
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
    public int compareTo(Group<A, B> arg0)
    {
	    if (arg0 == null)
	    {
	    	return 1;
	    }
	    if (arg0 == this)
	    {
	    	return 0;
	    }
	    
	    return getA().toString().compareTo(arg0.getA().toString());
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
	    
	    if (other instanceof Group)
	    {
	    	return getA().equals(((Group<A, B>) other).getA());
	    }
	    
	    return false;
	}
}
