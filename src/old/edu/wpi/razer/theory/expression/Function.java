package old.edu.wpi.razer.theory.expression;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import old.edu.wpi.razer.theory.correlation.Correlation;
import old.edu.wpi.razer.theory.hash.HashTree;
import old.edu.wpi.razer.theory.identifier.Identifier;

public class Function implements Expression
{
	public String name;
	public Map<String, Identifier> identifiers;
	
	//TODO: use something besides string ??
	public Function(String n, String ... ids)
	{
		identifiers = idsToMap(ids);
		name = n;
	}
	
	private Map<String, Identifier> idsToMap(String[] ids)
	{
		Identifier id = Identifier.makeInstance();
		Map<String, Identifier> result = new HashMap<>();
		for(String s : ids)
		{
			result.put(s, id);
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		return name+"("+csv()+")";
	}
	
	private Set<String> vals()
	{
		Set<String> result = new HashSet<String>();
		for(Identifier i : identifiers.values())
		{
			result.add(i.toString());
		}
		return result;
	}
	
	private String csv()
	{
		return String.join(",", vals());
	}
	
	@Override
	public Integer hash()
	{
		return 873 * (name.hashCode() + (5 * identifiers.size()));
	}

	@Override
	public HashTree<Correlation> register(HashTree<Correlation> lookup)
	{
		Correlation c = lookup.lookup(this);
		if (equals(c))
		{
			return lookup;
		}
		return lookup.add(this);
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == null)
		{
			return false;
		}
		if (other == this)
		{
			return true;
		}
		if (other instanceof Function)
		{
			return this.name.equals(((Function)other).name);
		}
		return false;
	}

	@Override
	public Expression configure(String q, Identifier quantifier)
	{
		if (identifiers.get(q) != null)
		{
			identifiers.put(q, quantifier);
		}
		
		return this;
	}
}
