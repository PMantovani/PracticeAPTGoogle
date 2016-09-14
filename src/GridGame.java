public class GridGame {
  public int winningMoves(String[] grid) {
    char[][] gridChar = new char[grid.length][grid[0].length()];
    for (int y=0; y<grid.length; y++) {
    	for (int x=0; x<grid[0].length(); x++) {
    		gridChar[y][x] = grid[y].charAt(x);
    	}
    }
    
    return totalWins(gridChar);
  }
  
  public int totalWins(char[][] grid) {
	  int countWins = 0;
	    for (int y=0; y<grid.length; y++) {
	      for (int x=0; x<grid[y].length; x++) {
	        if (isLegalMove(grid, x, y)) {
	          grid[y][x] = 'X';
	          int opponentWon = totalWins(grid);
	          if (opponentWon == 0) {
	            countWins++;
	          }
	          grid[y][x] = '.';
	        }
	      }
	    }
	    return countWins;
  }

  public boolean isLegalMove(char[][] grid, int x, int y) {
    boolean isLegal = true;
    if (grid[y][x] != '.') {
      isLegal = false;
    }
    if (y-1 >= 0) {
      if (grid[y-1][x] != '.') {
        isLegal = false;
      }
    }
    if (x-1 >= 0) {
      if (grid[y][x-1] != '.') {
        isLegal = false;
      }
    }
    if (y+1 <= grid.length-1) {
      if (grid[y+1][x] != '.') {
        isLegal = false;
      }
    }
    if (x+1 <= grid[y].length-1) {
      if (grid[y][x+1] != '.') {
        isLegal = false;
      }
    }
    return isLegal;
  }
}


/*

....
....
.... y = 2
.... y = 3 length = 4

*/
