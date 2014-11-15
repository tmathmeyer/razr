package edu.wpi.chase;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.chase.model.Existential;
import edu.wpi.chase.model.Formula;
import edu.wpi.chase.model.Implies;
import edu.wpi.chase.model.Universal;

public class Main
{
	public static void main(String ... args)
	{
		Model m = new Model();
		Set<Formula> theory = new HashSet<>();
		
		//Formula f = new Universal(new Function("F", "x"));
		Formula f = new Existential("x", new Function("F", "x"));
		Formula g = new Universal(new Implies(new Function("F", "x"), new Function("G", "x")));
		Formula h = new Universal(new Implies(new Function("N", "x"), new Function("G", "x")));
		Formula k = new Universal(new Implies(new Function("G", "x"), new Existential("y", new Function("F", "y"))));
		
		
		//Formula x = new Universal(new Implies(new Function("X", "m", "n"), new Function("Y", "m", "n")));
		Formula x = new Existential("m", new Function("X", "m", "n"));
		
		//System.out.println(f.forceSatisfaction(m));
		//System.out.println(g.forceSatisfaction(m));
		//System.out.println(h.forceSatisfaction(m));
		//System.out.println(k.forceSatisfaction(m));
		
		
		
		//theory.add(f);
		
		//System.out.println(x);
		x.forceSatisfaction(m);
		
		
		//System.out.println(m.argsAsStrings(3));
		
		
		
		
		
		
		//System.out.println(f);
		//System.out.println(g);
		//System.out.println(h);
		//System.out.println(k);
		
		System.out.println(m);
	}
}
