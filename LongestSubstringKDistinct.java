
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = -1;
        int windowStart = 0;
        int windowEnd = 0;
        int keysSize = 0;

        while(windowEnd< str.length()){
            map.put(str.charAt(windowEnd), map.getOrDefault(str.charAt(windowEnd),0) + 1);

            while(map.keySet().size() > k){
                map.put(str.charAt(windowStart), map.get(str.charAt(windowStart))-1);
                if(map.get(str.charAt(windowStart)) == 0){
                    map.remove(str.charAt(windowStart));
                }
                windowStart ++;
            }
            maxLen = Math.max(maxLen, (windowEnd - windowStart + 1));
            windowEnd ++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
