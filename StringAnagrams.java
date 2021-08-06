import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int matched = 0;

        for(int i=0; i< p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0 )+ 1);
        }
        while(windowEnd < s.length()){
            Character right = s.charAt(windowEnd);
            if(map.containsKey(right)){
                map.put(right, map.get(right) -1);
                if(map.get(right) == 0)
                    matched ++ ;
            }
            if(matched == map.size()){
                list.add(windowStart);
            }
            if(windowEnd >= p.length() -1){
                char left = s.charAt(windowStart);
                if(map.containsKey(left)){
                    map.put(left, map.get(left) + 1);
                    if(map.get(left) == 1){
                        matched --;
                    }
                }
                windowStart ++;
            }


            windowEnd ++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
