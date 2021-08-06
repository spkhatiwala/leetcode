import java.util.*;
import java.util.stream.Collectors;


public class HelloWorld {
    public static List<String> processLogs(List<String> logs, int threshold) {
        Map<Integer, Integer> map = new HashMap<>();
        for(String line:logs){
            String[] sArr = line.split("\\s+");
            Integer sender = Integer.parseInt(sArr[0]);
            Integer receiver = Integer.parseInt(sArr[1]);
            if(sender == receiver){
                map.put(sender, map.getOrDefault(sender, 0) + 1);
            }else{
                map.put(sender, map.getOrDefault(sender, 0) + 1);
                map.put(receiver, map.getOrDefault(sender, 0) + 1);
            }
        }

        Map<Integer, Integer> filteredMap = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>= threshold){
                filteredMap.put(entry.getKey(), entry.getValue());
            }
        }
        map=null;
        List<Integer> list = new ArrayList<>(filteredMap.keySet());
        Collections.sort(list);
        return list.stream().map(Object::toString)
                .collect(Collectors.toList());

    }





    public static void main(String[] args) {
      List<String> list = Arrays.asList("1 2 50",
                                        "1 7 70",
                                        "1 3 20",
                                        "2 2 17");

      List<String> lst = processLogs(list, 2);
        System.out.println(lst);
    }
}
