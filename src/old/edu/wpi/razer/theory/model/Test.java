package old.edu.wpi.razer.theory.model;

import old.edu.wpi.razer.theory.correlation.Correlation;
import old.edu.wpi.razer.theory.correlation.Universal;
import old.edu.wpi.razer.theory.expression.Function;
import old.edu.wpi.razer.theory.expression.ImplicitaveExpression;
import old.edu.wpi.razer.theory.hash.EmptyHashTree;
import old.edu.wpi.razer.theory.hash.HashTree;
import old.edu.wpi.razer.theory.operation.ImplicativeOperation;

public class Test
{
	public static void main(String ... args)
	{
		Correlation first = new Universal("s", new ImplicitaveExpression(new Function("Student", "s"), new Function("Subject", "s"), ImplicativeOperation.UNIDIRECTIONAL));
		Correlation second = new Universal("q", new ImplicitaveExpression(new Function("Professor", "q"), new Function("Subject", "q"), ImplicativeOperation.UNIDIRECTIONAL));
		
		//System.out.println(first);
		//System.out.println(first.hashCode());
		
		register(first);
		
		System.out.println(lookup);
		
		register(second);
		
		System.err.println(lookup);
	}
	
	
	static HashTree<Correlation> lookup = new EmptyHashTree<>();
	
	public static void register(Correlation c)
	{
		lookup = c.register(lookup);
	}
	
	public static Correlation lookup(Correlation empty)
	{
		return lookup.lookup(empty);
	}
}
