/*
when a * b = 1
  then b = a^-1

We are given
     (a * b) % m = 1
     here b is the modular multiplicative inverse and we have to find it.

 (a * b) % m =1
   this can be also expressed as..

  (a * x) + (m * y) = 1  [ where x and y can be any pos or neg int]
  if we can get the value of x, x will be our modular multiplicative inverse b

  Now...
     if   ax + by = gcd(a,b)
     we can get the values of x,y using ext. euclidian algo..

     we have to prove gcd(a,m) is == 1 then we can solve
        (a * x) + (m * y) = gcd(a,m) = 1;

     we are given,
         (a * b) % m = 1;
         or, (a % m) * (b % m) = 1;
         if a % m == 1 and b % m == 1 only then, (a % m) * (b * m) == 1

         So.. a % m == 1 and gcd(a,m) = 1; a and m are co-prime


     So, we solve (a * x) + (m * y) = 1

     using ext. euclidian algo and the value of x will be the modular
     multiplicative inverse..

 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Modular_Multiplicative_Inverse {


    static long d,x,y;
    static long modularExpo(long a,long b,long mod){

        long result = 1;
        while (b > 0){
            if(b % 2 == 1)
                result = (result * a) % mod;

            a = (a * a) % mod;

            b = b / 2;

        }
        return result;
    }

    static void extendedEuclid(long c,long m)
    {
        if(m == 0)
        {
            d = c;
            x = 1;
            y = 0;
        }
        else
        {
            extendedEuclid(m, c%m);
            long temp = x;
            x = y;
            y = temp - (c/m)*y;
        }
    }

    static long modInverse(long c, long m)
    {
        extendedEuclid(c,m);
        return (x%m + m) % m;
    }

    public static void main(String[] args) throws IOException {
        HackerEarh_Test1.Reader input = new HackerEarh_Test1.Reader();
        PrintWriter pw = new PrintWriter(System.out);
        // code goes here

        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();
        long mod = input.nextLong();

        long ans1 = modularExpo(a,b,mod);

        long ans2 = modInverse(c,mod);


        long ans = ((ans1 % mod) *  (ans2 % mod)) % mod;

        pw.println(ans);
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
