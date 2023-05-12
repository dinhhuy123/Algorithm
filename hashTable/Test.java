package hashTable;

import java.util.Random;

public class Test {
    static final int NUMBER_OF_KEYS = 100000000;
	static final int MOD = 100000;
	static int[] keys = new int[NUMBER_OF_KEYS];
	static int[] values = new int[NUMBER_OF_KEYS];
	
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < keys.length; i++) {
			keys[i] = random.nextInt() % MOD;
			values[i] = random.nextInt() % MOD;
		}
		testDoubleHashingProbing();
	}

    public static void testDoubleHashingProbing() {
		HashTableADT<Integer, Integer> hashTable = new DoubleHashingProbingHashTable<>();
		long start = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			hashTable.insert(keys[i], values[i]);
			int value = hashTable.get(keys[i]);
			if (value != values[i]) System.out.println("Code again!");
		}
		
		long end = System.nanoTime();
		System.out.println("Quadratic probing: " + (end - start) / 1e9);
	}
}
