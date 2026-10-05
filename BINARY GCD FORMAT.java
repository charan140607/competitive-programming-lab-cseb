import java.util.Scanner;
public class binarygcd {
    static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int common = 1;
        while (a % 2 == 0 && b % 2 == 0) {
            a = a / 2;
            b = b / 2;
            common = common * 2;
        }
        while (a % 2 == 0) {
            a = a / 2;
        }
        while(b!=0){
            while (b % 2 == 0) {
                b = b / 2;
            }
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a * common;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
        sc.close();
    }
}
