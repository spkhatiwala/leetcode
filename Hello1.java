import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Hello1 {


    public static void main(String[] args) throws UnsupportedEncodingException {
        /*int n = 8;
        int k = 1;
        Random rand = new Random();
        // The array to be smaples
        int input[] = {1, 7, 4, 8, 2, 6, 5, 9};
        int output[] = new int[k];
        for(int i = 0; i<k; i++){
            output[i] = input[i];
        }
        for(int i= k; i<n; i++){
            int idx = rand.nextInt(i+1);
            if(idx<k){
                output[idx]= input[i];
            }
        }
        System.out.println(Arrays.toString(output));
        System.out.println(Math.random());*/
        char aa = '\u0905';
        System.out.println(aa + " result");
        String unicodeMessage =
                "\u7686\u3055\u3093\u3001\u3053\u3093\u306b\u3061\u306f";
        System.out.println(unicodeMessage);
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        out.println(unicodeMessage);

    }
}
