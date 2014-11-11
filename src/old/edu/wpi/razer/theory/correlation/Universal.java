package old.edu.wpi.razer.theory.correlation;

import edu.wpi.razer.theory.expression.Expression;
import edu.wpi.razer.theory.hash.HashTree;
import edu.wpi.razer.theory.identifier.Identifier;

public class Universal implements Correlation
{
	//TODO: find something to replace this with????
	public Identifier quantifier;
	
	public Expression expression;
	
	public Universal(String q, Expression e)
	{
		quantifier = Identifier.makeInstance();
		expression = e.configure(q, quantifier);
	}
	
	public String toString()
	{
		return "∀"+quantifier+"."+expression;
	}
	
	@Override
	public Integer hash()
	{
		return expression.hashCode() * 3277;
	}

	@Override
	public HashTree<Correlation> register(HashTree<Correlation> lookup)
	{
		return expression.register(lookup).add(this);
	}

	@Override
	public Correlation replace(String from, String to)
	{
		return new Universal()
	}
}