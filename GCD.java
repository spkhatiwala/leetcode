// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class GCD
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int gcd(int a, int b){
        if(a==0)
            return b;
        else
            return gcd(b%a , a);
    }

    public int generalizedGCD(int num, int[] arr)
    {
        if(num ==0)
            return 0;
        if(num==1)
            return arr[0];
        int gcd=arr[0];
        for(int i=0; i<arr.length-2; i++){
            gcd= gcd(gcd, arr[i+1]);
        }
        return gcd;
        // WRITE YOUR CODE HERE
    }
    public static void main(String[] args) {

    }
    // METHOD SIGNATURE ENDS
}