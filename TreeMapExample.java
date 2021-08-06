import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapExample {



    public static void main(String[] args) {
        NavigableMap<Integer,String > map = new TreeMap<>();
        map.put(100,"Amit");
        map.put(102,"Ravi");
        map.put(101,"Vijay");
        map.put(103,"Rahul");

        var x = map.tailMap(101);
        for(Integer key: x.keySet()){
            System.out.println("KEY: " + key + " value: " + x.get(key));
        }
        System.out.println("subMap: "+map.subMap(100, false, 102, true));
    }
}
