import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {
        return recur(nums, 0);
    }
    public static List<List<Integer>> recur(int[] nums, int idx) {
        if(idx== nums.length){
            List<List<Integer>> ll = new ArrayList<>();
            List<Integer> ll2 = new ArrayList<>();
            ll.add(ll2);
            return ll;
        }
        List<List<Integer>> retList = new ArrayList<>();
        List<List<Integer>> ll = recur(nums, idx+1);
        for(List<Integer> lst: ll){
            for(int k=0; k<=lst.size(); k++){
                List<Integer> xx = new ArrayList<>(lst);
                xx.add(nums[idx]);
                retList.add(xx);
            }
        }
        return retList;
    }

    static List<List<Character>> recur(char[] chars, int idx){
        if(idx== chars.length){
            List<List<Character>> ll = new ArrayList<>();
            ll.add(new ArrayList<Character>());
            return ll;
        }
        List<List<Character>> retList = new ArrayList<>();
        // recur of all the elements without the current one.
        List<List<Character>> ll = recur(chars, idx+1);
        for(List<Character> list: ll){
            for(int k=0; k< list.size(); k++){
                List<Character> newList = new ArrayList<>(list);
                newList.add(chars[idx]);
                retList.add(newList);
            }
        }
        return retList;
    }

    public static List<List<Integer>> findPermutations2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i=0; i< nums.length; i++){
            List<List<Integer>> tmpResult = new ArrayList<>();
            //go thru each list.
            for(List<Integer> lst: result){
                for(int k=0; k<= lst.size(); k++){
                    List<Integer> newList = new ArrayList<>(lst);
                    newList.add(k, nums[i]);
                    tmpResult.add(newList);
                }
            }
            result = tmpResult;
        }
        return result;
    }



    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations2(new int[] { 1,2,5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
