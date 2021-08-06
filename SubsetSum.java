public class SubsetSum {

    /*public boolean canPartition(int[] num, int sum) {
        Boolean [][] dp = new Boolean[num.length][sum + 1];
        return recur(num, sum, 0 , dp);
    }

    public boolean recur(int[] num, int sum, int currIdx , Boolean [] []  dp) {
        if(num.length == 0 || currIdx >= num.length)
            return false;
        if(sum == 0)
            return true;

        if(dp[currIdx][sum] != null) {
            return dp[currIdx][sum];
        }
        boolean can = false;
        if(num[currIdx] <= sum)
            can = recur(num, sum - num[currIdx], currIdx + 1, dp);
        if( ! can )
            can = recur(num, sum , currIdx + 1, dp);
        dp[currIdx][sum] = can;
        return can;
    }*/
   /* static boolean canPartition(int[] num, int sum) {
        return recur(num, sum, 0);
    }

    static boolean recur(int[] num, int sum, int idx) {
        if(idx >=num.length || num.length==0)
            return false;
        if(sum==0)
            return true;

        if(sum>= num[idx] && recur(num, idx+1, sum-num[idx]))
            return true;
        return recur(num, idx+1, sum);
    }
*/
    static int totalSum;
    static int countSubsets(int[] num, int sum) {
        recur(num, sum, 0 , 0);
        return totalSum;
    }
    static void recur(int[] num, int sum, int idx, int currSum){
        if(currSum == sum){
            totalSum ++;
            return ;
        }
        if(idx == num.length){
            return ;
        }


        if(num[idx] + currSum <= sum)
            recur(num, sum, idx+1, currSum + num[idx]);

        recur(num, sum, idx+1, currSum );

    }
    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = {1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}
