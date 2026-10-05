import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int total = n + m;
        int mid = total / 2;

        int i = 0, j = 0, count = 0;
        long prev = 0, curr = 0;

        while (count <= mid) {
            int val;

            if (i < n && (j >= m || a[i] <= b[j])) {
                val = a[i++];
            } else {
                val = b[j++];
            }

            prev = curr;
            curr = val;
            count++;
        }

        if (total % 2 == 1) {
            // print as X.0
            System.out.println(curr + ".0");
        } else {
            long sum = prev + curr;
            long wholePart = sum / 2;
            long remainder = sum % 2;

         
            if (remainder != 0 && sum < 0) {
                wholePart -= 1;
                remainder = sum - wholePart * 2;
            }

            long decimalPart = (remainder * 10) / 2;

            System.out.println(wholePart + "." + decimalPart);
        }

        sc.close();
    }
}
