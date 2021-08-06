public class KnapsackBounded {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer [] [] cache = new Integer[capacity+1][weights.length];
        return recur(profits, weights, capacity, 0,cache);
    }

    public int recur(int[] profits, int[] weights, int capacity, int idx,Integer [] [] cache ){
        if(capacity==0)
            return 0;
        if(idx >= weights.length)
            return 0;
        int with = 0;
        int without ;

        if(cache[capacity][idx] != null)
            return cache[capacity][idx];

        if(weights[idx] <= capacity)
            with = profits[idx] + recur(profits, weights, capacity - weights[idx] , idx + 1, cache);

        without =  recur(profits, weights, capacity  , idx + 1,  cache);
        int max = Math.max(with, without);
        cache[capacity][idx] = max;
        return max;
    }


    public static void main(String[] args) {
        KnapsackBounded ks = new KnapsackBounded();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

}
