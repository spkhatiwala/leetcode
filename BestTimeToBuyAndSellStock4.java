import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock4 {
    private Map<String, Integer> cache = new HashMap<>();

    public int maxProfit(int k, int[] prices) {

        return recur(prices, 0, 0, 0,  k);
    }

    public int recur( int[] prices, int i , int txn,  int zeroOne,  int k){
        if(txn>=k)
            return 0;
        if(i>= prices.length)
            return 0;

        String key = i + "|" + txn + "|" + zeroOne;
        if(cache.containsKey(key))
            return cache.get(key);
        if(zeroOne == 0){
            int hold = recur(prices, i+1 ,txn, 0 ,k);
            int buy = -prices[i] + recur(prices, i+1, txn, 1, k);
            cache.put(key, Math.max(buy,hold));
        }else{
            int hold = recur(prices, i+1, txn,1,  k);
            int sell = prices[i] + recur(prices, i+1, txn+1, 0, k);
            cache.put(key, Math.max(hold, sell));
        }

        return cache.get(key);
    }



    public static void main(String[] args) {

    }
}
