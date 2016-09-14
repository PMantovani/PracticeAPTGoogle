
public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, 
            int x1, int y1, int x2, int y2) {
		
		int count = 0;
		// Iterating through the districts
		for (int i=0; i<x.length; i++) {
			boolean isAInside = isInside(x[i], x1, y[i], y1, r[i]);
			boolean isBInside = isInside(x[i], x2, y[i], y2, r[i]);
			
			if ((isAInside&&!isBInside) || (!isAInside&&isBInside))
				count++;
		}		
		return count;
	}
	
	public boolean isInside(int x1, int x2, int y1, int y2, int r) {
		double dist = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		return dist < r;
	}
}
