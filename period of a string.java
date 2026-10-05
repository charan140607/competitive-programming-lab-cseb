import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while(i<n){
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = len + 1;
                len++;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        int period = n - lps[n - 1];
        if (n % period != 0) {
            period = n;
        }
        System.out.println(period);
        sc.close();
    }
}
