import java.util.Scanner;
public class Solution {
    public static void countingSort(int[] arr) {
        int[] count = new int[100];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 0; i < 100; i++) {
            while (count[i] > 0) {
                System.out.print(i + " ");
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        countingSort(arr);
        sc.close();
    }
}
