package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

public interface Formula
{
	public boolean chase();
	
	public boolean realize(Environment<String, Symbol> e);
}