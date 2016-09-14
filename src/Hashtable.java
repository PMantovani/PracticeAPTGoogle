import java.util.ArrayList;
import java.util.HashMap;

// Hashtable:
// Key is unique, even if hashCode maps 2 or more keys to the same hash.
// Value stores something, doesn't matter what for any hash operation.
// hashCode is an arithmetic (simple) operation on the key to distribute all keys evenly in the array
//
// Hash collisions are solved by many methods:
//  - Separate chaining: Each bucket has a list of all collisions (more space needed) (linked lists)
//  - Linear Probing: try next position in the array
//  - Quadratic Probing: the interval between probes is increased by adding the successive outputs of a quadratic polynomial to the starting value
//  - Double Hashing: Interval between probes is computed by a second hash function


public class Hashtable {

	HashEntry[] table;
	
	public Hashtable() {
		table = new HashEntry[16];
	}
	
	public int insert(HashEntry entry) {
		int hash = entry.getKey().hashCode() % table.length; // Hashcode
		
		int count = 0;
		while (table[hash] != null && !table[hash].getKey().equals(entry.getKey())) {
			hash = (hash+1) % table.length; // Linear probing
			if (count == table.length)
				return -1; // All array is filled
			count++;
		}
		
		table[hash] = entry; // Put entry in hashtable.
		return hash;
	}
	
	public String get(String key) {
		int hash = key.hashCode() % table.length;
		
		if (table[hash] == null) {
			return null;
		}
		
		int count = 0;
		while (!table[hash].getKey().equals(key)) {
			if (count >= table.length)
				return null;
			count++;
			hash = (hash+1) % table.length; // Linear probing
			if (table[hash] == null) {
				return null;
			}
		}
		return table[hash].getValue();
	}
}
