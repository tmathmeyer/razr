package edu.wpi.chase;

public class Main
{
	public static void main(String ... args)
	{
		t1();
		t2();
		birthday();
	}
	
	
	public static void t1()
	{
		Theory t = new Theory(true, new Existential("x", new Function("F", "x")));
		
		t.addFormula(new Universal("x", new Implies(new Function("F", "x"), new Function("G", "x"))));
		t.addFormula(new Universal("x", new Implies(new Function("F", "x"), new Existential("y", new Function("P", "y")))));
		t.addFormula(new Universal("x", new Implies(new Function("F", "x"), new Existential("y", new Function("M", "y")))));

		t.addFormula(new Universal("x", new Implies(new Function("F", "x"), new Existential("z", new Function("P", "z")))));
		

		t.addFormula(new Universal("x", new Implies(new Function("P", "x"), new And(new Function("Q", "x"), new Function("Z", "x")))));
		t.addFormula(new Universal("x", new Implies(new Function("M", "x"), new And(new Function("Q", "x"), new Function("Z", "x")))));
		t.addFormula(new Universal("x", new Implies(new Function("G", "x"), new Function("P", "x"))));
		
		System.out.println(t.chase());
		System.out.println(t);
	}
	
	public static void t2()
	{
		Theory t = new Theory(true, new Existential("y", new Existential("x", new Function("F", "x", "y"))));
		
		t.addFormula(new Universal("y", new Universal("x", new Implies(new Function("F", "x", "y"), new And(new Function("M", "x"), new Function("N", "y"))))));
		t.addFormula(new Universal("y", new Universal("x", new Implies(new Function("F", "x", "y"), new Function("G", "x", "y")))));
		
		System.out.println(t.chase());
		System.out.println(t);
	}
	
	
	
	public static void birthday()
	{
		Theory t = new Theory(true, new Existential("y", new Existential("x", new Function("F", "x", "y"))));
		
		t.addFormula(new Universal("b", new Universal("n", new Implies(new Function("known", "b", "n"), new And(new Function("Book", "b"), new Function("Name", "n"))))));
		
		//System.out.println(t.chase());
		System.out.println(t);
		
		/*
		    known(b, n) => Book(b) & Name(n)
			date(b, n) = d => known(b, n) & Date(d)
			
			-- Add Birthday
			addBirthday(b1, b2, n, d) => Book(b1) & Book(b2) & Name(n) & Date(d)
			addBirthday(b1, b2, n, d) & date(b1, n_) = d_ => date(b2, n_) = d_
			
			addBirthday(b1, b2, n, d) => date(b2, n) = d
			
			-- Delete Birthday
			delBirthday(b1, b2, n) => Book(b1) & Book(b2) & Name(n)
			delBirthday(b1, b2, n) & date(b2, n_) = d_ => date(b1, n_) = d_
			
			-- Find Birthday
			findBirthday(b, n) = d => date(b, n) = d
			date(b, n) = d => findBirthday(b, n) = d
			
			-- Remind
			remind(b, d, n) => Book(b) & Date(d) & Name(n)
			remind(b, d, n) => date(b, n) = d
			date(b, n) = d => remind(b, d, n)
			
			-- Init Book
			initBook(b) & known(b, n) => Falsehood
			
			-- ? ADD WORKS
			-- addBirthday(book1(), book2(), name1(), date1()) 
			-- findBirthday(book2(), name1()) = date1() => Falsehood
			
			-- ? DEL IS UNDO
			-- findBirthday(Book1(), Name1()) = Date1()
			-- Date1() = findBirthday(Book3(), Name1()) => Falsehood
			
			-- ? BUSY DAY
			-- busyDay(b, d) => exists m. exists n. remind(b, d, n) & remind(b, d, m)
			-- busyDay(Book1(), Today())
		 */
	}
}
