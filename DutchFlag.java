class DutchFlag {

    public static void sort(int[] arr) {

    }

    static int partition(int []arr, int low,
                         int high)
    {
        int pivot = arr[high];

        // Index of smaller element
        int i = (low - 1);

        for (int j = low; j <= high- 1; j++)
        {
            // If current element is smaller
            // than or equal to pivot
            if (arr[j] <= pivot)
            {
                i++; // increment index of
                // smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    public static void sort2(int[] arr) {

        int smaller=0;
        for(int i=0; i< arr.length; i++){
            if(arr[i] < 1){
                swap(arr, smaller, i);
                smaller ++;
            }
        }

        int large=arr.length -1;
        for(int i= arr.length-1 ; i>=0 && arr[i] >= 1; i--){
            if(arr[i] > 1) {
                swap(arr, large, i);
                large -- ;
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        partition(arr, 0 , 2);
        DutchFlag.sort2(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort2(arr);
        for (int num : arr)
            System.out.print(num + " ");

    }
}
