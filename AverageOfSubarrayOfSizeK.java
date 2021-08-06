import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length-K + 1] ;
        int windowStart = 0;
        int windowEnd = 0;
        double windowSum = 0;
        while(windowEnd < arr.length){
           windowSum += arr[windowEnd] ;
           if(!(windowEnd-windowStart < K )){
               windowSum -= arr[windowStart];
               windowStart++;
           }
           result[windowStart] = windowSum/5;
           windowEnd++;
        }
        return result;
    }
    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K:" + Arrays.toString(result));
    }
}
