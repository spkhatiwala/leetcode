class RemoveDuplicates {

    public static int remove(int[] arr) {
        int left = 0;
        int right =1;
        while(right< arr.length){
            if(arr[right] != arr[left]){
                left++;
                arr[left] = arr[right];
            }
            right++;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2 , 2 , 2, 4,5,6,9,9,9,9,9,9,9,9,10,10 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}