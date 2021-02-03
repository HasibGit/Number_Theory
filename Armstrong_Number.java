/*

         1234
         number of digits = 4;
         if 1^4 + 2^4 + 3^4 + 4^4 == 1234
             then 1234 is an armstrong number

         Suppose we have a number n.
         the number of digits in n is k;
         sum = 0;
         for every digit i of n
              sum += i^k;

         if sum == n
            then it is an armstrong number..
 */


import java.util.*;
public class Armstrong_Number {

    static int countDigits(int n){
        int count = 0;
        while (true){
            n = n / 10;
            count++;
            if(n == 0){
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int n = 0;n <= 10000;n++){
            long digits = countDigits(n);
            long sum = 0;
            long temp = n;
            while (true){
                long digit = temp % 10;
                sum = sum + (long)Math.pow(digit,digits);
                temp = temp / 10;
                if(temp == 0){
                    break;
                }
            }
            if(sum == n){
                System.out.println(n + " is an armstrong number.");
            }
        }
    }
}
