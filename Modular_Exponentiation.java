import java.util.Scanner;

public class Modular_Exponentiation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long base = input.nextLong();
        long pow = input.nextLong();
        long mod = input.nextLong();
        long res = 1;

        while (pow >= 1){
            if(pow == 1){
                res = (res * base) % mod;
                break;
            }
            else{
                if(pow % 2 == 0){
                    base = (base * base) % mod;
                    pow = pow / 2;
                }
                else{
                    res = (res * base) % mod;
                    pow--;
                }
            }
        }
        System.out.println(res);
    }
}
