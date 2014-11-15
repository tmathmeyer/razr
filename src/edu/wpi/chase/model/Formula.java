package edu.wpi.chase.model;

import edu.wpi.chase.Model;
import edu.wpi.chase.Symbol;

public interface Formula
{
	boolean forceSatisfaction(Model m, Symbol ... over);

	boolean doesSatisfy(Model m, Symbol ... over);
}
