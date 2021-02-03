import java.util.*;
public class Binary_Exponentiation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long base = input.nextLong();
        long pow = input.nextLong();
        long res = 1;

        while (pow >= 1){
            if(pow == 1){
                res = res * base;
                break;
            }
            else{
                if(pow % 2 == 0){
                    base = base * base;
                    pow = pow / 2;
                }
                else{
                    res = res * base;
                    pow--;
                }
            }
        }
        System.out.println(res);
    }
}
