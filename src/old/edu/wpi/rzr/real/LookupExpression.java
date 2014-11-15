package old.edu.wpi.rzr.real;

import old.edu.wpi.rzr.types.Expression;
import old.edu.wpi.rzr.types.Identifier;

public class LookupExpression implements Expression
{
	private final int ID;
	
	public LookupExpression(int i)
	{
		ID = i;
	}
	
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
		
		if (other instanceof LookupExpression)
		{
			return ID == ((LookupExpression)other).ID;
		}
		
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return ID;
	}

	@Override
	public Expression replaceAll(Identifier from, Identifier to)
	{
		return this;
	}
}
