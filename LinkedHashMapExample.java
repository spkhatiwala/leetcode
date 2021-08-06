import java.util.LinkedHashMap;

public class LinkedHashMapExample {


    public static void main(String[] args) {

        LinkedHashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();

        hm.put(101,"Vijay");
        hm.put(100,"Amit");
        hm.put(102,"Rahul");

        hm.keySet().stream().forEach(System.out::println);


    }
}
