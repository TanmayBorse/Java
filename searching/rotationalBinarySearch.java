package searching;

// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/

/*
 * Rotational array : [0, 1, 2, 3, 4, 5, 7], after one rotation array will be [7, 0, 1, 2, 3, 4, 5]
 *  rotaional array {4, 5, 7, 0, 1, 2, 3}
 * here in rotational sorted array elements till 7 are sorted in ascensing order,
 * and from 0 to 3 are also sorted in ascending order, so it create 2 sorted subarray in array
 * hence we need to find the PIVOT element, which is maximum element in above array by using binary search
 * 
 * case 1: if 7 = mid and 0 = mid+1
 *          then compare mid with mid+1, if mid is greater than it is pivot
 * 
 * case 2: if 0 = mid and 7 is mid-1
 *          then compare mid with mid-1, if mid-1 is greater than mid-1 is pivot
 * 
 * case 3: if first element of array is greater than equal to mid (for unique element array) then
 *          then search for greatest element in array from start to mid -1
 *          4 > mid = 0, then search in subarray [4, 5, 7]
 * 
 * ROTATION COUNT = PIVOT index + 1;
 */

public class rotationalBinarySearch {
    public static void main(String[] args) {
        
        int[] arr = {4, 5, 7, 0, 1, 2, 3};

        System.out.println(findPivot(arr));

        System.out.println(search(arr, 5));

        int pivotCount = findPivot(arr) + 1;

        System.out.println("Rotaion count = "+ pivotCount);

    }

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0 , nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }

    // this will not work in duplicate values
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here

            //if mid is not pointing to last element AND mid > mids next
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // if mid is not pointing to first element and mid < mids previous
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}