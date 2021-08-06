

import java.lang.reflect.Array;
import java.util.*;
public class Utilities {

    // JAVA comparator
    //== 0  means they are equal.
    //>0
    //-ve first < second
    //+ve first > second

    static class Node{
        String id;
        int value = 0;

        public Node(String idStr, int val){
            id = idStr;
            value = val;
        }

        @Override
        public String toString() {
            return "Node ID: " + id + " value: " + value;
        }

    }


    static SortedMap<String, Node> sortMapByKey(Map<String, Node> map){
        Comparator<String> keyComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
                /*if(o1.value==o2.value)
                    return 0;
                else if(o1.value > o2.value)
                    return 1;
                else
                    return -1;*/
            }
        };


        SortedMap<String, Node> sortedMap = new TreeMap(keyComparator);
        sortedMap.putAll(map);
        return sortedMap;
    }

    //Ascending Sort
    static int compareValues(Node node1, Node node2){
        if(node1.value==node2.value)
            return 0;
        else if(node1.value > node2.value)
            return 1;
        else
            return -1;
    }

    static List<Node> setToList(Set<Node> nodeSet){
        return new ArrayList<>(nodeSet);
    }

    static  LinkedHashMap<String,Node> sortMapByValue(Map<String,Node> unSortedMap){
        List<Map.Entry<String,Node>> entryList = new ArrayList<>(unSortedMap.entrySet());
        Collections.sort( entryList, (entry1, entry2) -> compareValues(entry1.getValue(), entry2.getValue()));
        LinkedHashMap<String, Node> result = new LinkedHashMap<>();
        for(Map.Entry<String, Node> entry: entryList){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    //create Reference
    class Ref<T>
    {
        public T Value;

        public Ref(T value)
        {
            Value = value;
        }
    }

    static class ValueComparator implements Comparator<String>{
        Map<String, Node> map;

        ValueComparator(Map<String,Node> map){
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            if(map.get(o1).value >= map.get(o2).value) {
                return 1;
            }else{
                return -1;
            }// returning 0 would merge keys so no return 0

        }
    }

    static  SortedMap<String,Node> sortMapByValue2(Map<String,Node> unSortedMap){
        SortedMap<String, Node> sortedMap = new TreeMap<>(new ValueComparator(unSortedMap));
        sortedMap.putAll(unSortedMap);
        return sortedMap;
    }





    public static <T> List<T> fromArrayToList(T[] a, Class clazz) {
        return Arrays.asList(a);
        //return Arrays.stream(a).collect(Collectors.toList());
    }



    public static<T> T[] listToArray(List<T> arrList, Class<T> type){
        if ((arrList == null) || (arrList.size() == 0)) return null;
        Object arr = Array.newInstance(type, arrList.size());
        for (int i=0; i < arrList.size(); i++)
            Array.set(arr, i, arrList.get(i));
        return (T[])arr;
    }


    public static void main(String[] args) {
        Node node1 = new Node("A", 10);
        Node node2 = new Node("B", 9);
        Node node3 = new Node("C", 60);
        Node node4 = new Node("D", 7);
        Node node5 = new Node("E", 3);
        Node node6 = new Node("F", 80);
        Node node7 = new Node("G", 1);

        Map<String, Node> map = new HashMap();
        map.put(node7.id, node7);
        map.put(node2.id, node2);
        map.put(node4.id, node4);
        map.put(node5.id, node5);
        map.put(node3.id, node3);
        map.put(node6.id, node6);
        map.put(node1.id, node1);

        List<Node> list = new ArrayList<>(10);
        list.add(node1);
        list.add(node2);

        Node[] arr = listToArray(list, Node.class);
        for(Node node: arr){
            System.out.println("xxxx: " + node);
        }



        //sortMapByKey(map).values().forEach(System.out::println);
        sortMapByValue2(map).values().forEach(System.out::println);
    }

}
