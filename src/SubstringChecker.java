public class SubstringChecker {
    public boolean isSubstring(String s1, String s2) {
        int countIndex = 0;

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i=0; i<s1.length(); i++) {
            countIndex = s2.indexOf(s1.charAt(0), countIndex); //O(length(S2))
            if (countIndex == -1) {
                return false;
            }
            else {
                int wrapIndex = countIndex;
                for (int j=0; j<s2.length(); j++) {
                    if (wrapIndex+j == s2.length()) {
                        wrapIndex = -j;
                    }
                    if (s1.charAt(j) != s2.charAt(wrapIndex+j)) {
                        break;
                    }
                    if (j == s2.length()-1) {
                        return true;
                    }
                }
            countIndex++;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
    	SubstringChecker sc = new SubstringChecker();
    	System.out.println(sc.isSubstring("ANN", "ANA"));
    }
}

/*
ANN
NAN
*/
