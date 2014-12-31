package edu.wpi.chase;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class TimeTest
{

	@Test
	public void test()
	{
		Random r = new Random();
		String left = randomstring(r);
		Theory t = new Theory(true, new Existential("x", new Function(left, "x")));
		int length = 4000;
		
		for(int i = 0; i < length; i++)
		{
			String right = randomstring(r);
			
			t.addFormula(new Universal("x", new Implies(new Function(left, "x"), new Function(right, "x"))));
			
			left = right;
		}
		
		System.out.println(t);
		
		Model m = t.chase();
		
		//System.out.println(m);
		
		assertTrue(m.symbols().size()==1);
		assertEquals(m.facts().size(), length+1);
		
	}
	
	private String randomstring(Random r)
	{
		char[] str = new char[10];
		for(int i=0;i<str.length;i++)
		{
			str[i] = (char) ('a' + Math.abs((r.nextInt() % 25)));
		}
		return new String(str);
	}

}
