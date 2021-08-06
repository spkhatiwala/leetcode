import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static boolean checkInclusion(String s1, String s2) {
        int windowStart = 0;
        int windowEnd = 0;
        Map<Character, Integer> map = new HashMap<>();
        int matched = 0;
        for(int i = 0; i< s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0 ) + 1);
        }
        while(windowEnd < s2.length()){
            char right = s2.charAt(windowEnd);
            if(map.containsKey(right)){
                map.put(right, map.get(right) - 1) ;
                if(map.get(right) == 0)
                    matched ++;
            }

            if(matched == map.size())
                return true;

            if(windowEnd >= s1.length()-1){
                char left = s2.charAt(windowStart);
                if(map.containsKey(left)){
                    map.put(left, map.get(left) + 1);
                    if(map.get(left) == 1)
                        matched -- ;
                }
                windowStart++;
            }

            windowEnd ++;
        }

        return false;
    }

    public static void main(String[] args) {
        //System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.checkInclusion("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.checkInclusion("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.checkInclusion("aaacb", "abc"));
    }

}
