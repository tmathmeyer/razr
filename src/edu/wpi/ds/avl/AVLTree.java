package edu.wpi.ds.avl;

public class AVLTree<E extends Comparable<E>> implements AVL<E>
{
	private final E node;
	private final AVL<E> left;
	private final AVL<E> right;
	
	private final int balance;
	private final int depth;

	@Override
    public String toString()
    {
	    return "AVLTree [(" + node + "), left=" + left + ", right=" + right + "]";
    }

	public AVLTree(E i, AVL<E> l, AVL<E> r)
	{
		left = l;
		right = r;
		node = i;
		
		int ll = left.depth();
		int rr = right.depth();
		
		depth = Math.max(ll, rr) + 1;
		
		balance = ll - rr;
	}
	
	public AVLTree(E i)
	{
		this(i, new EmptyAVLTree<E>(), new EmptyAVLTree<E>());
	}

	@Override
	public E getNode()
	{
		return node;
	}

	@Override
	public AVL<E> add(E i)
	{
		if (i.compareTo(getNode()) > 0)
		{
			return new AVLTree<E>(node, left, right.add(i)).balance();
		}
		return new AVLTree<E>(node, left.add(i), right).balance();
	}

	@Override
	public AVL<E> remove(E i)
	{
		int compare = i.compareTo(node);
		
		if (compare == 0)
		{
			if (left.depth() + right.depth() == 0)
			{
				return new EmptyAVLTree<E>();
			}
			
			if (left.depth() == 0)
			{
				return right;
			}
			
			if (right.depth() == 0)
			{
				return left;
			}
			
			E lrr = getLeft().rightmost();
			
			return new AVLTree<>(lrr, left.remove(lrr), right).balance();
			
		}
		else if(compare > 0)
		{
			return new AVLTree<E>(getNode(), getLeft(), getRight().remove(i));
		}
		return new AVLTree<E>(getNode(), getLeft().remove(i), getRight());
	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}

	@Override
	public AVL<E> getLeft()
	{
		return this.left;
	}

	@Override
	public AVL<E> getRight()
	{
		return this.right;
	}

	@Override
	public int depth()
	{
		return depth;
	}

	@Override
	public int getBalance()
	{
		return balance;
	}

	@Override
	public AVL<E> balance()
	{
		int bal = getBalance();
		if (Math.abs(bal) < 2)
		{
			return this;
		}

		if (bal > 1)
		{
			AVL<E> Y = getLeft();
			if (Y.getBalance() == -1)
			{
				Y = Y.rotateRight();
			}
			return rotateLeft();
		}
		
		AVL<E> Y = getRight();
		if (Y.getBalance() == 1)
		{
			Y = Y.rotateLeft();
		}
		return rotateRight();
	}

	@Override
	public void print(int depth)
	{
		for (int i = 0; i < depth; i++)
		{
			System.out.print("  ");
		}
		System.out.println(this.getNode().toString());
		getLeft().print(depth + 1);
		getRight().print(depth + 1);
	}

	@Override
	public boolean hasElement(E e)
	{
		if (this.getNode().equals(e))
		{
			return true;
		}
		if (this.getNode().compareTo(e) > 0)
		{
			return getLeft().hasElement(e);
		}
		return getRight().hasElement(e);
	}

	@Override
    public E rightmost()
    {
	    if (getRight().depth() == 0)
	    {
	    	return node;
	    }
	    
	    return right.rightmost();
    }

	@Override
    public AVL<E> rotateRight()
    {
	    return new AVLTree<E>(getRight().getNode(),
	    		              new AVLTree<E>(getNode(), getLeft(), getRight().getLeft()),
	    		              getRight().getRight());
    }

	@Override
    public AVL<E> rotateLeft()
    {
		return new AVLTree<E>(getLeft().getNode(),
	              new AVLTree<E>(getNode(), getRight(), getLeft().getRight()),
	              getLeft().getLeft());
    }
}