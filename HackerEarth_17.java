import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class HackerEarth_17 {
    public static void main(String[] args){
        FastReader input = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int t = input.nextInt();

        int mod = 1000000000 + 7;
        while (t > 0){
            long n = input.nextLong();

            long base = 2;
            long pow = n;

            long res = 1;

            while (pow >= 1){
                if(pow % 2 == 0){
                    pow = pow / 2;
                    base = ((base % mod) * (base % mod)) % mod;
                }
                else{
                    pow--;
                    res = ((res % mod) *  (base % mod)) % mod;
                }
            }
            long ans = (res % mod) - 1;
            pw.println(ans);
            t--;
        }

        pw.flush();
        pw.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}



