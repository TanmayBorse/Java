package strings;

import java.util.ArrayList;

public class subsequence {
    public static void main(String[] args) {
        // return type is void
        subseq("", "abc");

        // return type is ArrayList
        System.out.println(subseqAL("", "pqr"));
    }
/*
 *  RETURN TYPE IS VOID
 */
    static void subseq(String p, String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }
/*
 * RETURN TYPE IS ARRAYLIST
 */
    static ArrayList<String> subseqAL(String p ,String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subseqAL(p + ch, up.substring(1));
        ArrayList<String> right = subseqAL(p, up.substring(1));

        left.addAll(right);

        return left; // return right ....both list are same
    }
}
