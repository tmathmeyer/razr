package edu.wpi.chase2;

public class Implies implements Formula
{
	private final Formula A, B;
	
	public Implies(Formula a, Formula b)
	{
		A = a;
		B = b;
	}

	@Override
	public String toString() {
		return A + " => " + B;
	}

	@Override
	public boolean chase(Model model)
	{
		if (A.chase(model))
		{
			return B.chase(model);
		}
		return true;
	}

	@Override
	public boolean chaseSpecifically(Model m, Symbol... addNewSymbol)
	{
		if (B instanceof Existential)
		{
			Creative aa = (Creative)A;
			if (aa.chaseSpecificallyCreation(m, addNewSymbol))
			{
				return B.chaseSpecifically(m, addNewSymbol);
			}
		}
		else if (A.chaseSpecifically(m, addNewSymbol))
		{
			if (B instanceof Creative)
			{
				Creative bb = (Creative)B;
				return bb.chaseSpecificallyCreation(m, addNewSymbol);
			}
			return B.chaseSpecifically(m, addNewSymbol);
		}
		return false;
	}
	
	
}
