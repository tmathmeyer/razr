package edu.wpi.ds.env;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public interface Environment<K, V> extends Iterable<EnvironmentBinding<K, V>>
{
	static class Named<K, V> implements Environment<K, V>
	{
		private final K name;
		private final Complete<K, V> rest;
		private final int size;
		
		public Named(K s, Complete<K, V> r)
		{
			name = s;
			rest = r;
			
			size = r==null?0:r.size();
		}

		@Override
		public Environment<K, V> with(K s)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public Environment<K, V> as(V s)
		{
			return new Complete<K, V>(this, s);
		}

		@Override
		public Iterator<EnvironmentBinding<K, V>> iterator()
		{
			return EnvironmentIterator.fromNamed(this);
		}

		@Override
		public int size()
		{
			return size;
		}

		@Override
        public Map<K, V> asMap()
        {
	        if (rest == null)
	        {
	        	return new HashMap<>();
	        }
	        
	        return rest.asMap();
        }
		
	}
	
	static class Complete<K, V> implements Environment<K, V>
	{
		private final Named<K, V> nameHolder;
		private final V value;
		
		private final int size;
		
		public Complete(Named<K, V> named, V s)
		{
			nameHolder = named;
			value = s;
			
			size = named.size()+1;
		}

		@Override
		public Environment<K, V> with(K s)
		{
			return new Named<>(s, this);
		}

		@Override
		public Environment<K, V> as(V s)
		{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public Iterator<EnvironmentBinding<K, V>> iterator()
		{
			return EnvironmentIterator.fromComplete(this);
		}
		
		@Override
		public int size()
		{
			return size;
		}

		@Override
        public Map<K, V> asMap()
        {
	        Map<K, V> map = nameHolder.asMap();
	        map.put(nameHolder.name, value);
	        return map;
        }
	}
	
	static class Base<K, V> implements Environment<K, V>
	{

		@Override
		public Environment<K, V> with(K s)
		{
			return new Named<>(s, null);
		}

		@Override
		public Environment<K, V> as(V s)
		{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public Iterator<EnvironmentBinding<K, V>> iterator()
		{
			return new Iterator<EnvironmentBinding<K, V>>(){

				@Override
				public boolean hasNext()
				{
					return false;
				}

				@Override
				public EnvironmentBinding<K, V> next()
				{
					return null;
				}
				
			};
		}

		@Override
		public int size()
		{
			return 0;
		}

		@Override
        public Map<K, V> asMap()
        {
	        return new HashMap<>();
        }
		
	}
	
	static class EnvironmentIterator<K, V> implements Iterator<EnvironmentBinding<K, V>>
	{

		private Complete<K, V> env;
		
		private EnvironmentIterator(Complete<K, V> e)
		{
			env = e;
		}
		
		@Override
		public boolean hasNext()
		{
			return env != null;
		}

		private static <K, V> Iterator<EnvironmentBinding<K, V>> fromComplete(Complete<K, V> complete)
		{
			return new EnvironmentIterator<>(complete);
		}

		private static <K, V> Iterator<EnvironmentBinding<K, V>> fromNamed(Named<K, V> named)
		{
			return new EnvironmentIterator<>(named.rest);
		}

		@Override
		public EnvironmentBinding<K, V> next()
		{
			V value = env.value;
			K key = env.nameHolder.name;
			
			env = env.nameHolder.rest;
			
			return new EnvironmentBinding<>(key, value);
		}
		
	}
	
	
	public static <K, V> Environment<K, V> env()
	{
		return new Base<>();
	}
	
	
	public Environment<K, V> with(K s);
	
	public Environment<K, V> as(V s);
	
	public Map<K, V> asMap();
	
	public int size();
	
	
	
	
	
}
