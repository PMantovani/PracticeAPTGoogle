import java.util.ArrayList;

public class Internet {
  boolean[][] adjMatrix;
  public int articulationPoints(String[] routers) { 
    adjMatrix = new boolean[routers.length][routers.length];
    for (int i=0; i<routers.length; i++) {
      for (int j=0; j<routers.length; j++) {
        if (j!=i) {
          adjMatrix[i][j] = false;
        } else {
          adjMatrix[i][j] = true;
        }
      }
    }

    // Add everyone to adjacency matrix
    for (int i=0; i<routers.length; i++) {
      String[] adj = routers[i].split("\\s+");
      for (int j=0; j<adj.length; j++) {
        adjMatrix[i][Integer.parseInt(adj[j])] = true;
      }
    }
    
    int articulationPoints = 0;
    for (int i=0; i<routers.length; i++) {
      boolean[] tempCol = new boolean[routers.length];
      boolean[] tempRow = new boolean[routers.length];
      if (i==4)
    	  System.out.println("Nois");
      for (int j=0; j<routers.length; j++) {
        tempRow[j] = adjMatrix[i][j];
        tempCol[j] = adjMatrix[j][i];
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;        
      }

      ArrayList<Integer>conn=connection(new ArrayList<Integer>(), i);
      if (conn.size() < routers.length-1) {
        articulationPoints++;
      }

      for (int j=0; j<routers.length; j++) {
        adjMatrix[i][j] = tempRow[j];
        adjMatrix[j][i] = tempCol[j];
      }
    }
    return articulationPoints;
  }

  public ArrayList<Integer> connection(ArrayList<Integer> conn, int index) {
    for (int i=0; i<adjMatrix[0].length; i++) {
      if (adjMatrix[index][i] && !conn.contains(i)) {
        conn.add(i);
        conn.addAll(connection(conn, i));
      }
    }
    return conn;
  }
  
  public static void main(String[] args) {
	  Internet i = new Internet();
	  System.out.println(i.articulationPoints( new String[]
			  {"2","2 3","0 1 3 4","1 2","2 5 6","4 6","4 5"}));
	  
  }
}
