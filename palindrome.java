public class palindrome {
    
    public static void main(String[] args) {
        
        // example for ispalindrome function
        String str = "abcba";
        System.out.println(isPalindrome(str));

        //example for ispalin function
        String s = "A man, a plan, a canal: Panama";
        //explanation : amanaplana c analpanama
        System.out.println(isPalin(s));

    }

    static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        str = str.toLowerCase();
        for (int i = 0; i <= str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);

            if (start != end) {
                return false;
            }
        }
        return true;
    }

    static public boolean isPalin(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        int start = 0;
        int end = sb.length() -1;

        while(start < end){
            if(sb.charAt(start) != sb.charAt(end)){
                return false;
            }
                start++;
                end--;
        }

        return true;
    }
}
