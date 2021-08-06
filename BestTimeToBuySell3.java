public class BestTimeToBuySell3 {
    public static int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE,
        t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0,
        t2Profit = 0;

        for (int price : prices) {
            // the maximum profit if only one transaction is allowed
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            // reinvest the gained profit in the second transaction
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }

    public static void main(String[] args) {
        int [] arr = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
        int [] arr2 = {1,2,3,4,5};
        System.out.println(maxProfit(arr2));
        int [] arr3 = {7,6,4,3,1};
        System.out.println(maxProfit(arr3));
    }
}
