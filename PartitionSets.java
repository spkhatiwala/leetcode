class PartitionSets {

    public int canPartition(int[] num) {
        int sum = 0;
        for(int i: num){
            sum += i;
        }
        //System.out.println(sum);
        return recur(num, 0, sum, 0);
    }

    public int recur(int[] num, int currSum, int totalSum, int idx ) {
        if(idx== num.length){
            return totalSum - currSum;
        }
        int left = Integer.MAX_VALUE;
        if(currSum + num[idx]< totalSum)
            left = recur(num, currSum+num[idx], totalSum, idx+1);
        int right = recur(num, currSum, totalSum, idx+1);
        return Math.min(left, right);
    }
  /*  public int canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        Integer[][][] dp = new Integer[num.length][sum + 1][sum + 1];
        return this.canPartitionRecursive(dp, num, 0, 0, 0);
    }

    private int canPartitionRecursive(Integer[][][] dp, int[] num, int currentIndex, int sum1, int sum2) {
        // base check
        if(currentIndex == num.length)
            return Math.abs(sum1 - sum2);

        // check if we have not already processed similar problem
        if(dp[currentIndex][sum1][sum2] == null) {
            // recursive call after including the number at the currentIndex in the first set
            int diff1 = canPartitionRecursive(dp, num, currentIndex + 1, sum1 + num[currentIndex], sum2);

            // recursive call after including the number at the currentIndex in the second set
            int diff2 = canPartitionRecursive(dp, num, currentIndex + 1, sum1, sum2 + num[currentIndex]);

            dp[currentIndex][sum1][sum2] = Math.min(diff1, diff2);
        }

        return dp[currentIndex][sum1][sum2];
    }*/

    public static void main(String[] args) {
        PartitionSets ps = new PartitionSets();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}