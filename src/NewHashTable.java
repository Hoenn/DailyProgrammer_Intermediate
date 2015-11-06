import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class NewHashTable<K,V> {
	private float loadFactor;
	private int capacity;
	private int numEntries;
	private ArrayList<LinkedList<HashEntry<K,V>>> hashTable;
	public NewHashTable(int initCap, float loadFactor) 
	{
		if(initCap<0)
			throw new IllegalArgumentException("Cannot have negative size capacity");
		
		capacity = initCap;
		this.loadFactor=loadFactor;
		numEntries=0;
		hashTable = new ArrayList<LinkedList<HashEntry<K,V>>>(capacity);
		initializeBuckets(hashTable, capacity);
	}
	public NewHashTable(int initCap)
	{
		this(initCap, 0.75f);
	}
	public NewHashTable()
	{
		this(11, 0.75f);
	}
	private void initializeBuckets(ArrayList<LinkedList<HashEntry<K,V>>> temp, int capacity)
	{
		for(int i =0; i<capacity; i++)
		{
			temp.add(new LinkedList<HashEntry<K,V>>());
		}
	}
	public boolean isEmpty()
	{
		return hashTable.size()<=0;
	}
	public int size()
	{
		return hashTable.size();
	}
	private int compress(int hash)
	{
		return hash%capacity;
	}
	public boolean containsKey(K key)
	{
		int hash= key.hashCode();
		int index = Math.abs(compress(hash));
		LinkedList<HashEntry<K,V>> initPos = hashTable.get(index);
		Iterator<HashEntry<K,V>> iterator = initPos.iterator();
		boolean found = false;
		while(!found && iterator.hasNext())
		{
			HashEntry<K,V> h = iterator.next();
			if(h.key.equals(key))
				found=true;
		}
		
		return found;
		
	}
	public V put(K key, V value)
	{
		if(key==null)
			throw new NullPointerException("Key cannot be null");
		if(value==null)
			throw new NullPointerException("Value cannot be null");
		int hash = key.hashCode();
		int index = Math.abs(compress(hash));
		V valueAtLocation = null;
		LinkedList<HashEntry<K, V>> position = hashTable.get(index);
		Iterator<HashEntry<K,V>> iterator = position.iterator();

		boolean found = false;
		while(!found && iterator.hasNext())
		{
			HashEntry<K, V> h = iterator.next();
			if(h.key.equals(key))
			{				
				valueAtLocation = h.getValue();
				iterator.remove();
				found=true;
			}
		}
		
		position.add(new HashEntry<K, V>(key, value));

		if(valueAtLocation==null)
		{
			numEntries++;
			if(numEntries/capacity>= loadFactor)
				rehash();
		}

		return valueAtLocation;
	}
	public V get(K key)
	{
		if(key==null)
			throw new NullPointerException();
		int hash= key.hashCode();
		int index = Math.abs(compress(hash));
		LinkedList<HashEntry<K,V>> chain = hashTable.get(index);
		if(chain.size()==0)
			return null;
		Iterator<HashEntry<K,V>> iterator = chain.iterator();
		boolean found=false;
		HashEntry<K,V> currentEntry = null;
		while(!found && iterator.hasNext())
		{		
			currentEntry = iterator.next();
			if(currentEntry.getKey().equals(key))
			{
				found=true;
			}
		}
		return currentEntry.getValue();
	}
	public V remove(K key)
	{
		int hash= key.hashCode();
		int index = Math.abs(compress(hash));
		
		LinkedList<HashEntry<K,V>> chain = hashTable.get(index);
		if(chain.size()==0)
			return null;
		Iterator<HashEntry<K,V>> iterator = chain.iterator();
		boolean found = false;
		HashEntry<K,V> currentEntry = null;
		while(!found && iterator.hasNext())
		{
			currentEntry = iterator.next();
			if(currentEntry.key.equals(key))
			{
				iterator.remove();
				found=true;
				numEntries--;
				
			}
		}
		
		return currentEntry.value;
	}
	public void rehash()
	{
		int newCapacity = capacity*2;
		ArrayList<LinkedList<HashEntry<K, V>>> temp = new ArrayList<LinkedList<HashEntry<K, V>>>(newCapacity);
		initializeBuckets(temp, newCapacity);
		
		for(int i =0; i<capacity; i++)
		{
			LinkedList<HashEntry<K,V>> currentChain = hashTable.get(i);
			//If there is at least one entry
			if(currentChain.size()>0)
			{
				//Get the chain 
				Iterator<HashEntry<K,V>> iterator = currentChain.iterator();
				//Go to each entry and add to new larger list
				//Chains should break up from larger capacity
				while(iterator.hasNext())
				{
					HashEntry<K,V> currentEntry = iterator.next();
					int hash = currentEntry.getKey().hashCode();
					int index = Math.abs(hash % newCapacity);
					LinkedList<HashEntry<K,V>> chainOnNewList= temp.get(index);
					chainOnNewList.add(currentEntry);
				}
			}
		}
		System.out.println("Rehashing now Old capacity: "+capacity+" New Capacity: "+newCapacity);
		hashTable = temp;
		this.capacity= hashTable.size();
	}
	public void clear()
	{
		initializeBuckets(hashTable, capacity);
	}
	public String toString()
	{
		StringBuilder output = new StringBuilder("{");
		
		for(int i = 0; i <capacity; i++)
		{
			LinkedList<HashEntry<K,V>> currentChain= hashTable.get(i);
			if(currentChain.size()>0)
			{
				Iterator<HashEntry<K,V>> iterator = currentChain.iterator();
				while(iterator.hasNext())
				{
					HashEntry<K,V> currentEntry = iterator.next();
					output.append(currentEntry.getKey()+"="+currentEntry.getValue());
					output.append(",");
				}
			}
			//Maybe line break
		}
		//Removing trailing comma
		output.delete(output.length()-1, output.length());
		output.append("}");
		return output.toString();
	}
	
	@SuppressWarnings("hiding")
	public class HashEntry<K, V> {
	      private K key;
	      private V value;
	 
	      HashEntry(K key, V value) {
	            this.key = key;
	            this.value = value;
	      }     
	 
	      public K getKey() {
	            return key;
	      }
	 
	      public V getValue() {
	            return value;
	      }
	}
}
