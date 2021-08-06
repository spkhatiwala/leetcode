import java.util.*;

class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i< arr.length-2; i++){
            searchTwoSum(arr, i, listOfLists);
        }
        return listOfLists;
    }

    public static void searchTwoSum(int [] arr, int idx, List<List<Integer>> listOfLists){
        int left = idx + 1;
        int right = arr.length-1;
        int target = -1 * arr[idx];
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                listOfLists.add(Arrays.asList(arr[idx], arr[left], arr[right]));
                left++;
                right--;
                while(left < right && arr[left]== arr[left-1])
                    left++;
                while(left < right && arr[right]== arr[right+1])
                    right--;
            }else if(sum < target){
                left++;
            }else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}