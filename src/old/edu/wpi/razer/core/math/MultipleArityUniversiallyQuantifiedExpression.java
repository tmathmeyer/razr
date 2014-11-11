package old.edu.wpi.razer.core.math;

import old.edu.wpi.razer.core.BooleanExpression;

public class MultipleArityUniversiallyQuantifiedExpression extends BooleanExpression
{
	private final String[] universalQuantifiers;
	private final String fancyFunctionName;
	
	public MultipleArityUniversiallyQuantifiedExpression(String name, String ... string)
	{
		universalQuantifiers = string;
		fancyFunctionName = name;
	}

	@Override
	public BooleanExpression of(String... string)
	{
		throw new IllegalStateException();
	}

	public String getUniversalQuantifier(int index)
	{
		return universalQuantifiers[index];
	}
	
	@Override
	public String toString()
	{
		return fancyFunctionName+"("+asArgString(universalQuantifiers)+")";
	}

	private String asArgString(String[] universalQuantifiers2)
	{
		StringBuilder sb = new StringBuilder();
		if (universalQuantifiers.length > 0)
		{
			int i = 0;
			sb.append(universalQuantifiers[i++]);
			do
			{
				sb.append(',');
						sb.append(universalQuantifiers[i++]);
			}
			while(i < universalQuantifiers.length);
		}
		return sb.toString();
	}
	
}
