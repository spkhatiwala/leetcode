package amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Temp {
    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {
        int sum = 0;
        if(dollars <=0)
            return sum;
        Collections.sort(priceOfJeans);
        Collections.sort(priceOfShoes);
        Collections.sort(priceOfSkirts);
        Collections.sort(priceOfTops);
        long t1 = System.currentTimeMillis();
        for(Integer pJeans: priceOfJeans){
            int remainingDollars = dollars;
            if(pJeans> remainingDollars)
                break;

            for(Integer pShoes: priceOfShoes){
                int remainingDollars2 = remainingDollars - pJeans;
                if(pShoes> remainingDollars)
                    break;
                for(Integer pSkirts: priceOfSkirts){
                    int remainingDollars3 = remainingDollars2 - pShoes;
                    if(pSkirts> remainingDollars3)
                        break;
                    for(Integer pTops: priceOfTops){
                        int remainingDollars4 = remainingDollars3 - pSkirts;
                        if(pTops> remainingDollars4)
                            break;
                        sum++;
                    }
                }
            }
        }
        System.out.println(System.currentTimeMillis() - t1);
        return sum;
    }

    public static void main(String[] args) {
        long z = getNumberOfOptions(Arrays.asList(2,3),Arrays.asList(4),Arrays.asList(2),Arrays.asList(1,2,3),10);
        System.out.println(z);
    }
}
