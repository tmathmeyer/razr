package edu.wpi.chase2;

public class Universal implements Formula
{
	private final Formula form;
	
	public Universal(Formula f)
	{
		form = f;
	}

	@Override
	public String toString()
	{
		return "∀"+form.toString();
	}

	@Override
	public boolean chase(Model model)
	{
		for(Object s2 : model.symbols().toArray())
		{
			Symbol s = (Symbol)s2;
			if (!form.chaseSpecifically(model, s))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean chaseSpecifically(Model m, Symbol... addNewSymbol)
	{
		return form.chaseSpecifically(m, addNewSymbol);
	}
}
