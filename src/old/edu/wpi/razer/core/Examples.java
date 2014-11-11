package old.edu.wpi.razer.core;

import old.edu.wpi.razer.core.nice.BasicBooleanExpression;
import old.edu.wpi.razer.core.nice.ComplexBooleanExpression;

public class Examples
{
	public static void main(String ... args)
	{
		BooleanExpression student   = new BasicBooleanExpression("student");
		BooleanExpression subject   = new BasicBooleanExpression("subject");
		BooleanExpression professor = new BasicBooleanExpression("professor");
		
		
		
		register(student.of("x").implies(subject.of("x")));
		register(professor.of("x").implies(subject.of("x")));
		register(subject.of("x").implies(student.of("x").or(professor.of("x"))));
		register(subject.of("x").and(professor.of("x")).implies(BooleanExpression.FALSE));
		
		
		BooleanExpression TA = new ComplexBooleanExpression(2, "TA");
		BooleanExpression lecture = new BasicBooleanExpression("lecture");
		
		register(TA.of("c", "s").implies(lecture.of("c").and(student.of("s"))));
		
	}
	
	
	
	public static void register(Correlation c)
	{
		System.out.println(c);
	}
}
