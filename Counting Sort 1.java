import java.util.Scanner;
public class Solution {
    public static int[] countingSort(int[] arr) {
        int[] count = new int[100];
        for (int num : arr) {
            count[num]++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = countingSort(arr);
        for (int i = 0; i < 100; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}
