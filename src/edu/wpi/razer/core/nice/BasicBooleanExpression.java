package edu.wpi.razer.core.nice;

import edu.wpi.razer.core.BooleanExpression;
import edu.wpi.razer.core.Correlation;
import edu.wpi.razer.core.math.SingleArityUniversallyQuantifiedExpressionFor;

public class BasicBooleanExpression extends BooleanExpression
{
	private final String name;
	
	public BasicBooleanExpression(String name)
	{
		this.name = name;
	}
	
	@Override
	public BooleanExpression of(String ... string)
	{
		return new SingleArityUniversallyQuantifiedExpressionFor(name, string[0]);
	}

	@Override
	public Correlation implies(BooleanExpression be)
	{
		throw new IllegalStateException();
	}
	
};
