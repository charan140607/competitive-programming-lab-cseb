import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int K = sc.nextInt();
        long result = N ^ (1L << K);
        System.out.println(result);
        sc.close();
    }
}
