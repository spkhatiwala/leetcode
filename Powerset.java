import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {

   /* static  List<List<String>>  powerset(List<String> words, int idx){
        if(idx==words.size()) {
            List<String> ls = new ArrayList<>();
            return Arrays.asList(ls);
        }
        List<List<String>> lists = new ArrayList<>();
        List<List<String>> ll =  powerset(words,idx+1);

        List<List<String>> ll2 = new ArrayList<>();
        for(List<String> list: ll){
            List<String> ls = new ArrayList<>();
            for(String str:list){
                ls.add(str);
            }
            ll2.add(ls);
        }

        lists.addAll(ll);
        lists.addAll(ll2.stream().map(x -> {
                                        x.add(words.get(idx));
                                        return x;
                                    }).collect(Collectors.toList()));
        return lists;
    }*/

    static  List<List<String>>  powerset(List<String> words, int idx){

        if(idx == words.size()){
            List<List<String>> ll = new ArrayList<>();
            ll.add(new ArrayList<>());
            return ll;
        }
        List<List<String>> retListofLists = new ArrayList<>();
        List<List<String>> listofLists = powerset(words, idx +1);

        for(List list: listofLists){
            List<String> ll = new ArrayList<>(list);
            retListofLists.add(ll);
        }
        for(List list: listofLists){
            List<String> ll = new ArrayList<>(list);
            ll.add(words.get(idx));
            retListofLists.add(ll);
        }
        return retListofLists;
    }




    public static void main(String[] args) {
        List<List<String>> listOfLists = powerset(Arrays.asList("a", "b", "c"), 0);

        System.out.println("hhhh");
    }

}
