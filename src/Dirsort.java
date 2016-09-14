import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Dirsort {
  public class DirComparator implements Comparator<String> {
    public int compare(String arg0, String arg1) {
      int[] countSlash = new int[2];
      for(int i=0; i<2; i++) {
        String strScan;
        if (i==0) {
          strScan = arg0;
        }
        else {
          strScan = arg1;
        }
        Scanner scan = new Scanner(strScan);
        scan.useDelimiter("/");
        countSlash[i] = 0;
        while (scan.hasNext()) {
          scan.next();
          countSlash[i]++;
        }
        scan.close();
      }

      if (countSlash[0] != countSlash[1]) {
        return countSlash[0] - countSlash[1];
      }
      else {
        return arg0.compareTo(arg1);
      }
    }

  }

  public String[] sort(String[] dirs) {
    Arrays.sort(dirs, new DirComparator());
    
    return dirs;
  }
}