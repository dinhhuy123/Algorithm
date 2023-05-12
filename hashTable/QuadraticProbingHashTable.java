package hashTable;

public class QuadraticProbingHashTable<K, V> extends OpenAddressingHashTableBase<K, V>{

	public QuadraticProbingHashTable() {
		super();
	}
	
	public QuadraticProbingHashTable(int capacity) {
		super(capacity);
	}

	public QuadraticProbingHashTable(double loadFactor, int capacity) {
		super(loadFactor, capacity);
	}
	
	public static int nextPowerOfTwo(int n) {
		return Integer.highestOneBit(n) << 1;
	}
	
	@Override
	protected void setupProbing(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int probe(int x) {
		// TODO Auto-generated method stub
		return (x * x + x >> 1);
	}
	
	@Override
	protected void increaseCapacity() { 
		capacity = nextPowerOfTwo(capacity);
	}

	@Override
	protected void adjustCapacity() {
		System.out.println("capacity adjust: " + capacity);
		int po2 = Integer.highestOneBit(capacity);
		System.out.println("po2:" + po2);
		if (capacity == po2) return;
		increaseCapacity();
	}
}
