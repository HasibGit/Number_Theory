/*
      A prime number is a number which is only divisable by 1 and itself
      1 2 3 4 6 12
      These are the numbers that divides 12
      sqrt(12) = floor_3.46 = 3
      12 / 2 = 6
      12 / 3 = 4
      so, if we run a loop i from 2 to sqrt n, by dividing n by i, we can get rest of the divisors
      greater than n

      Math proof -
        if n is not a square number and a * b = n then
             a < sqrt(n) and b > sqrt(n), assuming a < b
        if n is a square number and a * b = n then
             a = sqrt(n) and b = sqrt(n)

        so, from 2 to sqrt(n), if any number divides n, then n is not prime
        this operation will take log n time.
 */



import java.util.*;
public class Primality_Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        boolean con = true;

        if(n == 1){
            con = false;
        }
        else{
            for(int i = 2; i * i <= n; i++){
                if(n % i == 0){
                    con = false;
                }
            }
        }
        if(con){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
