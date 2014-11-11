package edu.wpi.razer.theory.expression;

import edu.wpi.razer.theory.correlation.Correlation;
import edu.wpi.razer.theory.identifier.Identifier;

public interface Expression extends Correlation
{

	Expression configure(String q, Identifier quantifier);
	
}
