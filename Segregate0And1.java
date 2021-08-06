public class Segregate0And1 {

    /*Function to put all 0s on left and all 1s on right*/
    void segregate0and1(int arr[], int size)
    {
        int left = 0;
        int right = size - 1;
        while(left < right){
            while(arr[left] !=1 && left< right){
                left ++;
            }
            while(arr[right] !=0 && left < right){
                right --;
            }
            if(left != right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left ++;
                right -- ;
            }
        }
    }

    /* Driver Program to test above functions */
    public static void main(String[] args)
    {
        Segregate0And1 seg = new Segregate0And1();
        int arr[] = new int[]{0, 1, 0, 1, 1, 1};
        int i, arr_size = arr.length;

        seg.segregate0and1(arr, arr_size);

        System.out.print("Array after segregation is ");
        for (i = 0; i < 6; i++)
            System.out.print(arr[i] + " ");
    }
}
