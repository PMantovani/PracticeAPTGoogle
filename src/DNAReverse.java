
public class DNAReverse {
	public String reverse(String dna) {
		String copy = "";
		for (int i=dna.length()-1; i>=0; i--) {
			copy += dna.charAt(i);
		}
		
		return copy;
	}
}