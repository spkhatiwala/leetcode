public class BinarySearch {
    static int binarySearch(int[] arr, int lo, int hi, int element){
        int mid = (lo + hi)/2;
        if(arr[mid] == element)
            return mid;
        if(lo < hi){
            if(arr[mid] >element){
              return  binarySearch(arr, lo, mid, element);
            }else{
                return binarySearch(arr, mid, hi,  element);
            }
        }else
            return -1;
    }


}
