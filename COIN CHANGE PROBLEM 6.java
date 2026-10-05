import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int V = sc.nextInt();
        int N = sc.nextInt();
        int[] rawCoins = new int[N];
        for (int i = 0; i < N; i++) {
            rawCoins[i] = sc.nextInt();
        }
        int[] coins = Arrays.stream(rawCoins)
                            .filter(c -> c <= V)
                            .distinct()
                            .sorted()
                            .toArray();
        final int INF = V + 1;
        int[] dp = new int[V + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int coin : coins) {
            for (int amount = coin; amount <= V; amount++) {
                dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
            }
        }
        if (dp[V] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[V]);
        }
        sc.close();
    }
}
