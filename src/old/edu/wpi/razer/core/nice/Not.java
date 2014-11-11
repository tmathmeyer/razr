package old.edu.wpi.razer.core.nice;

import old.edu.wpi.razer.core.BooleanExpression;

public class Not extends BooleanExpression
{
	private final BooleanExpression a;
	
	public Not(BooleanExpression first)
	{
		a = first;
	}

	public BooleanExpression getA()
	{
		return a;
	}

	@Override
	public BooleanExpression of(String... string) {
		// TODO Auto-generated method stub
		return null;
	}
}
