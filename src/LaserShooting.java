
public class LaserShooting {
	public double numberOfHits(int[] x, int[] y1, int[] y2) {
		double totalProb = 0;
        for (int i=0; i<x.length; i++) {
        	double angle1 = Math.atan2(y1[i],x[i]);
        	double angle2 = Math.atan2(y2[i],x[i]);
        	
        	totalProb += Math.abs(angle1-angle2)/(Math.PI);
        	
        }
		
		return totalProb;
		//[739 ] [-281 ] [971 ]
	}
}
