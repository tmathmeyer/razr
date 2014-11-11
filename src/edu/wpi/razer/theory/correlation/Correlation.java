package edu.wpi.razer.theory.correlation;

import edu.wpi.razer.theory.hash.HashTree;
import edu.wpi.razer.theory.hash.Hashable;

public interface Correlation extends Hashable
{

	HashTree<Correlation> register(HashTree<Correlation> lookup);

	Correlation replace(String from, String to);

}
