package edu.wpi.razer.theory.expression;

import edu.wpi.razer.theory.operation.ImplicativeOperation;

public class ImplicitaveExpression implements Expression
{
	public Expression from, to;
	
	public ImplicativeOperation operation;
	
	public ImplicitaveExpression(Expression from, Expression to, ImplicativeOperation operation)
	{
		this.from = from;
		this.to = to;
		this.operation = operation;
	}
	
	@Override
	public String toString()
	{
		return from + " ⇒ " + to;
	}
}
