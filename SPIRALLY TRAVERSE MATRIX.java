import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        StringBuilder result = new StringBuilder();

        while (top <= bottom && left <= right) {

            // Left to Right
            for (int j = left; j <= right; j++) {
                result.append(a[top][j]).append(" ");
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                result.append(a[i][right]).append(" ");
            }
            right--;

            // Right to Left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.append(a[bottom][j]).append(" ");
                }
                bottom--;
            }

            // Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.append(a[i][left]).append(" ");
                }
                left++;
            }
        }

        System.out.println(result.toString().trim());
    }
}
