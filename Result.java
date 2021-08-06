package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Result {

    /*
     * Complete the 'doesCircleExist' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY commands as parameter.
     */

    public static List<String> doesCircleExist(List<String> commands) {
        int [][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int x=0;
        int y=0;
        int idx =0;
        List<String> list = new ArrayList<>();
        for(String command: commands){
            x=0;
            y=0;
            idx=0;
            for(char str: command.toCharArray()){
                if( str == 'L'){
                    idx = (idx+3) %4;
                }else if(str == 'R'){
                    idx = (idx +1) %4;
                }else{
                    x += directions[idx] [0];
                    y += directions[idx] [1];
                }
            }
            if((x==0 && y==0) || (idx !=0))
                list.add("YES");
            else
                list.add("NO");
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(doesCircleExist(Arrays.asList("GGGGR","RGL")));
    }
}