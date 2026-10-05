import java.io.*;
import java.util.*;
public class Main {
    public static int isMatch(String s, String p) {
        int i = 0, j = 0;
        int star = -1;     
        int match = 0;    
        while (i < s.length()) {
            if (j < p.length() &&
                (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }
            else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }
            else {
                return 0;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length() ? 1 : 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        s = s.trim();
        p = p.trim();
        System.out.println(isMatch(s, p));
    }
}
