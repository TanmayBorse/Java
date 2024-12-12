package searching;
import java.util.Arrays;

public class searchInstring{

    public static void main(String[] args){

        String name = "Tanmay";
        char target = 'n';

        System.out.println(search(name, target));

        // To print string in a character array output will be [T, a, n, m, a, y]
        System.out.println(Arrays.toString(name.toCharArray()));
    }

    static boolean search(String str, char target){

        if(str.length() == 0){
            return false;
        }

        for (int i = 0; i< str.length(); i++){
            if(target == str.charAt(i)){
                return true;
            }
        }

        return false;

    }
}