import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n= sc.nextInt();
       int arr[]=new int[n];
       for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
       }
       int flag=0;
       for(int i=0;i<n;i++){
        int count=0;
        for(int j=i;j<n;j++){
            if(arr[i]==arr[j]){
                count++;
            }
        }
        if(count>n/2){
            System.out.print(arr[i]);
            flag=1;
            break;
        }
       }
        if(flag==0){
            System.out.print(-1);
       }
    }
}
