import java.util.*;

public class Graph {
    private int V;
    Map<Integer, List<Integer>> map = new HashMap<>();
    public Graph(int vertices){
        this.V = vertices;
    }

    public void addEdge(int from , int to){
        List<Integer> list = map.getOrDefault(from, new LinkedList<>());
        list.add(to);
        map.put(from, list);
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
                for(Integer child: map.get(item)){
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
        List<Integer> list = map.get(vertex);
        for(int i: list){
            if(! visited[i])
                DFSUtil(i, visited);
        }
    }


    public static void main(String args[])
    {
        Random random = new Random();

        System.out.println(random.nextInt(5));

        Graph g = new Graph(4);

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
