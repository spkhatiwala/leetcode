import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {

    public static Map<String, Integer> getMap(String[] words){
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            map.put(words[i], map.getOrDefault(words[i],0) +1);
        }
        return map;
    }

    public static List<Integer> findWordConcatenation(String s, String[] words) {
        List<Integer> list = new ArrayList<>();


        int wordLen = words[0].length();
        int windowLen = wordLen * words.length;
        for(int count=0; count< wordLen; count++ ){
            int windowEnd = count;
            int windowStart = count;
            Map<String, Integer> map = getMap(words);
            int matched = 0;

            if(count == 3)
                System.out.println("hello");
            while(windowEnd + wordLen -1 < s.length() ){
                String right = s.substring(windowEnd , windowEnd + wordLen );
                if(map.containsKey(right)){
                    map.put(right, map.get(right) -1 );
                    if(map.get(right) == 0)
                        matched ++;
                }

                if(windowEnd + wordLen - count  >=  windowLen){
                    if(matched == map.size())
                        list.add(windowStart);
                    String left = s.substring(windowStart, windowStart + wordLen );
                    if(map.containsKey(left)){
                        map.put(left, map.get(left) + 1);
                        if(map.get(left) == 1)
                            matched--;
                    }
                    windowStart += wordLen;
                }

                windowEnd += wordLen;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("dddddddddddd", new String[] { "dddd","dddd"});
        System.out.println(result);
    }
}
