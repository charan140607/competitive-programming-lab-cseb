import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        double min = arr[0];
        double max = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        ArrayList<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (double x : arr) {
            int index;
            if (max == min) {
                index = 0;
            } else {
                index = (int) ((x - min) / (max - min) * (n - 1));
            }
            buckets[index].add(x);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        boolean first = true;
        for (int i = 0; i < n; i++) {
            for (double x : buckets[i]) {
                if (!first) {
                    System.out.print(" ");
                }
                if (x >= 0 && x < 1) {
                    System.out.printf("%.2f", x);
                } else {
                    System.out.printf("%.0f", x);
                }
                first = false;
            }
        }
    }
}
