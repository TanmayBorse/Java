package strings;

/*
 *  _bcadaccak
 *  b_cadaccak
 * 
 *  String before _ is processed string means uptil that character string is processed
 *  String after _ is unprocessed string
 *  
 *  once character 'a' is occured string will skip that charachter
 * 
 */

public class skipChar {
    public static void main(String[] args) {

        // skip character 'a'
        skip( "", "bcadaccak");

        // to skip word apple in string
        System.out.println(skipApple("cjkappleckm"));
        
    }
    // p : process string, up : unprocessed string

    static void skip(String p, String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        // ch pointing to first chracter of unporcessed string
        char ch = up.charAt(0);

        if(ch == 'a'){
            // if ch = a then p string will remain as it is
            // and up will be start from index 1 (increment unprocess string)
            skip(p, up.substring(1));
        }
        else{
            // else add ch in p
            // incerement up from index 1
            skip(p+ch, up.substring(1));
        }
    }

    static String skipApple(String up){

        if(up.isEmpty()){
            System.out.println(up);
            return "";
        }

        if(up.startsWith("apple")){

            return skipApple(up.substring(5));
        }
        else{
            
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }
}
