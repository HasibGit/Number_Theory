import java.io.PrintWriter;
import java.util.*;

public class HackerRank_10 {

    static int findGcd(int[] arr) {
        int g = arr[0];

        for (int i = 1; i < arr.length; i++) {
            g = gcd(g, arr[i]);
        }
        return g;
    }


    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }


    static long modularExpo(long a, long b, int mod) {

        long res = 1;

        while (true) {
            if (b == 1) {
                res = ((res % mod) * (a % mod)) % mod;
                break;
            }
            if (b % 2 == 0) {
                b = b / 2;
                a = ((a % mod) * (a % mod)) % mod;
            } else {
                b--;
                res = ((res % mod) * (a % mod)) % mod;
            }
        }
        return res % mod;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int mod = 1000000000 + 7;

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        long g = findGcd(arr);


        long f = 1;

        for (int i : arr) {
            f = ((f % mod) * (i % mod)) % mod;
        }

        long ans = modularExpo(f, g, mod);

        pw.println(ans);
        pw.flush();
        pw.close();
    }
}
