import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class EvaluateExpression {
    public int calculate(String s) {
        //split strings into numbers and operators
        //"a+b-c*d/e" to        [a, +, b, -, c, *, d, /, e] 
        String [] result = s.replaceAll("\\s", "").split("(?<=[-+*/])|(?=[-+*/])");
        List<String> lst = infixToPostFix(result);
        System.out.println(Arrays.toString(lst.toArray()));
        return postFixEval(lst);
    }

    static int prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public List<String> infixToPostFix(String [] sArr){
        //operators in order of precedence. for ')' precedence is irrelevant.
        List<String> operatorList = Arrays.asList(")", "(", "-", "+", "/", "*");
        Stack<String> stack = new Stack<>();
        List<String> postFixList = new ArrayList<>();
        for(String s: sArr){
            if(! operatorList.contains(s)){
                postFixList.add(s);
            }else if(s.equals("(")){
                stack.push(s);
            }else if(s.equals(")")){
                String token = stack.pop();
                while(!stack.isEmpty()){
                    postFixList.add(token);
                    token = stack.pop();
                }
            }else{
                while(!stack.isEmpty() && prec(stack.peek().charAt(0)) >= prec(s.charAt(0))){
                    postFixList.add(stack.pop());
                }
                stack.push(s);
            }
        }

        while(!stack.isEmpty()){
            postFixList.add(stack.pop());
        }

        return postFixList;
    }

    public int postFixEval(List<String> list){
        Stack<Integer> stack = new Stack<>();
        List<String> operatorList = Arrays.asList( "-", "+", "/", "*");
        for(String token: list){
            if(! operatorList.contains(token)){
                stack.push(Integer.parseInt(token));
            }else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = calculate(token, operand1, operand2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public int calculate(String op, int op1, int op2){
        if (op.equals("*"))
            return op1 * op2;
        else if(op.equals("/"))
            return op1 / op2;
        else if(op.equals("+"))
            return op1 + op2;
        else
            return op1 - op2;
    }

}