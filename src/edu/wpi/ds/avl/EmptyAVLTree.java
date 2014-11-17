package edu.wpi.ds.avl;

public class EmptyAVLTree<E extends Comparable<E>> implements AVL<E>
{
	@Override
	public E getNode()
	{
		return null;
	}

	@Override
	public AVL<E> add(E i)
	{
		return new AVLTree<E>(i);
	}

	@Override
	public AVL<E> remove(E i)
	{
		return this;
	}

	@Override
	public boolean isEmpty()
	{
		return true;
	}

	@Override
    public String toString()
    {
	    return "[]";
    }

	@Override
	public AVL<E> getLeft()
	{
		return this;
	}

	@Override
	public AVL<E> getRight()
	{
		return this;
	}

	@Override
	public int depth()
	{
		return 0;
	}

	@Override
	public int getBalance()
	{
		return 0;
	}

	@Override
	public AVL<E> balance()
	{
		return this;
	}

	@Override
	public void print(int depth)
	{

	}

	@Override
	public boolean hasElement(E e)
	{
		return false;
	}

	@Override
    public E rightmost()
    {
	    return null;
    }

	@Override
    public AVL<E> rotateRight()
    {
	    return this;
    }

	@Override
    public AVL<E> rotateLeft()
    {
	    return this;
    }
}