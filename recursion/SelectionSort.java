package recursion;

import java.util.Arrays;

public class SelectionSort {
    
    public static void main(String[] args) {

        int[] arr = { 4, 2, 3, 1};

        selection(arr, arr.length, 0, 0);

        System.out.println(Arrays.toString(arr));
        
    }

    static void selection(int[] arr, int row, int col, int max){

        if(row == 0){
            return;
        }

        if(col < row){

            if(arr[col] > arr[max]){
                selection(arr, row, col+1, col);
            }
            else{
                selection(arr, row, col+1, max);
            }

        }
        else{
            int temp = arr[max];
            arr[max] = arr[row-1];
            arr[row-1] = temp;

            selection(arr, row-1, 0, 0);
        }

    }
}

/*
 * 
 * in every iteration we are checking the maximum element
 * 
 *      c   c+1 ...
 *      4   3   2   1
 * 
 * on every line initially assuming first element as maximum element and comparing it witk=h remaining element in that iteration
 * and palcing the maximum element in last of row
 *      
 *      2 3 1 4
 *      2 1 3
 *      1 2
 *      1
 * 
 * in each funtion call we are passing maximum element in iteration to next funtion call
 */