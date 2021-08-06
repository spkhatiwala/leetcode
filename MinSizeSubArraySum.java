public class MinSizeSubArraySum {
    public static long findMinSubArray(int S, int[] arr) {
        int windowStart = 0;
        int windowEnd = 0;
        int runningSum =0;
        int minSize = Integer.MAX_VALUE;
        while(windowEnd < arr.length){
            runningSum += arr[windowEnd] ;
            while(runningSum >= S){
                minSize = Math.min(minSize, windowEnd-windowStart+1);
                runningSum -= arr[windowStart];
                windowStart ++;
            }
            windowEnd ++;
        }
        return minSize;
    }

    public static void main(String[] args) {
        long result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
