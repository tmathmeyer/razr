package edu.wpi.chase;

import edu.wpi.ds.env.Environment;
import edu.wpi.ds.pair.OrderedEntry;

public interface Formula
{	
	public OrderedEntry<Boolean, Model> realize(Model model, Environment<String, Symbol> e);
	
	public boolean isRealized(Model model, Environment<String, Symbol> e);

	public String toString(boolean verbose);
}