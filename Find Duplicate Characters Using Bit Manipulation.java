import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int seen = 0;
        int duplicates = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int bit = ch - 'a';
            if ((seen & (1 << bit)) != 0) {
                if ((duplicates & (1 << bit)) == 0) {
                    if (result.length() > 0) {
                        result.append(" ");
                    }
                    result.append(ch);
                    duplicates |= (1 << bit);
                }
            } else {
                seen |= (1 << bit);
            }
        }
        if (result.length() == 0) {
            System.out.println("No duplicates");
        } else {
            System.out.println(result);
        }
        sc.close();
    }
}
