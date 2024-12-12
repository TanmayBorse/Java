/*
 * Magical number: 
 * 
 * Here Number n = 3, and base system is 5;
 * 
 * so 3 in binary is 011
 * 
 * Hence it is in decimal is 0*125 + 1*25 + 1*5 = 30
 * 
 */
public class MagicNumber {
    
    public static void main(String[] args) {
        int n = 3;
        int base = 5;
        int ans = 0;

        while(n > 0){

            // n & 1 (n multiply 1) gives last digit in binary system... 011 & 1 = 1
            int lastDigit = n & 1;
            
            // To ignore last digit we right shift binary number to 1 place hence 011 >> 1 = 01
            n = n >> 1;

            //for 1st iteration 0 = 0 + 1*5
            //for 2nd iteration 5 = 5 + 1*25
            ans = ans + lastDigit * base;

            // initially base was 5, now to upgrade base multiply with original base
            //after 1st iteration base will be 25
            base = base * 5;

        }

        System.out.println(ans);
    }
}