package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

public class Function implements Formula {

	private final String name;
	
	public Function(String n, String ... params)
	{
		name = n;
	}
	
	
	@Override
	public boolean chase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean realize(Environment<String, Symbol> e)
	{
		// TODO Auto-generated method stub
		return false;
	}


}
