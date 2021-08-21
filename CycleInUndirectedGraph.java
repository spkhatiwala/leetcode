import java.util.LinkedList;

public class CycleInUndirectedGraph {
    static class Graph{
        int numOfVertices;
        LinkedList<Integer> [] adjacencyLists;

        Graph(int numOfVertices){
            this.numOfVertices = numOfVertices;
            adjacencyLists = new LinkedList[numOfVertices];
            for(int i=0; i<numOfVertices; i++){
                adjacencyLists[i] = new LinkedList<>();
            }
        }

        void addEdge(int from , int to){
            adjacencyLists[from].add(2);
        }

        boolean recursiveIsCyclic(boolean[] visited, int vertex, int parent){
            LinkedList<Integer> adjacencyList = adjacencyLists[vertex];
            visited[vertex] =true;
            for(int adjNode: adjacencyList){
                //for adjacent nodes of vertex 1 of them will be parent
                //we want to skip that node since it is already visited.
                //any other node if visited then it is cycle.
                if(adjNode == parent)
                    continue;
                if(visited[adjNode])
                    return true;
                if(recursiveIsCyclic(visited, adjNode, vertex))
                    return true;
            }
            return false;
        }
        boolean isCyclic(){
            boolean[]  visited = new boolean[numOfVertices];
            for (int i = 0; i < numOfVertices; i++)
                visited[i] = false;
            for(int i=0; i< numOfVertices; i++){
                //you go thru all nodes to take care of disjoint graphs
                if(!visited[i] && recursiveIsCyclic(visited, i, -1 ))
                    return true;
            }
            return false;
        }
    }
    // Driver method to test above methods
    public static void main(String args[])
    {

        // Create a graph given
        // in the above diagram
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph   doesn't contains cycle");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph  contains cycle");
        else
            System.out.println("Graph   doesn't contains cycle");
    }
}
