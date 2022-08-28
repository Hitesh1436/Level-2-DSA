// -------------------- PEPCODING--------------------------


import java.io.*;
import java.util.*;

public class Main{
    public static int countBinaryStrings(int n){
        int zero =1;
        int one = 1;
        for(int i=2;i<=n;i++){
            int none = zero + one;
            int nzero = one;
            
            zero = nzero;
            one = none;
        }
        return (zero + one);
    }

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int ans = countBinaryStrings(n);
    System.out.println(ans);
 }

}