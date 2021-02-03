/*
      any number n can be expressed like,
      n = a^p + b^q + c^r + ....
      where a,b,c.. are the prime factors of n and p,q,r are powers
      The number of divisors of n is = (p+1) * (q+1) * (r+1) * ...
 */


import java.util.*;
public class Number_Of_Divisors_Of_N {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] prime = new boolean[100000 + 1];

        for(int i = 2;i < prime.length-1;i++){
            prime[i] = true;
        }

        for(int i = 2;i * i < prime.length;i++){
            if(prime[i] == true){
                for(int j = i * i;j < prime.length; j += i){
                    prime[j] = false;
                }
            }
        }


        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            int total = 1;
            for(int i = 2;i <= n;i++){
                if(prime[i]){
                    int count = 0;
                    if(n % i == 0){
                        while (n % i == 0){
                            n = n / i;
                            count++;
                        }
                        total = total * (count + 1);
                    }
                }
            }
            System.out.println(total);
            t--;
        }
    }
}
