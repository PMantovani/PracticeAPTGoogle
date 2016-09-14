public class Robot {
    long[][] grid;
    int SIZE;
    
    public long movesToBottom(int N) {
        grid = new long[N][N];
        SIZE = N;
        return movesFromPos(0,0);
    }
    
    public long movesFromPos(int x, int y) {
        if (x == SIZE-1 || y == SIZE-1) {
        	grid[x][y] = 1;
            return 1;
        }
        if (grid[x][y] != 0) {
            return grid[x][y];
        }
        long moves = movesFromPos(x+1,y) + movesFromPos(x,y+1);
        grid[x][y] = moves;
        return moves;
    }
    
    public static void main(String[] args) {
    	Robot r = new Robot();
    	System.out.println(r.movesToBottom(2));
    	System.out.println(r.movesToBottom(3));
    	System.out.println(r.movesToBottom(4));
    	System.out.println(r.movesToBottom(5));
    	System.out.println(r.movesToBottom(6));
    	System.out.println(r.movesToBottom(7));
    	
    }
}
