package searching;

public class findMinInRotaionalBS{

    public static void main(String[] args){
        int[] nums = {4, 5, 7, 0, 1, 2, 3};

        int minElement = findPivot(nums);

        System.out.println(nums[minElement+1]);
        

    }

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
}