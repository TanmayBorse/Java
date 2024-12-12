import java.util.Scanner;

public class number_reverse{

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("Enter number");
        int number = in.nextInt();

        int reverse = 0;

        while(number>0){
            int remain = number%10;
            reverse = reverse*10 + remain;
            number = number/10;
        }

        System.out.println(reverse);

    }
}
/*
 * suppose number is 485 then to reverse it take modulo by 10 we get remainder
 * step 1:  485 % 10 = 5     , so 5 is remainder
 * now      0 * 10 + 5             =  5
 * step 2:  48 % 10      = 8
 *          5 * 10 + 8 = 50 + 8    =  58
 * step 3:  4 % 10 = 4
 *          58 * 10 + 4 + 580 + 4  =  584
 */