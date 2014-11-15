package edu.wpi.chase.model;

import edu.wpi.chase.Function;
import edu.wpi.chase.Model;
import edu.wpi.chase.Symbol;

public class Existential implements Formula
{
	private final Function exists;
	private final String ehh;
	
	public Existential(String s, Function ex)
	{
		exists = ex;
		ehh = s;
	}
	
	@Override
	public boolean forceSatisfaction(Model m, Symbol ... over)
	{
		m.addNewSymbol(exists);
		return false;
	}

	@Override
	public String toString() {
		return "∃"+ehh+"."+exists;
	}

	@Override
	public boolean doesSatisfy(Model m, Symbol... over)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
