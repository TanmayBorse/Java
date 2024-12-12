/*
 * Quick sort is unstable algorithm, it is Inplace, merge sort is not inplce algorithm, merge sort takes O(n) extra place
 * Merge sort is better in linklist due to memory allocation (not countineous)
 */
package RecursionSorting;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 8, 2, 6, 1, 3, 7 };
        sort(nums, 0, nums.length-1);

        System.out.println(Arrays.toString(nums));

    }

    static void sort(int[] nums, int low, int high){

        // if pointers cross each other
        if(high <= low){
            return;
        }

        int start = low;
        int end = high;

        // pivot is middle element
        int pivot = nums[start + (end - start ) /2];

        while(start <= end){
            while(nums[start] < pivot){
                start++;
            }
            while(nums[end] > pivot){
                end--;
            }

            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        // now pivot is on correct postion now sort the remaining two halves os array
        sort(nums, low, end);
        sort(nums, start, high);
    }
}
