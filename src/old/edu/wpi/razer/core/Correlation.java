package old.edu.wpi.razer.core;

public class Correlation
{
	private final BooleanExpression from, to;
	
	public Correlation(BooleanExpression from, BooleanExpression to)
	{
		this.from = from;
		this.to = to;
	}

	public BooleanExpression getTo()
	{
		return to;
	}

	public BooleanExpression getFrom()
	{
		return from;
	}
	
	@Override
	public String toString()
	{
		return from.toString() + " ⇒ " + to.toString();
	}
}
