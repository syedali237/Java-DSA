
import java.util.ArrayList;

public class Graphs {

    public static void main(String[] args) {

        // Storing it as a matrix
        int n = 3, m =3;
        int adj[][] = new int[n+1][n+1];
    
        // edge 1--2
        adj[1][2] = 1;
        adj[2][1] = 1;

        // edge 2--3
        adj[2][3] = 1;
        adj[3][2] = 1;

        //edge 1--3
        adj[1][3] = 1;
        adj[3][1] = 1;


        // Storing it in an ArrayList
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();


        // Initialize adjacency list for each vertex
        // n + 1
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // edge 1--2
        adjList.get(1).add(2);
        adjList.get(2).add(1);

        // if directed edge 1 --> 2
        // adjList.get(1).add(2);
        
        // edge 2--3
        adjList.get(2).add(3);
        adjList.get(3).add(2);

        // edge 1--3
        adjList.get(1).add(3);
        adjList.get(3).add(1);

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
