import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = sc.nextLine().split(",");
        String pattern = sc.nextLine();
        ArrayList<String> ans = new ArrayList<>();
        for (String word : words) {
            String abbr = "";
            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    abbr += word.charAt(i);
                }
            }
            if (abbr.startsWith(pattern)) {
                ans.add(word);
            }
        }
        Collections.sort(ans);
        if (ans.size() == 0) {
            System.out.println("No match found");
        } else {
            for (String word : ans) {
                System.out.println(word);
            }
        }
    }
}
