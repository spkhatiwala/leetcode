public class FloydWarshall {

    //Finds shortest path for all vertices.
    //works with -ve weights also
    //go through each vertex of the graph.
    //and recalculate the whole graph by passing through that
    //vertex.....


    final static int INF = Integer.MAX_VALUE, V = 4;

    void floydWarshall(int graph[][]){
        int dist[][] = new int[graph.length][graph[0].length];

        //just copy the matrix... Not really needed.
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[0].length; j++){
                dist[i][j] = graph[i][j];
            }
        }




        for(int v=0; v<V; v++){
            for(int row=0; row<V; row++){
                for(int col=0; col<V; col++){
                    if(dist[row][v]!=INF && dist[v][col]!=INF)
                        dist[row][col] = Math.min(dist[row][col], dist[row][v] + dist[v][col]);
                }
            }
        }
        printSolution(dist);
    }


    void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }


    // Driver program to test above function
    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = {   {0,   5,  INF, 10},
                            {INF, 0,   3, INF},
                            {INF, INF, 0,   1},
                            {INF, INF, INF, 0}
        };
        FloydWarshall a = new FloydWarshall();

        // Print the solution
        a.floydWarshall(graph);
    }
}
