import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class HackerEarth_6 {
    static int mod = 1000003;

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] fact = new long[mod + 1];
        fact[0] = 1;
        for (int i = 1; i < mod; i++) {
            fact[i] = (i * fact[i - 1]) % mod;
        }
        while (t > 0) {
            long n = in.nextLong();
            long x = in.nextLong();
            if (n >= mod) {
                System.out.println(0);
            } else {
                System.out.println(((x % mod) * (fact[(int) n] % mod)) % mod);
            }
            t--;
        }
    }
}
