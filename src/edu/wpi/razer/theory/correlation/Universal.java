package edu.wpi.razer.theory.correlation;

import edu.wpi.razer.theory.expression.Expression;

public class Universal implements Correlation
{
	//TODO: find something to replace this with????
	public String quantifier;
	
	public Expression expression;
	
	public Universal(String q, Expression e)
	{
		quantifier = q;
		expression = e;
	}
	
	public String toString()
	{
		return "∀"+quantifier+"."+expression;
	}
}