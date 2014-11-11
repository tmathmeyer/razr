package edu.wpi.razer.theory.lambda;

import edu.wpi.razer.theory.correlation.Correlation;
import edu.wpi.razer.theory.hash.HashTree;

public class LambdaExpression implements Correlation
{

	private final Correlation e;
	private final String λvar;
	
	
	public LambdaExpression(String λvar2, Correlation replace)
	{
		λvar = λvar2;
		e = replace;
	}


	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		if (other == null)
		{
			return false;
		}
		
		if (other instanceof LambdaExpression)
		{
			LambdaExpression o = (LambdaExpression)other;
			
			if (o.λvar.equals(λvar))
			{
				return e.equals(o.e);
			}
			
			return o.e.replace(o.λvar, λvar).equals(e);
		}
		
		return false;
	}


	@Override
	public Integer hash()
	{
		return 7 * e.hash();
	}


	@Override
	public HashTree<Correlation> register(HashTree<Correlation> lookup)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Correlation replace(String from, String to)
	{
		if (from.equals(λvar))
		{
			return this;
		}
		return new LambdaExpression(λvar, e.replace(from,  to));
	}
}