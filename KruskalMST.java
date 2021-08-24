import java.util.*;

public class KruskalMST {
    /**
     * Kruskal Algorithm.
     * Find the edge which is the least weight.
     * If the src or dest of edge is not already part of MST add the edge to MST
     * else skip that edge since it will create cycle. Tree doesn't contain cycle.
     * Use DisjointSet to find out if the src or dest is already part of MST.
     */
    static class Edge
    {
        int src, dest, weight;
        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + src + ", " + dest + ", " + weight + ")";
        }
    }

    static class DisjointSet {
        Map<Integer, Integer> parent = new HashMap<>();
        public void makeSet(int N) {
            for (int i = 0; i < N; i++) {
                parent.put(i, i);
            }
        }
        private int Find(int k) {
            if (parent.get(k) == k) {
                return k;
            }
            return Find(parent.get(k));
        }
        private void Union(int a, int b) {
            int x = Find(a);
            int y = Find(b);
            parent.put(x, y);
        }
    }

    static List<Edge> kruskalAlgo(List<Edge> edges, int N){
        List<Edge> mstList = new ArrayList<>();
        Collections.sort(edges, Comparator.comparingInt(a -> a.weight));
        DisjointSet disjointSet = new DisjointSet();
        disjointSet.makeSet(N);
        //we will keep on creating the spanning tree till
        //we have N-1 edges
        int i=0;
        while(mstList.size()!= N-1){
            Edge edge = edges.get(i++);
            int parentSrc = disjointSet.Find(edge.src);
            int parentDest = disjointSet.Find(edge.dest);
            if(parentSrc == parentDest){
                //continue;
                //do nothing
            }else{
                disjointSet.Union(parentSrc, parentDest);
                mstList.add(edge);
            }
        }
        return mstList;
    }
    public static void main(String[] args)
    {
        // `(u, v, w)` triplet represent undirected edge from
        // vertex `u` to vertex `v` having weight `w`
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 7), new Edge(1, 2, 8),
                new Edge(0, 3, 5), new Edge(1, 3, 9),
                new Edge(1, 4, 7), new Edge(2, 4, 5),
                new Edge(3, 4, 15), new Edge(3, 5, 6),
                new Edge(4, 5, 8), new Edge(4, 6, 9),
                new Edge(5, 6, 11)
        );

        // total number of nodes in the graph
        final int N = 7;

        // construct graph
        List<Edge> e = kruskalAlgo(edges, N);
        System.out.println(e);
    }
}
