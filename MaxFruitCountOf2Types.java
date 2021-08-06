import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int windowStart = 0;
        int windowEnd = 0;
        int maxNum = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(windowEnd < arr.length){
            map.put(arr[windowEnd], map.getOrDefault(arr[windowEnd], 0 ) + 1 );
            while(map.size() > 2){
                map.put(arr[windowStart], map.get(arr[windowStart]) - 1);
                if(map.get(arr[windowStart]) == 0 ){
                    map.remove(arr[windowStart]);
                }
                windowStart ++ ;
            }
            maxNum = Math.max(maxNum, map.values().stream().mapToInt(Integer::intValue).sum());
            windowEnd ++;
        }
        return maxNum;
    }


    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
