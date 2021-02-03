/*
    Help Oz
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class HackerEarth_5 {


    public static void main(String[] args) {
        FastReader input = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        // code goes here


        int n = input.nextInt();
        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int diff = max - min;

        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for (int i = 2; i * i <= diff; i++) {
            if (diff % i == 0) {
                int d1 = i;
                int d2 = diff / i;
                divisors.add(d1);
                if (d1 != d2) {
                    divisors.add(d2);
                }
            }
        }

        divisors.add(diff);

        Collections.sort(divisors);

        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i : divisors) {
            int k = arr[0] % i;
            boolean con = true;
            for (int j = 1; j < n; j++) {
                if (arr[j] % i != k) {
                    con = false;
                    break;
                }
            }
            if (con) {
                res.add(i);
            }
        }

        for (int i : res) {
            pw.print(i + " ");
        }
        pw.println();
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
