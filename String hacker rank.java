
import java.util.*;
public class Main {
    public static int solve(String A) {
        int n = A.length();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int prev = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (A.charAt(i) == A.charAt(j)) {
                    dp[j] = prev + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prev = temp;
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        System.out.println(solve(A));
        sc.close();
    }
}
