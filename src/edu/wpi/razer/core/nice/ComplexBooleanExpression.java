package edu.wpi.razer.core.nice;

import edu.wpi.razer.core.BooleanExpression;
import edu.wpi.razer.core.math.MultipleArityUniversiallyQuantifiedExpression;

public class ComplexBooleanExpression extends BooleanExpression
{
	private final int length;
	private final String name;
	
	public ComplexBooleanExpression(int i, String string)
	{
		length = i;
		name = string;
	}

	@Override
	public BooleanExpression of(String ... string)
	{
		return new MultipleArityUniversiallyQuantifiedExpression(name, first(length, string));
	}

	private String[] first(int size, String[] string)
	{
		String[] result = new String[size];
		for(int i=0;i<size;i++)
		{
			result[i] = string[i];
		}
		return result;
	}

	public String getName() {
		return name;
	}

}
