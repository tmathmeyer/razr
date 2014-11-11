package edu.wpi.rzr.real;

import edu.wpi.rzr.types.Expression;
import edu.wpi.rzr.types.Identifier;

public class FunctionExpression implements Expression
{
	private final String name;
	private final Identifier[] args;
	
	public FunctionExpression(String name, String ... args)
	{
		this(name, fromArgs(args));
	}
	
	public FunctionExpression(String name, Identifier ... args)
	{
		this.name = name;
		this.args = args;
	}

	private static Identifier[] fromArgs(String[] args)
	{
		Identifier[] a = new Identifier[args.length];
		for(int i=0;i<args.length;i++)
		{
			a[i] = new StringIdentifier(args[i]);
		}
		return a;
	}

	@Override
	public Expression replaceAll(Identifier from, Identifier to)
	{
		// TODO Auto-generated method stub
		return null;
	}
}