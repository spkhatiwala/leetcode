import java.util.Arrays;

class Solution {
    public static String intToRoman(int num) {
        String s="";
        while(num!=0){
            if(num>1000){
                s = s + "M";
                num = num - 1000;
                continue;
            }else if(num>900){
                s = s + "CM";
                num = num - 900;
                continue;
            }else if(num>500){
                s = s + "D";
                num = num - 500;
                continue;
            }else if(num>400){
                s = s + "CD";
                num = num - 400;
                continue;
            }else if(num>100){
                s = s + "C";
                num = num - 100;
                continue;
            }else if(num>90){
                s = s + "XC";
                num = num - 90;
                continue;
            }else if (num>50){
                s = s + "L";
                num = num - 50;
                continue;
            }else if(num>40){
                s = s + "XL";
                num = num - 40;
                continue;
            }else if(num>10){
                s = s + "X";
                num = num - 10;
                continue;
            }else if(num>9){
                s = s + "IX";
                num = num - 9;
                continue;
            }else if(num>5){
                s = s + "V";
                num = num - 5;
                continue;
            }else if(num>4){
                s = s + "IV";
                num = num -4;
                continue;
            }else if(num>=1){
                s = s + "I";
                num = num - 1;
                continue;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("11.22.33".split("\\.")));
        //Map<String, Integer> map = new HashMap<>();
        //map.put("a", map.getOrDefault("a", 0));


        //System.out.println(intToRoman(3));
    }
}