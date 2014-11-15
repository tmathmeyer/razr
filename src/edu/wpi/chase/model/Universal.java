package edu.wpi.chase.model;

import edu.wpi.chase.Model;
import edu.wpi.chase.Symbol;

public class Universal implements Formula
{
	private final Formula form;
	
	public Universal(Formula f)
	{
		form = f;
	}
	
	@Override
	public boolean forceSatisfaction(Model m, Symbol ... over)
	{
		boolean satisfaction = true;
		
		for(Symbol s : m.symbols())
		{
			satisfaction &= form.forceSatisfaction(m, s);
		}
		
		return satisfaction;
	}

	@Override
	public String toString()
	{
		return form.toString();
	}

	@Override
	public boolean doesSatisfy(Model m, Symbol ... over)
	{
		boolean satisfaction = true;
		
		for(Symbol s : m.symbols())
		{
			satisfaction &= form.doesSatisfy(m, s);
		}
		
		return satisfaction;
	}
}
