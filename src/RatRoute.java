public class RatRoute {
  int[] cheese = new int[2];
  String[] maze;

  public int numRoutes(String[] enc) {
    int[] rat = new int[2];
    maze = enc;

    for (int i=0; i<enc.length; i++)
      for (int j=0; j<enc[0].length(); j++) {
        if(enc[i].charAt(j) == 'R') {
          rat[0] = i; rat[1] = j;
        }
        else if(enc[i].charAt(j) == 'C') {
          cheese[0] = i; cheese[1] = j;
        }
      }
    return numPaths(rat);
  }
  
  public int numPaths(int[] rat) {
    int count = 0;
    
    if (rat[0] < 0 || rat[0] > (maze.length-1)) return 0;
    if (rat[1] < 0 || rat[1] > (maze[0].length())) return 0;
    if (maze[rat[0]].charAt(rat[1]) == 'X') return 0;
    
    if (rat[0]>cheese[0]) {
      count += numPaths(new int[] {rat[0]-1, rat[1]});
    }
    else if (rat[0]<cheese[0]) {
      count += numPaths(new int[] {rat[0]+1, rat[1]});
    }
    if (rat[1]>cheese[1]) {
      count += numPaths(new int[] {rat[0], rat[1]-1});
    }
    else if (rat[1]<cheese[1]) {
      count += numPaths(new int[] {rat[0], rat[1]+1});
    }
    if (rat[0] == cheese[0] && rat[1] == cheese[1]) {
      return 1; //base case
    }
    return count;
  }
}

