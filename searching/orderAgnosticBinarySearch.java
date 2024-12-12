package searching;

public class orderAgnosticBinarySearch{

    public static void main(String[] args){
        //ascending array
        int[] arr1 = {-28, -7, -4, 0, 2, 9, 15, 23, 45, 59, 84};
        
        //descending array
        int[] arr2 = {84, 59, 45, 23, 15, 9, 2, 0, -4, -7, -28};

        int target = 23 ;

        int ans = binarysearch(arr2, target);
        System.out.println(ans);

    }

    static int binarysearch(int[] arr, int target){
/*
        for ceiling value WHAT IF condition

 *      if(target > arr1[arr.lengh - 1]){
            return -1;
        }
 */
        int start = 0;
        int end = arr.length - 1;

        // To check that array is in ascending order or not
        boolean isAscending = arr[start] < arr[end];

        while(start <= end){

            /*
            sometimes start and end value can be so big that
            it cannot fit in integer range of java hence we are not using 
            formula mid = (start + end ) / 2
            */
            int mid =  start + (end - start) / 2;
            
            if(target ==  arr[mid]){
                return mid;
            }

            if(isAscending){

                if(target < arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }

            // for array in decending order
            else{
                if(target > arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
        // return start --> if question for ceiling index
        // return end   --> if question for floor index
    }  
}
/*
 * Ceiling and Floor 
 * 
 * 1) Ceiling : is a smallest number greater than or equal to target, So at end of wjile loop insted of returning -1 return start
 *  example -  in arr1 if target is 36 then output will be index of number 45
 * 
 * WHAT IF target is greater than greatest number in array, then add this code block  return -1
 * if(target > arr1[arr.lengh - 1]){
 *      return -1;
 *  }
 * 
 * 2) Floor : is a greatest number smaller than or eual to target, So at end of while loop insted of returning -1 return end 
 *  example -  in arr1 if target is 36 then output will be index of number 23
 * 
 *  WHAT IF target is smaller than the smallest element in array, than no need of modifying code it already give -1 as output
 */


 /*
  * FOR size of array is unknown (infinite size array), then to find the target element in infinite size array we need to
  increase the size of searching array in power of two,
  1) for example in first iteration we search for target element in first two indices of original array, means our searching array
  size is 2 of element of indices 0 and 1
  2) in second search we increase the size of array from 2 to 4, and searching array indices start from 2 to end at 5.. and so on

  code-->
  // condition for target to lie in range
  while(target > arr[end]){
    int newStart = end + 1;

    //double the box value
    //end = previous end + size of box * 2

    end = end + (end - start + 1) * 2;
    start = nesStart;
  
  }


  */