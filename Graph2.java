import java.util.*;

public class Graph2 {
    private int V;
    LinkedList<Integer>[] adjacencyLists;
    public Graph2(int vertices){
        this.V = vertices;
        adjacencyLists = new LinkedList[vertices];
        for(int i=0; i< vertices; i++) {
            adjacencyLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from , int to){
        adjacencyLists[from].add(to);
    }

    public void BFS(int vertex){
        boolean [] visited = new boolean[this.V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int item = queue.poll();
                System.out.println(" Item: " + item);
                for(Integer child: adjacencyLists[item]){
                    if(!visited[child]) {
                        queue.add(child);
                        visited[child] = true;
                    }
                }
            }
        }
    }

    public void DFS(int vertex){
        boolean [] visited = new boolean[this.V];
        DFSUtil(vertex, visited);
    }

    public void DFSUtil(int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.println(vertex);
        List<Integer> adjacencyList = adjacencyLists[vertex];
        for(int i: adjacencyList){
            if(! visited[i])
                DFSUtil(i, visited);
        }
    }


    public static void main(String args[])
    {
        Random random = new Random();

        System.out.println(random.nextInt(5));

        Graph2 g = new Graph2(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        //g.BFS(2);
        g.DFS(2);
    }
}
