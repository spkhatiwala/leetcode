class Solution {
    public static int myAtoi(String s) {
        int multiply = 1;
        long num = 0;
        boolean preceding = true;

        for(char c: s.toCharArray()){
            if(! preceding && !Character.isDigit(c))
                break;
            else if(c == '+')
                multiply = 1;
            else if(c == '-')
                multiply = -1;
            else if(preceding && !Character.isDigit(c) )
                continue;
            else if(Character.isDigit(c)){
                num = num * 10 +  Character.getNumericValue(c);
                preceding = false;
            }
        }

        num = multiply * num;
        if(num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }
}