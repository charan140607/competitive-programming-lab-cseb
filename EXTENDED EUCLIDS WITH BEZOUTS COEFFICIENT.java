import java.util.*;
public class Main {
    static long x, y;
    static long gcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        long g = gcd(b, a % b);
        long temp = x;
        x = y;
        y = temp - (a / b) * y;
        return g;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long D = gcd(A, B);
        System.out.println(x + " " + y + " " + D);
    }
}
