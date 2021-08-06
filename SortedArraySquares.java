class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int[] squares = new int[arr.length];
        int idx = arr.length-1;
        while(left < right){
            if(arr[left] * arr[left] < arr[right] * arr[right]){
                squares[idx] = arr[right] * arr[right];
                right--;
            }else{
                squares[idx] = arr[left] * arr[left];
                left++;
            }
            idx--;
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
