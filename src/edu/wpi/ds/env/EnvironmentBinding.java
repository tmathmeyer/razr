package edu.wpi.ds.env;

public class EnvironmentBinding<K, V>
{
	private final K key;
	private final V value;
	
	public EnvironmentBinding(K k, V v)
	{
		key = k;
		value = v;
	}

	public K getKey()
	{
		return key;
	}

	public V getValue()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return "EnvironmentBinding [key=" + key + ", value=" + value + "]";
	}
	
	
}