public class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] integers = new Integer[profits.length+1][capacity+1];
        return recur(profits,0, weights, capacity, integers);
    }

    public int solveKnapsackDP(int[] profits, int[] weights, int capacity) {
        int[][] integers = new int[profits.length][capacity+1];
        for(int i=0; i< profits.length; i++){
            integers[i][0]=0;
        }
        for(int i=0; i< profits.length; i++){
            for(int j=1; j<= capacity; j++){
                int profit1=0, profit2=0;
                if (i>0)
                    profit1 = integers[i-1][j];
                if(weights[i]<= j)
                    profit2 = profits[i] + integers[i][j - weights[i]];
                integers[i][j] = Math.max(profit1, profit2);
            }
        }
        return integers[profits.length-1][capacity];
    }



    public int recur(int[] profits, int idx, int[] weights, int capacity , Integer[][] arr) {
        if(idx >= profits.length || capacity==0)
            return 0;
        if(arr[idx][capacity] ==null){
            int x1 = 0;
            if(capacity >= weights[idx])
                x1 = profits[idx] + recur(profits,idx +1, weights, capacity-weights[idx], arr);
            int x2 = recur(profits,idx +1, weights, capacity, arr);
                arr[idx][capacity] = Math.max(x1,x2);
        }
        return arr[idx][capacity];

    }
    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
        maxProfit = ks.solveKnapsackDP(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
