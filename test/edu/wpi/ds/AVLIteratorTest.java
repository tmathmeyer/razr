package edu.wpi.ds;

import org.junit.Test;

import edu.wpi.ds.avl.AVL;
import edu.wpi.ds.avl.EmptyAVLTree;

public class AVLIteratorTest
{

	@Test
	public void test()
	{
		AVL<Integer> numbers = new EmptyAVLTree<>();
		
		for(int i = 0; i < 32; i++)
		{
			numbers = numbers.add(i);
		}
		
		for(Integer i : numbers)
		{
			System.out.println(i);
		}
		
		System.out.println(numbers.searchAndReturn(5));
	}

}
