import java.util.Arrays;

public class PartitionSet {
    public static boolean canPartition(int[] num) {

        int sum = Arrays.stream(num).sum();
        if(sum%2 !=0)
            return false;
        Boolean[][] arr = new Boolean[num.length][sum/2 + 1];
        return recur(num, 0, sum/2, arr);
    }

    public static boolean recur(int [] num, int currIdx, int capacity, Boolean[][] cache){
        if(currIdx>= num.length || num.length == 0){
            return false;
        }
        if(capacity == 0)
            return true;
        if(cache[currIdx][capacity] != null )
            return cache[currIdx][capacity];


        boolean left = false;
        if(num[currIdx] <= capacity)
            left = recur(num,currIdx+1, capacity- num[currIdx], cache);
        boolean right = recur(num,currIdx+1, capacity, cache);
        cache[currIdx][capacity] =  left||right;
        return cache[currIdx][capacity];
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = { 1, 2, 3, 4 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(ps.canPartition(num));
    }
}
