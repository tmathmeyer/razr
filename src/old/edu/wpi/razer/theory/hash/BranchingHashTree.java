package old.edu.wpi.razer.theory.hash;

import java.util.List;

public class BranchingHashTree<T extends Hashable> implements HashTree<T>
{
	private final HashTree<T> greater, equal, less;
	
	private final T element;
	private final Integer hash;
	
	public BranchingHashTree(T t)
	{
		this(t, new EmptyHashTree<T>(), new EmptyHashTree<T>(), new EmptyHashTree<T>());
	}

	public BranchingHashTree(T element2, HashTree<T> add, HashTree<T> equal2, HashTree<T> less2)
	{
		greater = add;
		equal = equal2;
		less = less2;
		element = element2;
		hash = element2.hash();
	}

	@Override
	public T lookup(T t)
	{
		Integer g = t.hash();
		if (g > hash)
		{
			return greater.lookup(t);
		}
		if (g < hash)
		{
			return less.lookup(t);
		}
		if (t.equals(element))
		{
			return element;
		}
		return equal.lookup(t);
	}

	@Override
	public HashTree<T> add(T t) {
		Integer g = t.hash();
		if (g > hash)
		{
			return new BranchingHashTree<T>(element, greater.add(t), equal, less);
		}
		if (g < hash)
		{
			return new BranchingHashTree<T>(element, greater, equal, less.add(t));
		}
		return new BranchingHashTree<T>(element, greater, equal.add(t), less);
	}

	@Override
	public List<T> asList()
	{
		List<T> left = greater.asList();
		List<T> right = equal.asList();
		List<T> center = less.asList();
		
		center.addAll(left);
		center.addAll(right);
		center.add(element);
		
		return center;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for(T t : asList())
		{
			sb.append(t).append('\n');
		}
		
		return sb.toString();
	}

}
