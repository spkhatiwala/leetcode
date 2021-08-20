import java.util.LinkedList;

public class CycleInUndirectedGraphUnionSet {
    static class Graph{
        int numOfVertices;
        LinkedList<Integer>[] adjacencyLists ;
        int[] parent;
        int[] rank;
        LinkedList<Edge> edges;
        class Edge{
            int from;
            int to;
            Edge(int a, int b){
                from = a;
                to = b;
            }
        }


        Graph(int n){
            numOfVertices = n;
            adjacencyLists = new LinkedList[n];
            edges = new LinkedList<>();
            for(int i=0; i<n; i++){
                adjacencyLists[i] = new LinkedList<>();
            }
            parent = new int[n];
            rank = new int[n];

            for(int i=0; i<n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }

        void addEdge(int from, int to){
            this.adjacencyLists[from].add(to);
            edges.add(new Edge(from, to));
        }

        int find(int elem){
            if(parent[elem]==elem)
                return elem;
            parent[elem] = find(parent[elem]);
            return parent[elem];
        }

        void union( int a, int b){
            int parentA = find(a);
            int parentB = find(b);
            if(parentA == parentB)
                return;
            if(rank[parentA] < rank[parentB]){
                parent[parentA] = parentB;
            }else if(rank[parentB] < rank[parentA]){
                parent[parentB] = parentA;
            }else{
                parent[parentA] = parentB;
                rank[parentB]++;
            }
        }

        boolean isCyclic(){
            for(Edge edge: edges){
                int parentA = find(edge.from);
                int parentB = find(edge.to);
                if(parentA == parentB)
                    return true;
                union(edge.from, edge.to);
            }
            return false;
        }
    }
    public static void main (String[] args)
    {
        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
        int V = 3, E = 3;
        Graph graph = new Graph(V);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,2);


        if (graph.isCyclic()==true)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
