import java.util.*;

public class Main {
    static int n;
    static long[] arr;
    static long total;
    static long answer = Long.MAX_VALUE;

    static void generate(int index, int end, int count, long sum, ArrayList<Long>[] sums) {
        if (index == end) {
            sums[count].add(sum);
            return;
        }

        generate(index + 1, end, count, sum, sums);
        generate(index + 1, end, count + 1, sum + arr[index], sums);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            total += arr[i];
        }

        int mid = n / 2;

        ArrayList<Long>[] leftSums = new ArrayList[mid + 1];
        ArrayList<Long>[] rightSums = new ArrayList[n - mid + 1];

        for (int i = 0; i <= mid; i++)
            leftSums[i] = new ArrayList<>();

        for (int i = 0; i <= n - mid; i++)
            rightSums[i] = new ArrayList<>();

        generate(0, mid, 0, 0, leftSums);
        generate(mid, n, 0, 0, rightSums);

        int minCount = n / 2;
        int maxCount = (n + 1) / 2;

        for (int count = minCount; count <= maxCount; count++) {
            for (int lc = 0; lc <= mid; lc++) {
                int rc = count - lc;

                if (rc < 0 || rc > n - mid)
                    continue;

                Collections.sort(rightSums[rc]);

                for (long leftSum : leftSums[lc]) {
                    long target = total / 2 - leftSum;

                    int pos = Collections.binarySearch(rightSums[rc], target);

                    if (pos < 0)
                        pos = -pos - 1;

                    if (pos < rightSums[rc].size()) {
                        long sum = leftSum + rightSums[rc].get(pos);
                        answer = Math.min(answer, Math.abs(total - 2 * sum));
                    }

                    if (pos > 0) {
                        long sum = leftSum + rightSums[rc].get(pos - 1);
                        answer = Math.min(answer, Math.abs(total - 2 * sum));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
