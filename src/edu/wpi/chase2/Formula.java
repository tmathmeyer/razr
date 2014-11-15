package edu.wpi.chase2;

public interface Formula
{

	boolean chase(Model model);

	boolean chaseSpecifically(Model m, Symbol ... addNewSymbol);

}
