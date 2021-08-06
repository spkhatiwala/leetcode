import java.util.Arrays;

public class QuickSort {
        public static int[] sortArray(int[] nums) {
            //quickSortLamuto(nums, 0 , nums.length-1);
            //quickSortHoareLeftPartition(nums, 0 ,nums.length-1);
            //quickSortHoareMidPartition(nums, 0 ,nums.length-1);
            quickSortHoareMidPartition(nums, 0 ,nums.length-1);
            return nums;
        }
        static void quickSortHoareMidPartition(int[] arr, int low, int high){
            if(low < high){
                int partition = partitionHoareMid(arr, low, high);
                if(partition > low)
                    quickSortHoareMidPartition(arr, low, partition);
                if(partition < high)
                    quickSortHoareMidPartition(arr, partition+1 , high);
            }
        }
        static int partitionHoareMid(int [] arr, int low, int high){
            int pivot = arr[low + (high-low)/2];
            int i=low-1;
            int j=high+1;
            while(true){
                do{
                    i++;
                }while(arr[i] < pivot);

                do{
                    j--;
                }while(arr[j] > pivot);

                if(i<j) {
                    swap(arr, i, j);
                }else{
                    return j;
                }
            }
        }
        static void quickSortLamuto(int[] arr, int low, int high){
            if(low < high){
                int partition = partitionLamuto(arr, low, high);
                if(partition > low)
                    quickSortLamuto(arr, low, partition-1);
                if(partition < high)
                    quickSortLamuto(arr, partition+1 , high);
            }
        }
        static int partitionLamuto(int [] arr, int low, int high){
            //Lamuto
            int pivot = arr[high];
            int i = low;
            for(int j=low; j<high; j++){
                if(arr[j] < pivot){
                    swap(arr, i, j);
                    i++;
                }
            }
            swap(arr, i, high);
            return i;
        }
        static void quickSortHoareLeftPartition(int[] arr, int low, int high){
            if(low < high){
                int partition = partitionHoareLeft(arr, low, high);
                if(partition > low)
                    quickSortHoareLeftPartition(arr, low, partition  );
                if(partition < high)
                    quickSortHoareLeftPartition(arr, partition+1 , high);
            }
        }

        static int partitionHoareLeft(int [] arr, int low, int high){
            int pivot = arr[low];
            int i=low-1;
            int j=high+1;
            while(true){
                do{
                    i++;
                }while( arr[i]<pivot);

                do{
                    j--;
                }while( arr[j] >pivot);


                if(i<j) {
                    swap(arr, i, j);
                }else{
                    return j;
                }
            }

        }
        static void swap(int[] arr, int i , int j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }


    public static void main(String[] args) {
        int [] arr = {1,10,8,5,10,33,11,22,10};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));

    }
}
