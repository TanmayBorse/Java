package recursion;

import java.util.Arrays;

public class BubbleSort{

    public static void main(String[] args){

        int[] arr = { 4 , 2, 3, 1};

        sort(arr, arr.length -1, 0 );

        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] arr, int row, int c){

        if(row == 0){
            return;
        }

        if(c < row){

            if(arr[c] > arr[c+1]){
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }

            sort(arr, row, c+1);
        }

        sort(arr, row-1 , 0);
    }
}

/*
 * this is like pattern of *
 *      * * * *
 *      * * *
 *      * *
 *      *
 * as last star denote sorted element in one iteration, as it is sorted so in next iteration do not consider it
 * 
 * in each iteration c means colun value is increasing in same row,
 * when last digit is sorted, then in next iteration that is row-1 don't consider that sorted element
 * 
 *      4 2 3 1
 * 
 *      2 3 1 4
 *      2 1 3
 *      1 2
 *      1
 * 
 *      1 2 3 4 ... is a final result
 * 
 */