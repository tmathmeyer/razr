package edu.wpi.razer.core;

import edu.wpi.razer.core.nice.And;
import edu.wpi.razer.core.nice.Not;
import edu.wpi.razer.core.nice.Or;

public abstract class BooleanExpression
{

	public abstract BooleanExpression of(String ... string);
	
	public Correlation implies(BooleanExpression be)
	{
		return new Correlation(this, be);
	}

	BooleanExpression or(BooleanExpression of)
	{
		return new Or(this, of);
	}
	
	BooleanExpression and(BooleanExpression of)
	{
		return new And(this, of);
	}
	
	BooleanExpression inverse(BooleanExpression of)
	{
		return new Not(this);
	}

	public final static BooleanExpression FALSE = new BooleanExpression(){

		@Override
		public BooleanExpression of(String... string)
		{
			throw new IllegalStateException();
		}

		@Override
		public Correlation implies(BooleanExpression be)
		{
			throw new RuntimeException();
		}
		
		@Override
		public String toString()
		{
			return "FALSE";
		}
		
	};
}
