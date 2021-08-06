import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        PriorityQueue<Integer> minQ = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));


        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd < nums.length){
            if(maxQ.isEmpty() || nums[windowEnd] <= maxQ.peek()) {
                maxQ.add(nums[windowEnd]);
            }else{
                minQ.add(nums[windowEnd]);
            }
            if(maxQ.size()> minQ.size() +1){
                minQ.add(maxQ.poll());
            }else if(minQ.size()>maxQ.size()){
                maxQ.add(minQ.poll());
            }

            if(windowEnd - windowStart +1 == k){
                if(minQ.size() == maxQ.size()){
                    result[windowStart] = (minQ.peek()/2.0 + maxQ.peek()/2.0);
                }else{
                    result[windowStart] = maxQ.peek();
                }
                if(maxQ.peek() >= nums[windowStart]){
                    maxQ.remove(nums[windowStart]);
                }else{
                    minQ.remove(nums[windowStart]);
                }
                windowStart ++;
            }
            if(maxQ.size()> minQ.size() +1){
                minQ.add(maxQ.poll());
            }else if(minQ.size()> maxQ.size()){
                maxQ.add(minQ.poll());
            }
            windowEnd ++;
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
