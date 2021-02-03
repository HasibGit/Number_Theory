/*
      Eular totient func can be used to calculate for any int N,
      the number of coprimes of N from 1 to N.
      co-prime means its gcd with N is 1.

      if N has prime factors p1,p2,p3 then
      Phy (N) = N * ((p1 - 1) / p1 ) * ( (p2 - 1) / p2 ) * ( (p3-1) / p3 );

      Cal. all prime factors of N will take sqrt(N) time
      So, Time complexity is sqrt(N)
 */


import java.util.*;
public class Eular_Totient_Function {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] prime = new int[1000000+1];
        Arrays.fill(prime,-1);
        for(int i = 2;i * i < prime.length;i++){
            if(prime[i] == -1){
                for(int j = i * i;j < prime.length; j += i){
                    if(prime[j] == -1){
                        prime[j] = i;
                    }
                }
            }
        }
        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            Set<Integer> set = new HashSet<Integer>();
            long res = n;
            if(n == 1){
                System.out.println(res);
                t--;
                continue;
            }
            while (true){
                if(prime[n] == -1){
                    set.add(n);
                    break;
                }
                else{
                    set.add(prime[n]);
                    n = n / prime[n];
                }
            }

            for(int i : set){
                res = res / i;
                res = res * (i-1);
            }
            System.out.println(res);
            t--;
        }
    }
}
