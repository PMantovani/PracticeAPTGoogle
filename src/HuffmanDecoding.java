import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanDecoding {
  public String decode(String archive, String[] dictionary) {
    HashMap<String, Character> map = new HashMap<String, Character>();
    String decoded = "";
    //int sequence = 0;
    int initial = 0;
    for (int i=0; i<dictionary.length; i++) {
      map.put(dictionary[i], (char)(i+65));
    }

    for (int i=0; i<archive.length(); i++) {
      if (map.containsKey(archive.substring(initial, i+1))) {
        decoded += map.get(archive.substring(initial, i+1));
        initial = i+1;
      }
    }

    return decoded.toUpperCase();
  }
}
