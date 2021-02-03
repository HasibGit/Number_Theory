/*
   As we know , any number n can be expressed as..
   n = a^p + b^q + c^r + ..
   where a,b,c are prime factors of n and p,q,r are powers.
   The sum of divisors of n will be,
   sum = (a^0 + a^1 + a^2 + ... + a^p) * (b^0 + b^1 + b^2 + .... + b^q) * (c^0 + c^1 + c^2 + ... + c^r) * ...
   So the task reduces to finding all prime factors and their powers.
 */



import java.util.Scanner;

public class Sum_Of_Divisors_Of_N {
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
            long sum = 1;
            for(int i = 2;i <= n;i++){
                if(prime[i]){
                    int count = 0;
                    if(n % i == 0){
                        while (n % i == 0){
                            n = n / i;
                            count++;
                        }
                        long total = 0;
                        for(int j = 0; j <= count;j++){
                            total = total + (long)Math.pow(i,j);
                        }
                        sum = sum * total;
                    }
                }
            }
            System.out.println(sum);
            t--;
        }
    }
}
