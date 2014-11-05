package edu.wpi.razer.theory.model;

import edu.wpi.razer.theory.correlation.Correlation;
import edu.wpi.razer.theory.correlation.Universal;
import edu.wpi.razer.theory.expression.Function;
import edu.wpi.razer.theory.expression.ImplicitaveExpression;
import edu.wpi.razer.theory.operation.ImplicativeOperation;

public class Test
{
	public static void main(String ... args)
	{
		Correlation first = new Universal("x", new ImplicitaveExpression(new Function("Student", "x"), new Function("Subject", "x"), ImplicativeOperation.UNIDIRECTIONAL));
		
		System.out.println(first);
	}
}
