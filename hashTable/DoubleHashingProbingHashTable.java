package hashTable;

import java.util.ArrayList;

public class DoubleHashingProbingHashTable<K, V> extends OpenAddressingHashTableBase<K, V>{
	private int delta;
	
	public DoubleHashingProbingHashTable() {
		super();
	}
	
	public DoubleHashingProbingHashTable(int capacity) {
		super(capacity);
	}

	public DoubleHashingProbingHashTable(double loadFactor, int capacity) {
		super(loadFactor, capacity);
	}
	
	private static int setPrimeCapcity(int capacity) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		if (capacity >= 2) primeNumbers.add(2);
		for (int i = 3; i <= capacity; i++) {
			if (isPrime(i)) primeNumbers.add(i);
		}
		capacity = primeNumbers.get(primeNumbers.size() - 1);
		
		return capacity;
	}
	
	private static boolean isPrime(int capacity) {
		if (capacity < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(capacity); i++) {
			if (capacity % i == 0) return false;
		}
		return true;
	}
	
	private int hashCodeToIndexSecond(int hashedKey) {
		int index = 1;
		return (int) (((hashedKey & 0xFFFFFFFFFL) * (index += 2)) % capacity); 
	}
	
	@Override
	protected void setupProbing(K key) {
		delta = hashCodeToIndexSecond(key.hashCode());
		if (delta == 0) {
			delta = 1;
		}
	}
	
	@Override
	protected int probe(int x) {
		return x * delta;
	}
	
	@Override
	protected void increaseCapacity() {
		capacity = setPrimeCapcity(capacity * 2);
	}

	@Override
	protected void adjustCapacity() {
		if (isPrime(capacity)) return;
		increaseCapacity();
	}

}
