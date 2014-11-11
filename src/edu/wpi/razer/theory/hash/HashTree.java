package edu.wpi.razer.theory.hash;

import java.util.List;

public interface HashTree<T extends Hashable>
{
	T lookup(T t);
	
	HashTree<T> add(T t);
	
	List<T> asList();
}
