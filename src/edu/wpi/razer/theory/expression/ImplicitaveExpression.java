package edu.wpi.razer.theory.expression;

import edu.wpi.razer.theory.correlation.Correlation;
import edu.wpi.razer.theory.hash.HashTree;
import edu.wpi.razer.theory.identifier.Identifier;
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
		return from + "⇒" + to;
	}
	
	@Override
	public Integer hash()
	{
		return (from.hashCode() + operation.ordinal()) * to.hashCode();
	}

	@Override
	public HashTree<Correlation> register(HashTree<Correlation> lookup)
	{
		return from.register(to.register(lookup)).add(this);
	}

	@Override
	public Expression configure(String q, Identifier quantifier)
	{
		return new ImplicitaveExpression(from.configure(q, quantifier), to.configure(q, quantifier), operation);
	}
}
