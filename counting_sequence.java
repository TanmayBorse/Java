import java.util.Scanner;

public class counting_sequence{

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("Enter Number ");
        int num = in.nextInt();

        System.out.println("Count for ");
        int a = in.nextInt();

        int count = 0;

        while(num>0){

            int rem = num%10;

            if (rem == a){
                count++;
            }
            num = num/10;
        }

        System.out.println("Perticular digit count in given number is " + count);
    }
}
