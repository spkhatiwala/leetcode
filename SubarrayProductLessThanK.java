import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int windowStart = 0;
        int windowEnd = 0;
        int prod = 1;
        List<Integer> list;
        while(windowEnd < arr.length){
            prod = prod * arr[windowEnd] ;
            while(prod>= target){
                prod /= arr[windowStart];
                windowStart++;
            }
            list = new LinkedList<>();
            for(int j= windowEnd; j>= windowStart; j--){
                List<Integer> tmpList = new LinkedList<>(list);
                tmpList.add(0, arr[j]);
                lists.add(tmpList);
                list = tmpList;
            }
            windowEnd ++;
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
