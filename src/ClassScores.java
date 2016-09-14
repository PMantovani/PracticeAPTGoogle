import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClassScores {
	public int[] findMode(int[] scores) {
		HashMap<Integer,Integer> mapOfCounts = new HashMap<Integer,Integer>();
		ArrayList<Integer> listOfModes = new ArrayList<Integer>();
		int maxCount = 0;
		
		for (int i=0; i<scores.length; i++) {
			if (mapOfCounts.containsKey(scores[i])) {
				mapOfCounts.put(scores[i], mapOfCounts.get(scores[i])+1);
			}
			else {
				mapOfCounts.put(scores[i], 1);
			}
			
			if (mapOfCounts.get(scores[i]) > maxCount) {
				listOfModes.clear();
				listOfModes.add(scores[i]);
				maxCount++;
			}
			else if (mapOfCounts.get(scores[i]) == maxCount) {
				listOfModes.add(scores[i]);
			}
		}
		
		int[] modes = new int[listOfModes.size()];
		for (int i=0; i<listOfModes.size(); i++) {
			modes[i] = listOfModes.get(i);
		}
		Arrays.sort(modes);
		
		return modes;
    }
	/*
	public static void main(String[] args) {
		int[] test = {65, 70, 88, 70 };
		ClassScores c = new ClassScores();
		c.findMode(test);
		return;
	}*/
}
