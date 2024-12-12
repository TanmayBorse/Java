package recursion;

import java.util.ArrayList;
import java.util.List;

public class NumSubset {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = subset(arr);
        
        for (List<Integer> list : ans) {
            System.out.println(list);            
        }
        
    }
    
    // List<List<Integer>> : [ [_], [_,_] ] is list of list containg integer values
    static List<List<Integer>> subset(int[] arr){

        List<List<Integer>> outer = new ArrayList<>(); // outer is outer list which contains list's

        outer.add(new ArrayList<>());

        for(int num : arr){

            int n = outer.size();

            for(int i = 0; i < n; i++){

                // create internal list
                List<Integer> internal = new ArrayList<>(outer.get(i));

                //outer.get(i) will create duplicate of current array
                internal.add(num);
                outer.add(internal);
            }
        }
        
        return outer;
    }
}

/*
 *  at num = 1 internal lists inside outer list will be
 *   [ [], [1]]
 *  when num = 2 we will add num 2 in all inner list and also will create copy of current list with help of .get(i) function
 *  (i) will be lists till current instance
 *   [ [], [1], [+2], [1, +2]]
 */