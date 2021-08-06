import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int findLength(String s, int k) {
        int windowStart = 0 ;
        int windowEnd = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(windowEnd < s.length()){
            map.put(s.charAt(windowEnd), map.getOrDefault(s.charAt(windowEnd) , 0) + 1);

            while(windowEnd - windowStart + 1 - Collections.max(map.values()) > k){
                map.put(s.charAt(windowStart) , map.get(s.charAt(windowStart)) -1);
                windowStart ++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            windowEnd ++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
