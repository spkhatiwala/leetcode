import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {


    static class ParenthesesString {
        String str;
        int openCount; // open parentheses count
        int closeCount; // close parentheses count

        public ParenthesesString(String s, int openCount, int closeCount) {
            str = s;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("",0,0));
        while(!queue.isEmpty()){
            ParenthesesString prStr = queue.poll();
            if(prStr.openCount < num) {
                queue.add(new ParenthesesString(prStr.str + "(", prStr.openCount + 1, prStr.closeCount));
            }
            if(prStr.openCount > prStr.closeCount){
                ParenthesesString tmp = new ParenthesesString(prStr.str + ")", prStr.openCount , prStr.closeCount + 1);
                if(tmp.closeCount == num)
                    result.add(tmp.str);
                else
                    queue.add(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
