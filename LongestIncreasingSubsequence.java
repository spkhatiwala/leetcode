import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {






        public static int lengthofLIS(int[] nums, int previndex, int curIdx, int[][] memo) {
            if (curIdx == nums.length) {
                return 0;
            }
            if (memo[previndex + 1][curIdx] >= 0) {
                return memo[previndex + 1][curIdx];
            }
            int taken = 0;
            if (previndex < 0 || nums[curIdx] > nums[previndex]) {
                taken = 1 + lengthofLIS(nums, curIdx, curIdx + 1, memo);
            }

            int nottaken = lengthofLIS(nums, previndex, curIdx + 1, memo);
            memo[previndex + 1][curIdx] = Math.max(taken, nottaken);
            return memo[previndex + 1][curIdx];
        }

        public static int lenOfLIS(int[] nums) {
            int memo[][] = new int[nums.length + 1][nums.length];
            for (int[] l : memo) {
                Arrays.fill(l, -1);
            }
            return lengthofLIS(nums, -1, 0, memo);
        }

    public static int LIS(int[] arr, int i, int n, int prevMaxIdx,Integer[][] dp)
    {
        if(i==n){
            return 0;
        }
        if(dp[prevMaxIdx +1 ][i] !=null)
            return dp[prevMaxIdx+1 ][i];
        int exclude = LIS(arr, i +1 , n, prevMaxIdx, dp);
        int include = 0;
        if(prevMaxIdx <0 || arr[i] > arr[prevMaxIdx])
            include = 1 + LIS(arr, i+1 , n, i, dp);
        int xx = Math.max(include, exclude);
        dp[prevMaxIdx +1][i] = xx;
        return xx;
    }

    public static int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length + 1 ][nums.length + 1];
        return LIS(nums, 0, nums.length, -1, dp);
    }

    public static void main(String[] args)
    {
        int[] arr = { 3, 2, 6, 4, 5, 1 };
        System.out.print("Length of the longest increasing subsequence is " +
                lenOfLIS(arr));
    }
}
