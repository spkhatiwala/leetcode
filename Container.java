package amazon;

import java.util.*;

public class Container {
    public static Map<String, Integer> getBoxMap(char[] charArray){
        Map<String, Integer> map = new LinkedHashMap<>();
        int start=0;
        while(start< charArray.length){
            if(charArray[start] == '|') {
                break;
            }
            start++;
        }
        int k = start+1;
        int count=0;
        while(k < charArray.length){
            if(charArray[k]=='|'){
                map.put(start + "|" + k, count);
                start = k;
            }else{
                count++;
            }
            k++;
        }
        return map;
    }




    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        char[] charArray = s.toCharArray();
        List<Integer> retArray = new ArrayList<>();
        Map<String, Integer> map = getBoxMap(charArray);
        for(int i=0; i< startIndices.size(); i++) {
            int count =0;
            for(String key: map.keySet()){
                String[] arr = key.split("\\|");
                Integer start = Integer.parseInt(arr[0]);
                Integer end = Integer.parseInt(arr[1]);
                if(start>= startIndices.get(i)-1 && end<= endIndices.get(i)-1){
                    count = count + map.get(key);
                }else{
                    break;
                }
            }
            retArray.add(count);
        }
        return retArray;
    }


    public static void main(String[] args) {
        List<Integer> ll = numberOfItems("*|*|*|", Arrays.asList(1,1), Arrays.asList(1,6));
        List<Integer> ll2 = numberOfItems("|*|*|*|", Arrays.asList(1,1), Arrays.asList(1,6));
        System.out.println(ll2);
    }
}
