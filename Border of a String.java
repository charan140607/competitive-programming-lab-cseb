import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        int borderLength = lps[n - 1];

        if (borderLength > 0) {
            System.out.println(s.substring(0, borderLength));
        }
    }
}
