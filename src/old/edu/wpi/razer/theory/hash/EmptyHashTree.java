package old.edu.wpi.razer.theory.hash;

import java.util.LinkedList;
import java.util.List;

public class EmptyHashTree<T extends Hashable> implements HashTree<T>
{
	@Override
	public T lookup(Hashable t) {
		return null;
	}

	@Override
	public HashTree<T> add(T t) {
		return new BranchingHashTree<T>(t);
	}

	@Override
	public List<T> asList() {
		return new LinkedList<T>();
	}
}
