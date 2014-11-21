package edu.wpi.chase;

import edu.wpi.ds.env.Environment;
import edu.wpi.ds.pair.OrderedEntry;

public class And implements Formula
{
	private final Formula A, B;
	
	public And(Formula a, Formula b)
	{
		A = a;
		B = b;
	}

	@Override
    public OrderedEntry<Boolean, Model> realize(Model model, Environment<String, Symbol> e)
    {
		OrderedEntry<Boolean, Model> Ar = A.realize(model, e);
		OrderedEntry<Boolean, Model> Br = B.realize(Ar.getB(), e);
		
		return new OrderedEntry<Boolean, Model>(Ar.getA() || Br.getA(), Br.getB());
    }

	@Override
    public boolean isRealized(Model model, Environment<String, Symbol> e)
    {
		boolean Ar = A.isRealized(model, e);
		boolean Br = B.isRealized(model, e);
	    return Ar && Br;
	}

	@Override
    public String toString()
    {
	    return "(" + A + " & " + B + ")";
    }

	@Override
    public String toString(boolean verbose)
    {
	    return "(" + A.toString(verbose) + " & " + B.toString(verbose) + ")";
    }
}
