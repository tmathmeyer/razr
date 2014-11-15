package edu.wpi.chase2;

import static edu.wpi.chase2.Main.append;

public class Existential implements Formula
{
	private final Formula exists;
	private final String ehh;
	
	public Existential(String s, Formula ex)
	{
		exists = ex;
		ehh = s;
	}

	@Override
	public String toString()
	{
		return "∃"+ehh+"."+exists;
	}

	@Override
	public boolean chase(Model model)
	{
		return exists.chaseSpecifically(model, model.addNewSymbol());
	}

	@Override
	public boolean chaseSpecifically(Model m, Symbol ... addNewSymbol)
	{
		return exists.chaseSpecifically(m, append(addNewSymbol, m.addNewSymbol()));
	}

}
