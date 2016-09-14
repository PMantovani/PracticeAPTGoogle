import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
	
	public class CompareNames implements Comparator<String> {
		@Override
		public int compare(String arg0, String arg1) {
			String[] sepName0 = arg0.split("\\s+");
			String[] sepName1 = arg1.split("\\s+");
			
			int compareLast = sepName0[1].compareTo(sepName1[1]);
			if (compareLast == 0) {
				return sepName0[0].compareTo(sepName1[0]);
			}
			else {
				return compareLast;
			}
		}
	}
	
	public String[] dataCleanup(String[] names) {
		for (int i=0; i<names.length; i++) {
			String[] sepName = names[i].split(", ");
			if (sepName.length > 1) {
				names[i] = sepName[1] + " " + sepName[0];
			}
		}
		Arrays.sort(names, new CompareNames());
		return names;
    }
}
