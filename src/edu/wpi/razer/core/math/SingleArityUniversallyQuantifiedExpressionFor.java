package edu.wpi.razer.core.math;

import edu.wpi.razer.core.BooleanExpression;

public class SingleArityUniversallyQuantifiedExpressionFor extends BooleanExpression
{
	private final String universalQuantifier;
	private final String fancyFunctionName;
	
	public SingleArityUniversallyQuantifiedExpressionFor(String name, String string)
	{
		universalQuantifier = string;
		fancyFunctionName = name;
	}

	@Override
	public BooleanExpression of(String... string)
	{
		throw new IllegalStateException();
	}

	public String getUniversalQuantifier()
	{
		return universalQuantifier;
	}
	
	@Override
	public String toString()
	{
		return fancyFunctionName+"("+universalQuantifier+")";
	}
	
}
