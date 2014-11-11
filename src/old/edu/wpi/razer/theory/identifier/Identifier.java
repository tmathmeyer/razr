package old.edu.wpi.razer.theory.identifier;

import java.util.ArrayList;
import java.util.List;

public class Identifier
{
	private final static List<Identifier> INSTANCES = new ArrayList<Identifier>();
	private final int idNum;
	
	private Identifier(int size)
	{
		idNum = size;
	}
	
	@Override
	public String toString()
	{
		return "<id"+idNum+">";
	}

	public static Identifier makeInstance()
	{
		Identifier mx = new Identifier(INSTANCES.size());
		INSTANCES.add(mx);
		return mx;
	}
}
