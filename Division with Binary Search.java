import java.util.*;
public class Main {
    static long divide(long x, long y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero");
        }
        boolean negative = (x < 0) ^ (y < 0);
        long a = Math.abs(x);
        long b = Math.abs(y);
        long low = 0;
        long high = a;
        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * b == a) {
                ans = mid;
                break;
            } else if (mid * b < a) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return negative ? -ans : ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();

        try {
            System.out.println(divide(x, y));
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        }
    }
}
