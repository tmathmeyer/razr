package old.edu.wpi.razer.core.nice;

import old.edu.wpi.razer.core.BooleanExpression;

public class Or extends BooleanExpression
{
	private final BooleanExpression a, b;
	
	public Or(BooleanExpression first, BooleanExpression second)
	{
		a = first;
		b = second;
	}

	public BooleanExpression getA()
	{
		return a;
	}

	public BooleanExpression getB()
	{
		return b;
	}

	@Override
	public BooleanExpression of(String... string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString()
	{
		return a + " ∨ " + b;
	}
}
