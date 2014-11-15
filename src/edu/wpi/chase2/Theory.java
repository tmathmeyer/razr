package edu.wpi.chase2;

import java.util.HashSet;
import java.util.Set;

public class Theory
{
	private final Set<Formula> formulae = new HashSet<>();
	private final Formula seed;
	
	public Theory(Formula s)
	{
		seed = s;
	}
	
	public void addTheoryFormula(Formula a)
	{
		formulae.add(a);
	}
	
	@Override
	public String toString() {
		return "Theory [formulae=" + formulae + ", seed=" + seed + "]";
	}

	public Model chase() throws InterruptedException
	{
		Model m = new Model();
		seed.chase(m);
		boolean triggered;
		do
		{
			triggered = false;
			for(Formula f : formulae)
			{
				boolean res = f.chase(m);
				triggered |= res;
				//System.out.println(f + " triggered "+ res);
			}
		}
		while(triggered);
		
		return m;
	}
}
