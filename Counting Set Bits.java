import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        int count = 0;

        while (N > 0) {
            N = N & (N - 1); 
            count++;
        }

        System.out.println(count);

        sc.close();
    }
}
