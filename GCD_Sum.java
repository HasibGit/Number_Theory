/*
          for any given N
          we have to cal.
          gcd(1,N) + gcd(2,N) + gcd(3,N) + .. + gcd(N,N)
 */

import java.io.*;
import java.util.*;

public class GCD_Sum {
    public static void main(String[] args) throws IOException{
        Reader input = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        // code goes here
        long[] phi  = new long[1000000 + 1];

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

        // cal. all the phi values from 1 to 10^6

        for(int i = 1;i <= 1000000;i++){
            int n = i;
            Set<Integer> set = new HashSet<Integer>();
            long res = n;
            if(n == 1){
                phi[i] = res;
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

            for(int j : set){
                res = res / j;
                res = res * (j-1);
            }
            phi[i] = res;
        }

        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            long res = 0;
            for(int i = 1;i * i <= n;i++){
                if(n % i == 0){
                    int d1 = i;
                    int d2 = n / i;
                    res += d1 * phi[n / d1];
                    if(d1 != d2){
                        res += d2 * phi[n / d2];
                    }
                }
            }
            System.out.println(res);
            t--;
        }
        pw.flush();
        pw.close();
    }
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}

