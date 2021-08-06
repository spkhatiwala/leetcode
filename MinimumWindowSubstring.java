import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String findSubstring(String s, String t) {
        String minSubstring ="" ;
        int windowEnd = 0;
        int windowStart = 0;
        int matched = 0 ;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0 ) + 1);
        }
        while(windowEnd < s.length()){
            char right = s.charAt(windowEnd);
            if(map.containsKey(right)){
                map.put(right, map.get(right) - 1);
                if(map.get(right) ==  0){
                    matched ++;
                }
            }

            while(matched >= map.size()){

                char left = s.charAt(windowStart);
                String substr = s.substring(windowStart, windowEnd+1);
                if("".equals(minSubstring)|| minSubstring.length() > substr.length()){
                    minSubstring = substr;
                }
                if(map.containsKey(left)){
                    map.put(left, map.get(left) + 1);
                    if(map.get(left) ==1)
                        matched --;
                }
                windowStart++;
            }
            windowEnd ++;
        }
        return minSubstring;
    }

    public static void main(String[] args) {

        System.out.println(MinimumWindowSubstring.findSubstring("cabwefgewcwaefgcf", "cae"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}
