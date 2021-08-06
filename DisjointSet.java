import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private Map<Integer, Integer> parent = new HashMap();

    
    // Disjoint–Set data structure (Union–Find algorithm)
    public static void main(String[] args)
    {
        // universe of items
        int[] universe = { 1, 2, 3, 4, 5 };

        // initialize `DisjointSet` class
        DisjointSet ds = new DisjointSet();

        // create a singleton set for each element of the universe
        ds.makeSet(universe);
        printSets(universe, ds);

        ds.Union(4, 3);        // 4 and 3 are in the same set
        printSets(universe, ds);

        ds.Union(2, 1);        // 1 and 2 are in the same set
        printSets(universe, ds);

        ds.Union(1, 3);        // 1, 2, 3, 4 are in the same set
        printSets(universe, ds);
    }
    public int Find(int k){
        if(parent.get(k) == k){
            return k;
        }
        return Find(parent.get(k));
    }

    private static void printSets(int[] universe, DisjointSet ds) {
        System.out.println("--------");
        for(int i: universe)
            System.out.println(i + " parent: " + ds.Find(i));
    }

    private void Union(int i, int i1) {
        int a = Find(i);
        int b = Find(i1);
        parent.put(a,b);
    }

    private void makeSet(int[] universe) {
        for (int i: universe) {
            parent.put(i, i);
        }
    }
}
