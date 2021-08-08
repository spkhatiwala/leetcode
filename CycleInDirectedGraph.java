import java.util.LinkedList;

public class CycleInDirectedGraph {


    //https://trykv.medium.com/algorithms-on-graphs-directed-graphs-and-cycle-detection-3982dfbd11f5
    //https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    //https://algorithms.tutorialhorizon.com/graph-detect-cycle-in-a-directed-graph/



    static class Graph {
        int V;
        LinkedList<Integer>[] adjNodeList;

        Graph(int V){
            this.V = V;
            adjNodeList = new LinkedList[V];
            for(int i=0; i<V; i++){
                adjNodeList[i] = new LinkedList<>();
            }
        }
        void addEdge(int source, int dest) {
            adjNodeList[source].add(dest);
        }

        boolean isCyclic(){
            boolean [] currentlyExplored = new boolean[this.V];
            boolean [] visited = new boolean[this.V];

            for(int i=0; i<V; i++ ) {
                //if already visited it means we have checked it and
                //there is no cycle in it
                if(!visited[i] && recurIsCyclic(i, currentlyExplored, visited))
                    return true;
            }
            return false;
        }

        boolean recurIsCyclic(int vertex, boolean[] currentlyExplored, boolean[] visited){
            //if you hit currentlyExplored node
            //it means you have cycle
            if(currentlyExplored[vertex] )
                return true;
            visited[vertex] = true;
            currentlyExplored[vertex] = true;
            LinkedList<Integer> adjacencyList = adjNodeList[vertex];
            for(Integer adjNode: adjacencyList){
                if( recurIsCyclic(adjNode, currentlyExplored, visited))
                    return true;
            }
            currentlyExplored[vertex] = false;
            return false;
        }
    }
    public static void main(String[] args)
    {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
