import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException{
       Scanner sc = new Scanner(System.in);
       int s1= sc.nextInt();
       int c[]=new int[s1];
       for(int n=0;n<s1;n++){
        c[n]=sc.nextInt();
       }
       int s2= sc.nextInt();
        int d[]=new int[s2];
        for(int n=0;n<s2;n++){
        d[n]=sc.nextInt();
        }
       int a=s1+s2;
       int arr[] = new int[a];
       int i=0;
       int j=0;
       int k=0;
       while(i<s1&&j<s2){
        if(c[i]<d[j]){
            arr[k]=c[i];
            i++;
            k++;
        }
        else{
            arr[k]=d[j];
            j++;
            k++;
        }
       }
    while(i<s1){
        arr[k]=c[i];
        i++;
        k++;
    }
    while(j<s2){
        arr[k]=d[j];
        j++;
        k++;
    }
     for(int l=0;l<a;l++){
        System.out.print(arr[l]+" ");
    }
}
}

