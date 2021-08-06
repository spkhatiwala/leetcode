import java.util.ArrayList;
import java.util.List;

class Program {

    public static int longestPeak(int[] array) {
        int maxlen=0;

        for(int i=1; i< array.length-1; i++){
            int l1= 0;
            int l2=0;
            boolean rise=false;
            boolean fall=false;
            for(int k=i; k>0; k--){
                if(array[k-1] >=  array[k])
                    break;
                rise=true;
                l1++;
            }
            for(int k=i; k<array.length-1; k++){
                if(array[k+1] >= array[k])
                    break;
                fall=true;
                l2++;
            }
            if(rise && fall)
                maxlen=Math.max(maxlen, l1+l2+1);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        char c = '9';
        long l = 2147483647L;
        if(l> Integer.MAX_VALUE)
            System.out.println("TRUE");


        System.out.println(Character.getNumericValue(c));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int [] arr = new int[]{ 1, 3, 2};
        System.out.println(longestPeak(arr));



    }
}
