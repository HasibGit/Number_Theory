public class Modular_Multiplication {
    static long mulmod(long a, long b,
                       long mod)
    {
        long res = 0; // Initialize result
        a = a % mod;
        while (b > 0)
        {
            // If b is odd, add 'a' to result
            if (b % 2 == 1)
            {
                res = (res + a) % mod;
            }

            // Multiply 'a' with 2
            a = (a * 2) % mod;

            // Divide b by 2
            b /= 2;
        }

        // Return result
        return res % mod;
    }

    public static void main(String[] args) {
        long a = 9223372036854775807L, b = 9223372036854775807L;
        System.out.println(mulmod(a, b, 100000000000L));
    }
}
