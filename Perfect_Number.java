/*
  suppose n has divisors, 1,a,b,c,d,..,n;
  n will be a perfect number if 1+a+b+c+d+.. = n  ;excluding n
  *1 is not a perfect number as its only divisor is itself
  * and for 0, all nonzero numbers are divisors of 0, and their sum will never be equal to
  * 0,so zero is also not a perfect number
 */

import java.util.*;
public class Perfect_Number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for(int n = 2;n <= 10000;n++){
            int total = 1;
            for(int i = 2;i * i <= n;i++){
                if(n % i == 0){
                    if(n / i == i){
                        total += i;
                    }
                    else{
                        total = total + i + (n / i);
                    }
                }
            }
            if(total == n){
                System.out.println(n + " " + "Perfect Number");
            }
        }

    }
}
