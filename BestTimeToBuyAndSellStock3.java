public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        return recur(prices, 0 , 0 );
    }


    public int recur(int[] prices, int i, int zeroOne){
        if(zeroOne==0){
            int buy = -prices[i] + recur(prices, i+1, 1);
            int hold = recur(prices, i+1, 0);
            return Math.max(buy, hold);
        }else{
            int sell = prices[i] + recur(prices, i+2, 0);
            int hold = recur(prices, i+1, 1);
            return Math.max(sell,hold);
        }
    }

    public static void main(String[] args) {

    }
}
