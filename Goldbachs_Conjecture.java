/*
   Goldbach's conjecture states that-
    Every even number greater than two, can be expressed as the sum of two prime numbers.

  Goldbach's weak conjecture / goldbach's odd conjecture-
    Every odd number greater than 5 can be expressed as the sum of three prime numbers (same
    prime number can appear multiple times)
    **** if n is odd,
           if (n-2) is a prime number then,
             n can also be expressed as sum of two prime numbers.

 */


import java.util.*;
public class Goldbachs_Conjecture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] prime = new boolean[100000 + 1];

        for(int i = 2;i < prime.length;i++){
            prime[i] = true;
        }

        for(int i = 2;i * i <= Math.sqrt(100000);i++){
            if(prime[i]){
                for(int j = i * i; j <= 100000;j += i){
                    prime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int i = 0;i <= 100000;i++){
            if(prime[i]){
                primes.add(i);
            }
        }

        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            if(n % 2 == 0 && n > 2){
                for(int i : primes){
                   if(prime[n - i]){
                       System.out.println(i + " + " + (n-i) + " = " + n);
                       break;
                   }
                }
            }
            else{
                System.out.println("does not belong to the conjecture.");
            }
            t--;
        }
    }
}
