import java.io.*;
import java.util.*;
public class solution{
    public static void main(String[] args){
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        while (b != 0) {
         int temp = b;
          b = a % b;
          a = temp;
        }
        if(c>a||c>b){
            if(c%a==0){
                System.out.println("YES");
                }
              else{
                System.out.println("NO");
            }
          }
        else{
          System.out.println("NO");
    }
  }
}









