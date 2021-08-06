class TargetSum {

    public int findTargetSubsets(int[] num, int s) {
        return recur(num, s, 0);
    }

    public int recur(int[] num, int s , int idx){

        if(idx==num.length && s==0){
            return 1;
        }
        if(idx==num.length && s!=0){
            return 0;
        }

        int left = recur(num, s-num[idx], idx+1);
        int right = recur(num, s+num[idx], idx+1);
        return left + right;

    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
    }
}