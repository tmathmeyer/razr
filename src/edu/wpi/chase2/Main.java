package edu.wpi.chase2;

public class Main
{
	public static void main(String ... args) throws InterruptedException
	{
		Theory theory = new Theory(new Existential("x", new Function("F", "x")));
		
		theory.addTheoryFormula(new Universal(new Implies(new Function("F", "x"), new Function("G", "x"))));
		theory.addTheoryFormula(new Universal(new Implies(new Function("G", "x"), new Function("Q", "x"))));
		theory.addTheoryFormula(new Universal(new Implies(new Function("G", "x"), new Function("R", "x"))));
		theory.addTheoryFormula(new Universal(new Implies(new Function("R", "x"), new Function("Z", "x"))));
		theory.addTheoryFormula(new Universal(new Implies(new Function("Z", "x"), new Existential("m", new Function("L", "x", "m")))));
		theory.addTheoryFormula(new Universal(new Implies(new Function("Q", "x"), new Existential("y", new Function("H", "x", "y")))));
		
		
		
		System.out.println(theory);
		System.out.println(theory.chase());
	}
	
	
	
	
	public static Symbol[] append(Symbol[] syms, Symbol n)
	{
		Symbol[] syms2 = new Symbol[syms.length+1];
		for(int i=0; i<syms.length; i++)
		{
			syms2[i] = syms[i];
		}
		syms2[syms.length] = n;
		return syms2;
	}
}
