import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HackerEarth_8 {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        // code goes here

        long mod = 1000000000 + 7;

        int t = input.nextInt();

        while (t > 0) {
            long n = input.nextLong();

            long ans = ((n % mod) * (((2 % mod * n % mod) % mod) - 1)) % mod;
            pw.println(ans);
            t--;
        }


        pw.flush();
        pw.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
