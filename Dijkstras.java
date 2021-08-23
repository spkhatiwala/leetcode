import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dijkstras {
    //Dijkstras algorithm works with relaxation.
    //update path
    //RELAXATION
    //if(dist[u] + cost[u,v] < dist[v])
    //          dist[v] = dist[u] + cost[u,v]
    //first set the dist of directly connected nodes.
    //not connected nodes dist is infinity
    //The algorithm is
    //1] pick the min dist node from not visited nodes.
    //2] perform relaxation of all the connected nodes of minDistNode


    Graph graph;
    static class Graph
    {
        private int numVertices;   // No. of vertices
        private Map<Integer, List<NodeWeightPair>> map = new HashMap<>();

        Graph(int v) {
            numVertices = v;
        }

        void addEdge(int from , int to , int weight){
            List<NodeWeightPair> list = map.getOrDefault(from, new LinkedList<NodeWeightPair>());
            list.add(new NodeWeightPair(to, weight));
            map.put(from, list);
        }

    }
    static class NodeWeightPair {
        int nodeId;
        int weight;
        NodeWeightPair(int  v, int  w){
            nodeId = v;
            weight = w;
        }
    }

    static class ParentDistPair {
        int parentId;
        int dist;
        ParentDistPair(int  v, int  w){
            parentId = v;
            dist = w;
        }
    }


    int minDistanceNode(Map<Integer, ParentDistPair> distMap, boolean[] visited ){
        int minDist = Integer.MAX_VALUE;
        int minNode = -1;
        for( Map.Entry<Integer, ParentDistPair> entry: distMap.entrySet()){
            int node = entry.getKey();
            ParentDistPair parentDistPair = entry.getValue();
            if(!visited[node] ){
                if(parentDistPair.dist != Integer.MAX_VALUE && parentDistPair.dist< minDist)
                    minNode = node;
            }
        }
        return minNode;
    }

    void dijkstras(Graph g, int src){
        this.graph = g;
        Map<Integer, ParentDistPair> distMap = new HashMap<>(g.numVertices); //parent, weight
        boolean[] visited = new boolean[g.numVertices];
        for(int nodeId : g.map.keySet()){
            distMap.put(nodeId, new ParentDistPair(-1, Integer.MAX_VALUE));
            visited[nodeId] = false;
        }
        distMap.put(src, new ParentDistPair(-1, 0));

        for(int i=0; i<g.numVertices; i++){
            int minNode = minDistanceNode(distMap, visited);
            visited[minNode] = true;
            List<NodeWeightPair> adjacencyList = g.map.get(minNode);

            //Relaxation
            for(NodeWeightPair nodeWeightPair : adjacencyList){
                int adjacentNodeId = nodeWeightPair.nodeId;
                int weight = nodeWeightPair.weight;
                if(!visited[adjacentNodeId] && distMap.get(minNode).dist != Integer.MAX_VALUE){
                    int distThruMinNode = distMap.get(minNode).dist + weight;
                    if(distThruMinNode < distMap.get(adjacentNodeId).dist){
                        distMap.put(adjacentNodeId, new ParentDistPair(minNode, distThruMinNode));
                    }
                }
            }
        }
        printSolution(distMap);
    }
    void printSolution(Map<Integer, ParentDistPair> distMap)
    {
        System.out.println("Vertex \t\t Distance from Source");
        for(Map.Entry<Integer, ParentDistPair> entry: distMap.entrySet()){
            System.out.println("Key: " + entry.getKey() + "  value: " + entry.getValue().dist);
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1,4);
        g.addEdge(1,0,4);
        g.addEdge(0,7,8);
        g.addEdge(7,0,8);
        g.addEdge(1,7,11);
        g.addEdge(7,1,11);
        g.addEdge(1,2,8);
        g.addEdge(2,1,8);
        g.addEdge(7,8,7);
        g.addEdge(8,7,7);
        g.addEdge(6,7,1);
        g.addEdge(7,6,1);
        g.addEdge(2,8,2);
        g.addEdge(8,2,2);
        g.addEdge(8,6,6);
        g.addEdge(6,8,6);
        g.addEdge(2,3,7);
        g.addEdge(3,2,7);
        g.addEdge(5,2,4);
        g.addEdge(2,5,4);
        g.addEdge(6,5,2);
        g.addEdge(5,6,2);
        g.addEdge(5,3,14);
        g.addEdge(3,5,14);
        g.addEdge(3,4,9);
        g.addEdge(4,3,9);
        g.addEdge(4,5,10);
        g.addEdge(5,4,10);

        Dijkstras dijkstras = new Dijkstras();
        dijkstras.dijkstras(g, 0);
    }
}
