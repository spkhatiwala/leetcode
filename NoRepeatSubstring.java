import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    public static int findLength(String s) {
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        while(windowEnd < s.length()){
            map.put(s.charAt(windowEnd), map.getOrDefault(s.charAt(windowEnd), 0 ) + 1);
            while(map.values().stream().anyMatch(x -> x>1)){
                map.put(s.charAt(windowStart), map.get(s.charAt(windowStart)) - 1);
                windowStart ++ ;
            }
            maxLength = Math.max(maxLength, map.values().stream().mapToInt(Integer::intValue).sum());
            windowEnd++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength(" "));
        //System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        //System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
