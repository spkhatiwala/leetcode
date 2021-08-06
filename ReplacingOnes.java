

public class ReplacingOnes {
    public static int longestOnes(int[] A, int K) {
        int windowStart = 0;
        int windowEnd = 0;
        int maxOnes = 0;
        int maxLength = 0;
        while(windowEnd < A.length){
            if(A[windowEnd] == 1)
                maxOnes ++;

            while(windowEnd - windowStart +1 - maxOnes> K){
                if(A[windowStart] == 1)
                    maxOnes -- ;
                windowStart ++ ;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            windowEnd ++ ;
        }
        return maxLength;
    }



        public static void main(String[] args) {
            System.out.println(ReplacingOnes.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
            System.out.println(ReplacingOnes.longestOnes(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
            System.out.println(ReplacingOnes.longestOnes(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
