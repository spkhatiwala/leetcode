import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        List<String> tmpList;
        permutations.add("");
        char[] charArray = str.toCharArray();
        for(int i=charArray.length-1 ; i>=0; i--){
            tmpList = new ArrayList<>();
            int size = permutations.size();
            for(String s: permutations){
                Character c = charArray[i];
                if(Character.isAlphabetic(c)){
                    tmpList.add(Character.toUpperCase(c) + s);
                    tmpList.add(Character.toLowerCase(c) + s);
                }else{
                    tmpList.add(c + s);
                }
            }
            permutations = tmpList;
        }
        return permutations;
    }


    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
