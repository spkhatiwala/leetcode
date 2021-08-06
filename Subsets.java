import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<>());
        for(int i=0; i< nums.length; i++){
            int size = listOfLists.size();;
            for(int j=0; j< size; j++){
                List<Integer> newList = new ArrayList<>(listOfLists.get(j));
                newList.add(nums[i]);
                listOfLists.add(newList);
            }
        }
        return listOfLists;
    }




    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
