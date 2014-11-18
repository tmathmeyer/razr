package edu.wpi.chase3;

import edu.wpi.ds.env.Environment;

public interface Formula
{	
	public boolean realize(Model model, Environment<String, Symbol> e);
	
	public boolean isRealized(Model model, Environment<String, Symbol> e);

	public String toString(boolean verbose);
}