

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<>());
        int lastStart = 0;
        for(int i=0; i< nums.length; i++){
            int size = listOfLists.size();
            for (int j = 0; j < size; j++) {
                if(j >= lastStart ||nums[i]!=nums[i-1] ) {
                    List<Integer> ll = new ArrayList<>(listOfLists.get(j));
                    ll.add(nums[i]);
                    listOfLists.add(ll);
                }
            }
            lastStart = size;
        }
        return listOfLists;
    }


    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
