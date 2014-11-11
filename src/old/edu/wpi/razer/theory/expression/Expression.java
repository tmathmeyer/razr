package old.edu.wpi.razer.theory.expression;

import old.edu.wpi.razer.theory.correlation.Correlation;
import old.edu.wpi.razer.theory.identifier.Identifier;

public interface Expression extends Correlation
{

	Expression configure(String q, Identifier quantifier);
	
}
