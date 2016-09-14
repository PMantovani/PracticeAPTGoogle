
public class AimToTen {
	public int need(int[] marks) {
		int testsTaken = marks.length;
		double sumMarks = 0;
		
		for (int i=0; i<testsTaken; i++) {
			sumMarks += marks[i];
		}
		double avg = sumMarks/testsTaken;
		int countFurtherTests = 0;
		
		while (avg < 9.5) {
			sumMarks += 10;
			countFurtherTests++;
			avg = sumMarks/(testsTaken + countFurtherTests);
		}
		
		return countFurtherTests;
	}
}
