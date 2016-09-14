
public class TestHashtable {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.insert(new HashEntry("0", "Zero"));
		ht.insert(new HashEntry("11", "Eleven"));
		
		String ret = ht.get("5");
		ret = ht.get("0");
		ret = ht.get("11");
	}
}
