package edu.wpi.chase;

import java.util.HashSet;
import java.util.Set;

import edu.wpi.ds.env.Environment;

public class Theory
{
	private final Existential seed;
	private final boolean verbose;
	private final Set<Formula> formulae = new HashSet<Formula>();
	
	public Theory(Boolean v, Existential s)
	{
		seed = s;
		verbose = v;
	}
	
	public void addFormula(Formula f)
	{
		formulae.add(f);
	}
	
	public Model chase()
	{
		Model m = Model.emptyModel();
		m = seed.realize(m, Environment.env()).getB();
		boolean triggered;
		do
		{
			triggered = false;
			for(Formula f : formulae)
			{
				if (!f.isRealized(m, Environment.env()))
				{
					m = f.realize(m, Environment.env()).getB();
					triggered = true;
				}
			}
		}
		while(triggered);
		
		return m;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Theory:\n - formulae:\n");
		for(Formula f : formulae)
		{
			sb.append("    ").append(f.toString(verbose)).append("\n");
		}
		sb.append(" - seed:\n    ").append(seed).append("\n\n");
		
		
		
		return sb.toString();
	}
}
